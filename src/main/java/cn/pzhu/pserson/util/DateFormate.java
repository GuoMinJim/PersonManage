package cn.pzhu.pserson.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormate {

  public static String dateToString(Date date) {
    SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
    String time = format.format(date);
    return time;
  }

}
