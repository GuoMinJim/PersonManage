package cn.pzhu.pserson.dao.dao;

import cn.pzhu.pserson.dao.provider.DeptDynaSqlProvider;
import cn.pzhu.pserson.domain.Dept;
import cn.pzhu.pserson.domain.response.DeptResDto;
import cn.pzhu.pserson.util.Constants;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

public interface DeptMapper extends Mapper<Dept> {


  List<DeptResDto> getDepts(@Param("content") String content);

  //查询
  @Select("select * from " + Constants.DEPTTABLE + " order by id ASC ")
  List<Dept> selectAllDept();

  @Select(
      "select * from " + Constants.DEPTTABLE + " where name like CONCAT('%',#{content},'%')  order by id ASC")
  List<Dept> selectLikeAllDept(String content);


  @SelectProvider(type = DeptDynaSqlProvider.class, method = "insertDept")
  void save(Dept dept);

  @Select("select * from " + Constants.DEPTTABLE + " where id = #{id}")
  Dept get_Info(Integer id);

  @SelectProvider(type = DeptDynaSqlProvider.class, method = "updateDept")
  void update_Info(Dept dept);

  // 根据id删除部门
  @Delete(" delete from " + Constants.DEPTTABLE + " where id = #{id} ")
  void delete_Info(Integer id);
}