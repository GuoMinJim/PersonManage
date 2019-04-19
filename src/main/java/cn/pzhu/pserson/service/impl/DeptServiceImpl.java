package cn.pzhu.pserson.service.impl;

import cn.pzhu.pserson.dao.dao.DeptMapper;
import cn.pzhu.pserson.service.DeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {


  @Resource
  DeptMapper deptMapper;

  @Override
  public PageInfo getDepts(String content, int pageNum, int pageSize) {
    PageInfo<Object> pageInfo = PageHelper.startPage(pageNum, pageSize, true)
        .doSelectPageInfo(() -> deptMapper.getDepts(content));
    return pageInfo;
  }
}
