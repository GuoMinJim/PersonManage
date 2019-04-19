package cn.pzhu.pserson.service.impl;

import cn.pzhu.pserson.dao.dao.DeptMapper;
import cn.pzhu.pserson.dao.dao.EmployeeMapper;
import cn.pzhu.pserson.dao.dao.JobMapper;
import cn.pzhu.pserson.domain.Dept;
import cn.pzhu.pserson.domain.Employee;
import cn.pzhu.pserson.domain.Job;
import cn.pzhu.pserson.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {


  @Resource
  JobMapper jobMapper;

  @Resource
  DeptMapper deptMapper;

  @Resource
  EmployeeMapper employeeMapper;

  @Override
  public Map<String, Object> getInfo() {
    List<Job> jobs = jobMapper.get_List();
    List<Dept> depts = deptMapper.selectAllDept();
    Map<String,Object> map = new HashMap<>();
    map.put("jobs",jobs);
    map.put("depts",depts);
    return map;
  }

  @Override
  public PageInfo getEmployee(int pageNum,int pageSize) {
    PageInfo<Object> pageInfo = PageHelper.startPage(pageNum, pageSize, true)
        .doSelectPageInfo(() -> employeeMapper.getEm());
    return pageInfo;
  }

  @Override
  public void insert(Employee employee) {
    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
    employee.setCreateDate(format.format(date));
    employeeMapper.insert(employee);
  }

  @Override
  public void update(Employee employee) {
    employeeMapper.updateByPrimaryKey(employee);
  }

  @Override
  public PageInfo getEmployee(String content, int pageNum, int pageSize) {
    PageInfo<Object> pageInfo = PageHelper.startPage(pageNum, pageSize, true)
        .doSelectPageInfo(() -> employeeMapper.getEmployees(content));
    return pageInfo;
  }

  @Override
  public Employee getEmployee(Integer id) {
    return employeeMapper.selectByPrimaryKey(id);
  }
}
