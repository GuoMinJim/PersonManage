package cn.pzhu.pserson.domain;

import javax.persistence.*;
import lombok.Data;

@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String loginname;

    private String password;

    /**
     * 级别
     */
    private String level;

    private String createdate;

    private String username;

    public String getLevel() {
        if (this.level.equals("0")) {
            return "主管";
        } else {
            return "人事";
        }
    }
}