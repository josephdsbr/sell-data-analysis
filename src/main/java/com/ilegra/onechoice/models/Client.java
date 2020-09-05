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
public class Client extends StoreProcessItem<Client> {
  @CsvBindByName(column = "id")
  Long id;
  @CsvBindByName(column = "ni")
  String ni;
  @CsvBindByName(column = "name")
  String name;
  @CsvBindByName(column = "businessArea")
  String businessArea;

  @Override
  public Client handleParseLineToObject(String[] item) {
    System.out.println(Client.class);
    return null;
  }
}
