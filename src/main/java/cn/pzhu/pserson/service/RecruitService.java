package cn.pzhu.pserson.service;

import cn.pzhu.pserson.domain.Job;
import cn.pzhu.pserson.domain.Recruit;
import cn.pzhu.pserson.domain.request.RecruitReqDTO;
import cn.pzhu.pserson.domain.response.RecruitResDTO;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface RecruitService {

  List<Job> getJobList(int id);

  void insertOne(Recruit recruit);

  PageInfo getRecruit(int pageNum,int pageSize,String content);

  void delete(Integer id);

  RecruitResDTO getRecruit(int id);
}
