package com.ilegra.onechoice.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ilegra.onechoice.models.pojo.StoreProcessItem;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder({ "id", "quantity", "price"})
public class Item extends StoreProcessItem {
  Long id;
  Long quantity;
  Double price;

  @Override
  public void handleParseLineToObject(String[] item) {
    this.id = Long.valueOf(item[0]);
    this.quantity = Long.valueOf(item[1]);
    this.price = Double.valueOf(item[2]);
  }
}
