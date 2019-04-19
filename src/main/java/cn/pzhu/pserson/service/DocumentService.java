package cn.pzhu.pserson.service;

import cn.pzhu.pserson.domain.Document;
import com.github.pagehelper.PageInfo;

public interface DocumentService {

  PageInfo getDoc(int pageNum, int pageSize, String content);

  void insert(Document document, Integer id);
}
