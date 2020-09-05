  package com.ilegra.onechoice.models.enums;

public enum FileIdentificationEnum {
  SELLER("001"),
  CLIENT("002"),
  SELL("003");

  private final String code;

  FileIdentificationEnum(String code) {
    this.code = code;
  }

  public String getCode() {
    return this.code;
  }

  public static FileIdentificationEnum identifyFileIdentification(String code) {
    for (FileIdentificationEnum fileIdentificationEnum : FileIdentificationEnum.values()) {
      if (fileIdentificationEnum.getCode().equals(code)) {
        return fileIdentificationEnum;
      }
    }
    return null;
  }
}
