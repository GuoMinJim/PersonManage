package cn.pzhu.pserson.dao.dao;

import cn.pzhu.pserson.dao.provider.JobDynaSqlProvider;
import cn.pzhu.pserson.domain.Job;
import cn.pzhu.pserson.domain.response.JobResDTO;
import cn.pzhu.pserson.util.Constants;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

public interface JobMapper extends Mapper<Job> {

  @Select("select * from " + Constants.JOBTABLE + " order by id ASC ")
  List<Job> get_List();

  @Select(
      "select * from " + Constants.JOBTABLE
          + "  where name like CONCAT('%',#{content},'%') order by id ASC")
  List<Job> get_LikeList(String content);


  @SelectProvider(type = JobDynaSqlProvider.class, method = "insertDept")
  void insert_Info(Job job);

  @Select("select * from " + Constants.JOBTABLE + " where id = #{id}")
  Job get_Info(Integer id);

  @SelectProvider(type = JobDynaSqlProvider.class, method = "updateDept")
  void update_Info(Job job);

  // 根据id删除部门
  @Delete(" delete from " + Constants.JOBTABLE + " where id = #{id} ")
  void delete_Info(Integer id);

  List<JobResDTO> findAll(@Param("content") String content);

  List<Job> getJob(int id);
}