package cn.pzhu.pserson.domain.response;

import java.io.Serializable;
import lombok.Data;

@Data
public class JobResDTO implements Serializable {

  private Integer id;

  private String name;

  private String remark;

  private Integer deptId;

  private String deptName;
}
