package cn.pzhu.pserson.util;

import java.util.UUID;

public class Constants {

  // 数据库表常量
  public static final String USERTABLE = "user";
  public static final String DEPTTABLE = "dept";
  public static final String JOBTABLE = "job";
  public static final String EMPLOYEETABLE = "employee";
  public static final String NOTICETABLE = "notice";
  public static final String DOCUMENTTABLE = "document";

  // 登录
  public static final String LOGIN = "loginForm";
  // 用户的session对象
  public static final String USER_SESSION = "user_session";

  // 默认每页4条数据
  public static int PAGE_DEFAULT_SIZE = 4;

  public static final String JWT_SECRET = "";

  public static final int JWT_TTL = 60 * 60 * 1000;

  public static final String JWT_ID = UUID.randomUUID().toString();

  public static final int JWT_REFRESH_INTERVAL = 55 * 60 * 1000;  //millisecond
  public static final int JWT_REFRESH_TTL = 12 * 60 * 60 * 1000;  //millisecond
}
