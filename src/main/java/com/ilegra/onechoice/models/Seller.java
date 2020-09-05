package com.ilegra.onechoice.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ilegra.onechoice.models.pojo.StoreProcessItem;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder({ "id", "ni", "name", "salary" })
public class Seller extends StoreProcessItem<Seller> {
  Long id;
  String ni;
  String name;
  Double salary;

  @Override
  public Seller handleParseLineToObject(String[] item) {
    System.out.println(Seller.class);
    return null;
  }
}
