package cn.pzhu.pserson.service;

import com.github.pagehelper.PageInfo;

public interface DeptService {

  PageInfo getDepts(String content,int pageNum, int pageSize);

}
