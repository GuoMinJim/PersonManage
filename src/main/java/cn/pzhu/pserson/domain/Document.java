package cn.pzhu.pserson.domain;

import javax.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String filename;

    private String remark;

    private String path;

    private MultipartFile file;

    @Column(name = "create_date")
    private String createDate;

    @Column(name = "user_id")
    private Integer userId;


}