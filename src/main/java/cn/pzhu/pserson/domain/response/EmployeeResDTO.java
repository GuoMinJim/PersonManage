package cn.pzhu.pserson.domain.response;

import lombok.Data;

@Data
public class EmployeeResDTO {
  private Integer id;
  private Integer jobId;
  private Integer deptId;
  private String dept;
  private String job;
  private String name;
  private String cardId;
  private String address;
  private String phone;
  private String email;
  private String sex;
  private String education;
  private String remark;
  private String createDate;

  public EmployeeResDTO() {
  }

}
