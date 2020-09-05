package com.ilegra.onechoice.models.pojo;

public abstract class StoreProcessItem<T> {
  public abstract T handleParseLineToObject(String[] item);
}
