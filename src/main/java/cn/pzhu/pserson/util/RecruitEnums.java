package cn.pzhu.pserson.util;

import lombok.Data;

public enum RecruitEnums {

  WAIT_ZHUGUAN("0","待主管审批",0),
  WAIT_ROOT("1","待Boss审批",0),
  SUCCESS("2","审批成功",0);



  private String code;

  private String describe;

  private int group;

  RecruitEnums(String code, String describe, int group) {
    this.code = code;
    this.describe = describe;
    this.group = group;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescribe() {
    return describe;
  }

  public void setDescribe(String describe) {
    this.describe = describe;
  }

  public int getGroup() {
    return group;
  }

  public void setGroup(int group) {
    this.group = group;
  }
}
