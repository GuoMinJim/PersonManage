package cn.pzhu.pserson.domain.response;

import java.io.Serializable;
import lombok.Data;

@Data
public class IndexHeaderResDTO implements Serializable {

  private String adminNum;

  private String employeeNum;

  private String noticeNum;

  private String docNum;

  private String deptNum;
}
