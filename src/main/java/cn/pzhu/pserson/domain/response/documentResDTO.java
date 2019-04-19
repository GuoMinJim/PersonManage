package cn.pzhu.pserson.domain.response;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class documentResDTO {

  private Integer id;

  private String title;

  private String filename;

  private String remark;

  private String path;

  private MultipartFile file;

  private String createDate;

  private Integer userId;

  private String user;


}
