package com.ilegra.onechoice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationPurchase {
  List<Client> clients = new ArrayList<>();
  List<Sell> sells = new ArrayList<>();
  List<Seller> sellers = new ArrayList<>();

  public void addClientToOperation(Client client) {
    this.clients.add(client);
  }

  public void addSellsToOperation(Sell sell) {
    this.sells.add(sell);
  }

  public void addSellerToOperation(Seller seller) {
    this.sellers.add(seller);
  }

  public OperationStatistics getSellsRevenueByFile() {
    Long bestSellId = this.getTheBestSellId();
    String worstSeller = this.getTheWorstSellerName();

    return OperationStatistics
        .builder()
        .clientsQuantity((long) clients.size())
        .sellersQuantity((long) sellers.size())
        .bestSellByPrice(bestSellId)
        .worstSeller(worstSeller)
        .build();
  }

  private Long getTheBestSellId() {
    return sells.stream()
        .flatMap(sell -> sell.getItems()
            .stream()
            .map(item -> new AbstractMap.SimpleImmutableEntry<>(sell.getSaleId(), item))
        ).collect(
            Collectors.groupingBy(
                AbstractMap.SimpleImmutableEntry::getKey,
                Collectors.mapping(Map.Entry::getValue,
                    Collectors.summingDouble(Item::getPrice))
            )
        )
        .entrySet()
        .stream()
        .sorted(Map.Entry.<Long, Double>comparingByValue().reversed())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,  e2) -> e1, LinkedHashMap::new)).keySet().stream().findFirst()
        .orElse(null);
  }

  private String getTheWorstSellerName() {
    return sells.stream()
        .flatMap(sell -> sell.getItems()
            .stream()
            .map(item -> new AbstractMap.SimpleImmutableEntry<>(sell.getSalesManName(), item))
        ).collect(
            Collectors.groupingBy(
                AbstractMap.SimpleImmutableEntry::getKey,
                Collectors.mapping(Map.Entry::getValue,
                    Collectors.summingDouble(Item::getPrice))
            )
        )
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,  e2) -> e1, LinkedHashMap::new)).keySet().stream().findFirst()
        .orElse("");
  }
}
