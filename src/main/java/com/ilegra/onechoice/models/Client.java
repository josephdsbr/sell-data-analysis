package com.ilegra.onechoice.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ilegra.onechoice.models.pojo.StoreProcessItem;
import com.opencsv.bean.CsvBindByName;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder({ "id", "ni", "name", "businessArea" })
public class Client extends StoreProcessItem {
  @CsvBindByName(column = "ni")
  String ni;
  @CsvBindByName(column = "name")
  String name;
  @CsvBindByName(column = "businessArea")
  String businessArea;

  @Override
  public void handleParseLineToObject(String[] item) {
    this.ni = item[1];
    this.name = item[2];
    this.businessArea = item[3];
  }
}
