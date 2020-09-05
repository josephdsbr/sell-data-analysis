package com.ilegra.onechoice.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ilegra.onechoice.models.pojo.StoreProcessItem;
import lombok.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder({ "id", "saleId", "items"})
public class Sell extends StoreProcessItem {
  Long saleId;
  List<Item> items;
  String salesManName;

  @Override
  public void handleParseLineToObject(String[] item) {
    this.saleId = Long.valueOf(item[1]);
    this.salesManName = item[3];
    Arrays.stream(item[2].replaceAll("[\\[\\](){}]","")
        .split(","))
        .map(t -> t.split("-"))
        .forEach(splitedItem -> {
          Item serializedItem = new Item();
          serializedItem.handleParseLineToObject(splitedItem);
          this.items.add(serializedItem);
    });
  }
}
