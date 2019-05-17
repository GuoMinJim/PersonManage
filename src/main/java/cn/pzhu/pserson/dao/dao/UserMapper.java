package cn.pzhu.pserson.dao.dao;

import cn.pzhu.pserson.dao.provider.UserDynaSqlProvider;
import cn.pzhu.pserson.domain.User;
import cn.pzhu.pserson.domain.response.IndexHeaderResDTO;
import cn.pzhu.pserson.util.Constants;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {

  @Select("select * from " + Constants.USERTABLE + " order by createdate DESC")
  List<User> get_List();

  @Select("select * from " + Constants.USERTABLE
      + "  where username like CONCAT('%',#{content},'%') or loginname like CONCAT('%',#{content},'%') order by createdate DESC")
  List<User> get_LikeList(String content);

  @Select(
      "select * from " + Constants.USERTABLE + "  where loginname = #{loginname} AND password = #{password}")
  User get_login(@Param("loginname") String loginname,
      @Param("password") String password);

  @SelectProvider(type = UserDynaSqlProvider.class, method = "insert_Notice")
  void insert_Info(User employee);

  @Select("select * from " + Constants.USERTABLE + " where id = #{id}")
  User get_Info(Integer id);

  @SelectProvider(type = UserDynaSqlProvider.class, method = "update_Notice")
  void update_Info(User employee);

  // 根据id删除部门
  @Delete(" delete from " + Constants.USERTABLE + " where id = #{id} ")
  void delete_Info(Integer id);

  @Select("select count(1) from user where loginname = #{name}")
  int repeatName(String name);

  IndexHeaderResDTO countHeader();
}