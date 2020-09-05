package com.ilegra.onechoice.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ilegra.onechoice.models.pojo.StoreProcessItem;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder({ "id", "saleId", "items"})
public class Sell extends StoreProcessItem<Sell> {
  Long id;
  Long saleId;
  List<Item> items;

  @Override
  public Sell handleParseLineToObject(String[] item) {
    System.out.println(Sell.class);
    return null;
  }
}
