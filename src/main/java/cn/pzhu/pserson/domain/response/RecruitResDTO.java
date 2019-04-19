package cn.pzhu.pserson.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class RecruitResDTO {

  private Integer id;

  private Integer personNum;

  private String remark;

  private String status;

  private String createDate;

  private String deptName;

  private String jobName;


  private Integer deptId;

  private Integer  jobId;
}
