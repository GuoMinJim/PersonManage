package cn.pzhu.pserson.service.impl;

import cn.pzhu.pserson.dao.dao.JobMapper;
import cn.pzhu.pserson.domain.Job;
import cn.pzhu.pserson.domain.response.JobResDTO;
import cn.pzhu.pserson.service.JobService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class JobServiceImpl implements JobService {

  @Resource
  JobMapper jobMapper;

  @Override
  public void insert(Job job) {
    jobMapper.insert(job);
  }

  @Override
  public void update(Job job) {
    jobMapper.updateByPrimaryKey(job);
  }

  @Override
  public PageInfo findAll(String content, int pageNum, int pageSize) {
    PageInfo<Object> pageInfo = PageHelper.startPage(pageNum, pageSize, true)
        .doSelectPageInfo(() -> jobMapper.findAll(content));
    return pageInfo;
  }
}
