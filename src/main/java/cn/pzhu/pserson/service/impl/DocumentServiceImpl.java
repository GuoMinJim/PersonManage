package cn.pzhu.pserson.service.impl;

import cn.pzhu.pserson.dao.dao.DocumentMapper;
import cn.pzhu.pserson.domain.Document;
import cn.pzhu.pserson.service.DocumentService;
import cn.pzhu.pserson.util.DateFormate;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {

  @Resource
  DocumentMapper documentMapper;

  @Override
  public PageInfo getDoc(int pageNum, int pageSize, String content) {
    PageInfo pageInfo = null;
    if (content == null) {
      pageInfo = PageHelper.startPage(pageNum, pageSize, true)
          .doSelectPageInfo(() -> documentMapper.selectById(content));
    } else {
      pageInfo = PageHelper.startPage(pageNum, pageSize, true)
          .doSelectPageInfo(() -> documentMapper.selectById(content));
    }
    return pageInfo;
  }

  @Override
  public void insert(Document document, Integer id) {
//    document.setUserId(id);
    document.setCreateDate(DateFormate.dateToString(new Date()));
    documentMapper.insert(document);
  }
}
