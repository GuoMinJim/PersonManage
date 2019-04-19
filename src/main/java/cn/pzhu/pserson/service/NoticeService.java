package cn.pzhu.pserson.service;

import cn.pzhu.pserson.domain.Notice;
import com.github.pagehelper.PageInfo;

public interface NoticeService {

  PageInfo getNotice(int pageNum, int pageSize, String content);


  void insertNotice(Notice notice);
}
