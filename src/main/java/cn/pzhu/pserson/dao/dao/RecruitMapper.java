package cn.pzhu.pserson.dao.dao;

import cn.pzhu.pserson.domain.Recruit;
import cn.pzhu.pserson.domain.response.RecruitResDTO;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

public interface RecruitMapper extends Mapper<Recruit> {

  List<RecruitResDTO> getRecruit(String content);

  RecruitResDTO getRecruitById(Integer id);
}
