package cn.pzhu.pserson.service;

import cn.pzhu.pserson.domain.Job;
import cn.pzhu.pserson.domain.response.JobResDTO;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface JobService {

  void insert(Job job);

  void update(Job job);

  PageInfo findAll(String content, int pageNum, int pageSize);

}
