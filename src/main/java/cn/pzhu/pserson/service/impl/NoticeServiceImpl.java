package cn.pzhu.pserson.service.impl;

import cn.pzhu.pserson.dao.dao.NoticeMapper;
import cn.pzhu.pserson.domain.Notice;
import cn.pzhu.pserson.service.NoticeService;
import cn.pzhu.pserson.util.DateFormate;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoticeServiceImpl implements NoticeService {

  @Resource
  NoticeMapper noticeMapper;

  @Override
  public PageInfo getNotice(int pageNum, int pageSize, String content) {
    PageInfo pageInfo = null;
    if (content == null) {
      pageInfo = PageHelper.startPage(pageNum, pageSize, true)
          .doSelectPageInfo(() -> noticeMapper.get_List());
    } else {
      pageInfo = PageHelper.startPage(pageNum, pageSize, true)
          .doSelectPageInfo(() -> noticeMapper.get_LikeList(content));
    }
    return pageInfo;
  }

  @Override
  @Transactional
  public void insertNotice(Notice notice) {
    notice.setCreateDate(DateFormate.dateToString(new Date()));
//    noticeMapper.insert_Info(notice);
    noticeMapper.insert(notice);
  }
}
