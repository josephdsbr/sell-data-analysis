package com.ilegra.onechoice.models;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Builder;

import java.util.ArrayList;
import java.util.Arrays;

@Builder
public class OperationStatistics {
  Long clientsQuantity;
  Long sellersQuantity;
  Long bestSellByPrice;
  String worstSeller;

  public String[] convertToCSVFormat() {
    return new String[]{
        this.clientsQuantity.toString(),
        this.sellersQuantity.toString(),
        this.bestSellByPrice.toString(),
        this.worstSeller
    };
  }
}
