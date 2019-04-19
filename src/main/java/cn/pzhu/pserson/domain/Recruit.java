package cn.pzhu.pserson.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
public class Recruit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "dept_id")
  private Integer deptId;

  @Column(name = "job_id")
  private Integer jobId;

  @Column(name = "person_num")
  private Integer personNum;

  private String remark;

  private String status;

  @Column(name = "create_date")
  private Date createDate;

}
