package com.ilegra.onechoice.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder({ "id", "ni", "name", "salary" })
public class Seller {
  Long id;
  String ni;
  String name;
  Double salary;
}
