package com.winter.enums;

public enum UserInfoBaseEnums {
  STATUS_ENABLE("1"),
  STATUS_DISABLE("2")
  ;

  private String code;

  UserInfoBaseEnums(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public static UserInfoBaseEnums ofValue(String code) {
    for (UserInfoBaseEnums uibEnums : UserInfoBaseEnums.values()) {
      if (uibEnums.getCode().equals(code)) {
        return uibEnums;
      }
    }
    return null;
  }
}
