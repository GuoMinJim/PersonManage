package cn.pzhu.pserson.domain;

import javax.persistence.*;
import lombok.Data;

@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dept_id")
    private Integer deptId;

    @Column(name = "job_id")
    private Integer jobId;

    private String name;

    @Column(name = "cardId")
    private String cardId;

    private String address;


    private String phone;


    private String email;

    private String sex;


    private String education;


    private String remark;

    @Column(name = "createDate")
    private String createDate;

}