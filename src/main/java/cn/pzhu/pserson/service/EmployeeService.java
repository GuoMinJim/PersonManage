package cn.pzhu.pserson.service;

import cn.pzhu.pserson.domain.Employee;
import com.github.pagehelper.PageInfo;
import java.util.Map;

public interface EmployeeService {

  Map<String,Object> getInfo();

  PageInfo getEmployee(int pageNum, int pageSize);

  void insert(Employee employee);

  void update(Employee employee);

  PageInfo getEmployee(String content, int pageNum, int pageSize);

  Employee getEmployee(Integer id);

}
