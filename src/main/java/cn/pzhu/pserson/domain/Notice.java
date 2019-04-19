package cn.pzhu.pserson.domain;

import javax.persistence.*;
import lombok.Data;

@Data
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "createDate")
    private String createDate;

    @Column(name = "user_id")
    private Integer userId;

    private String content;

}