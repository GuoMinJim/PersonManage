package cn.pzhu.pserson.service;

import cn.pzhu.pserson.domain.Dept;
import cn.pzhu.pserson.domain.Document;
import cn.pzhu.pserson.domain.Employee;
import cn.pzhu.pserson.domain.Job;
import cn.pzhu.pserson.domain.Notice;
import cn.pzhu.pserson.domain.User;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Map;

public interface RainService {

  /**
   * 部门信息的service
   */
  PageInfo findAllDept(String content, int pageNum, int pageSize);

  void addDept(Dept dept);

  Dept get_Info(Integer id);

  void update_Info(Dept dept);

  void delete_Info(Integer id);

  PageInfo findAllDept(int pageNum, int pageSize);

  /**
   * 职位信息的service
   */

  PageInfo findAllJob(int pageNum, int pageSize);

  PageInfo findAllJob(String content, int pageNum, int pageSize);

  Job get_JobInfo(Integer id);

  void update_JobInfo(Job job);

  void insert_JobInfo(Job job);

  void delete_JobInfo(Integer id);

  /**
   * 员工信息的service
   */
  List<Employee> get_EmployeeList();

  List<Employee> get_EmployeeLikeList(String content);

  Employee get_EmployeeInfo(Integer id);

  void update_EmployeeInfo(Employee data);

  void insert_EmployeeInfo(Employee data);

  void delete_EmployeeInfo(Integer id);

  List<Notice> get_NoticeList();

  List<Notice> get_NoticeLikeList(String content);

  Notice get_NoticeInfo(Integer id);

  void update_NoticeInfo(Notice notice);

  void insert_NoticeInfo(Notice notice);

  void delete_NoticeInfo(Integer id);

  List<Document> get_DocumentList();

  List<Document> get_DocumentLikeList(String content);

  Document get_DocumentInfo(Integer id);

  void update_DocumentInfo(Document notice);

  void insert_DocumentInfo(Document notice);

  void delete_DocumentInfo(Integer id);

  User login(String loginname, String password);

  Map<String, Object> get_UserList(int pageNum, int pageSize);

  Map<String, Object> get_UserLikeList(String content, int pageNum, int pageSize);

  User get_UserInfo(Integer id);

  void update_UserInfo(User notice);

  void insert_UserInfo(User notice);

  void delete_UserInfo(Integer id);

}
