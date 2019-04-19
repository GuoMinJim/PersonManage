package cn.pzhu.pserson.service.impl;

import cn.pzhu.pserson.dao.dao.JobMapper;
import cn.pzhu.pserson.dao.dao.RecruitMapper;
import cn.pzhu.pserson.domain.Job;
import cn.pzhu.pserson.domain.Recruit;
import cn.pzhu.pserson.domain.response.RecruitResDTO;
import cn.pzhu.pserson.service.RecruitService;
import cn.pzhu.pserson.util.RecruitEnums;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RecruitServiceImpl implements RecruitService {


  @Resource
  JobMapper jobMapper;

  @Resource
  RecruitMapper recruitMapper;

  @Override
  public List<Job> getJobList(int id) {
    return jobMapper.getJob(id);
  }

  @Override
  public void insertOne(Recruit recruit) {
    recruit.setCreateDate(new Date());
    recruit.setStatus(RecruitEnums.WAIT_ZHUGUAN.getCode());  //默认为0
    recruitMapper.insert(recruit);
  }

  @Override
  public PageInfo getRecruit(int pageNum, int pageSize, String content) {
    return PageHelper.startPage(pageNum, pageSize, true)
        .doSelectPageInfo(() -> recruitMapper.getRecruit(content));
  }

  @Override
  public void delete(Integer id) {
    recruitMapper.deleteByPrimaryKey(id);
  }

  @Override
  public RecruitResDTO getRecruit(int id) {
    return recruitMapper.getRecruitById(id);
  }
}
