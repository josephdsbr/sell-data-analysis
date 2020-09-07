package com.ilegra.onechoice.models;

import lombok.Builder;

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
