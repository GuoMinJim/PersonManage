package cn.pzhu.pserson.dao.dao;

import cn.pzhu.pserson.dao.provider.EmployeeDynaSqlProvider;
import cn.pzhu.pserson.domain.Employee;
import cn.pzhu.pserson.domain.response.EmployeeResDTO;
import cn.pzhu.pserson.util.Constants;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

public interface EmployeeMapper extends Mapper<Employee> {

  /**
   *
   * @return
   */
  //查询
  @Select("select * from " + Constants.EMPLOYEETABLE + " order by id ASC")
  List<Employee> get_List();

  @Select("select * from " + Constants.EMPLOYEETABLE
      + "  where name like CONCAT('%',#{content},'%')  order by id ASC")
  List<Employee> get_LikeList(String content);


  @SelectProvider(type = EmployeeDynaSqlProvider.class, method = "insert_Employee")
  void insert_Info(Employee employee);

  @Select("select * from " + Constants.EMPLOYEETABLE + " where id = #{id}")
  Employee get_Info(Integer id);

  @SelectProvider(type = EmployeeDynaSqlProvider.class, method = "update_Employee")
  void update_Info(Employee employee);

  // 根据id删除部门
  @Delete(" delete from " + Constants.EMPLOYEETABLE + " where id = #{id} ")
  void delete_Info(Integer id);


  @Select("SELECT\n"
      + "\te.*,e.createDate as createDate, d.`name` AS dept,\n"
      + "\tj.`name` AS job\n"
      + "FROM\n"
      + "\temployee e\n"
      + "LEFT JOIN dept d ON d.id = e.dept_id\n"
      + "LEFT JOIN job j ON j.id = e.job_id  order by e.id ASC")
  List<EmployeeResDTO> getEm();

  @Select("SELECT\n"
      + "\te.*,e.createDate as createDate, d.`name` AS dept,\n"
      + "\tj.`name` AS job\n"
      + "FROM\n"
      + "\temployee e\n"
      + "LEFT JOIN dept d ON d.id = e.dept_id\n"
      + "LEFT JOIN job j ON j.id = e.job_id where name like CONCAT('%',#{content},'%') order by e.id ASC")
  List<EmployeeResDTO> getEmByContent(String content);

  List<EmployeeResDTO> getEmployees(@Param("content") String content);
}