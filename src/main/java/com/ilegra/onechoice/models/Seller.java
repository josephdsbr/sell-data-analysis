package com.ilegra.onechoice.models;

import com.ilegra.onechoice.models.pojo.StoreProcessItem;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Seller extends StoreProcessItem {
  String ni;
  String name;
  Double salary;

  @Override
  public void handleParseLineToObject(String[] item) {
    this.ni = item[1];
    this.name = item[2];
    this.salary = Double.valueOf(item[3]);
  }
}
