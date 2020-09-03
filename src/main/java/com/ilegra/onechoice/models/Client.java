package com.ilegra.onechoice.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder({ "id", "ni", "name", "businessArea" })
public class Client {
  @CsvBindByName(column = "id")
  Long id;
  @CsvBindByName(column = "ni")
  String ni;
  String name;
  String businessArea;
}
