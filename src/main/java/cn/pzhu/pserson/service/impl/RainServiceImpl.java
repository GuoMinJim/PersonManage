package cn.pzhu.pserson.service.impl;

import cn.pzhu.pserson.dao.dao.DeptMapper;
import cn.pzhu.pserson.dao.dao.DocumentMapper;
import cn.pzhu.pserson.dao.dao.EmployeeMapper;
import cn.pzhu.pserson.dao.dao.JobMapper;
import cn.pzhu.pserson.dao.dao.NoticeMapper;
import cn.pzhu.pserson.dao.dao.UserMapper;
import cn.pzhu.pserson.domain.Dept;
import cn.pzhu.pserson.domain.Document;
import cn.pzhu.pserson.domain.Employee;
import cn.pzhu.pserson.domain.Job;
import cn.pzhu.pserson.domain.Notice;
import cn.pzhu.pserson.domain.User;
import cn.pzhu.pserson.service.RainService;
import cn.pzhu.pserson.util.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("RainService")
public class RainServiceImpl implements RainService {


  @Resource
  DeptMapper deptMapper;
  @Resource
  DocumentMapper documentMapper;
  @Resource
  EmployeeMapper employeeMapper;
  @Resource
  JobMapper jobMapper;
  @Resource
  NoticeMapper noticeMapper;
  @Resource
  UserMapper userMapper;


  /**
   * 部门信息的管理
   */
  @Transactional(readOnly = true)
  @Override
  public PageInfo findAllDept(int pageNum, int pageSize) {
    PageInfo<Object> pageInfo = PageHelper.startPage(pageNum, pageSize, true)
        .doSelectPageInfo(() -> deptMapper.selectAllDept());
    return pageInfo;
  }

  @Override
  public void addDept(Dept dept) {

    deptMapper.save(dept);
  }

  @Override
  public Dept get_Info(Integer id) {
    Dept dept = deptMapper.get_Info(id);
    return dept;
  }

  @Override
  public void update_Info(Dept dept) {
    deptMapper.update_Info(dept);
  }

  @Override
  public void delete_Info(Integer id) {

    deptMapper.delete_Info(id);
  }

  @Override
  public PageInfo findAllDept(String content, int pageNum, int pageSize) {
    PageInfo pageInfo = PageHelper.startPage(pageNum, pageSize, true)
        .doSelectPageInfo(() -> deptMapper.selectLikeAllDept(content));
    return pageInfo;
  }

  /**
   * 职位管理的操作
   */
  @Override
  public PageInfo findAllJob(int pageNum, int pageSize) {
    PageInfo<Object> pageInfo = PageHelper.startPage(pageNum, pageSize, true)
        .doSelectPageInfo(() -> jobMapper.get_List());
    return pageInfo;
  }

  @Override
  public PageInfo findAllJob(String content, int pageNum, int pageSize) {
    PageInfo<Object> pageInfo = PageHelper.startPage(pageNum, pageSize, true)
        .doSelectPageInfo(() -> jobMapper.get_LikeList(content));
    return pageInfo;
  }

  @Override
  public Job get_JobInfo(Integer id) {

    return jobMapper.get_Info(id);
  }

  @Override
  public void update_JobInfo(Job job) {

    jobMapper.update_Info(job);
  }

  @Override
  public void insert_JobInfo(Job job) {

    jobMapper.insert_Info(job);
  }

  @Override
  public void delete_JobInfo(Integer id) {
    jobMapper.delete_Info(id);
  }

  /**
   * 员工信息的管理
   */
  @Override
  public List<Employee> get_EmployeeList() {

    /**
     * 将部门，职位id中的信息提取出来
     */
    List<Employee> list = employeeMapper.get_List();
    int size = list.size();
    List<Employee> list2 = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      Employee data = list.get(i);
      Dept dept = deptMapper.get_Info(data.getDeptId());
//			data.setD(dept);
//			Job job = jobMapper.get_Info(data.getJob_id());
//			data.setJob(job);
      list2.add(i, data);
    }
    return list2;
  }

  @Override
  public List<Employee> get_EmployeeLikeList(String content) {

    /**
     * 将部门，职位id中的信息提取出来
     */
    List<Employee> list = employeeMapper.get_LikeList(content);
    int size = list.size();
    List<Employee> list2 = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      Employee data = list.get(i);
//			Dept dept = deptMapper.get_Info(data.getDept_id());
//			data.setDept(dept);
//			Job job = jobMapper.get_Info(data.getJob_id());
//			data.setJob(job);
      list2.add(i, data);
    }
    return list2;
  }

  @Override
  public Employee get_EmployeeInfo(Integer id) {

    Employee data = employeeMapper.get_Info(id);
//		Dept dept = deptMapper.get_Info(data.getDept_id());
//		data.setDept(dept);
//		Job job = jobMapper.get_Info(data.getJob_id());
//		data.setJob(job);
    return data;
  }

  @Override
  public void update_EmployeeInfo(Employee data) {

    employeeMapper.update_Info(data);
  }

  @Override
  public void insert_EmployeeInfo(Employee data) {
    /**
     * 将职位id和部门id提取，或者不管，因为直接存到数据库了，不管
     */
    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
    data.setCreateDate(format.format(date));
    employeeMapper.insert_Info(data);
  }

  @Override
  public void delete_EmployeeInfo(Integer id) {
    employeeMapper.delete_Info(id);
  }

  /**
   * 公告管理
   */
  @Override
  public List<Notice> get_NoticeList() {

    return noticeMapper.get_List();
  }

  @Override
  public List<Notice> get_NoticeLikeList(String content) {

    return noticeMapper.get_LikeList(content);
  }

  @Override
  public Notice get_NoticeInfo(Integer id) {

    return noticeMapper.get_Info(id);
  }

  @Override
  public void update_NoticeInfo(Notice notice) {

    noticeMapper.update_Info(notice);
  }

  @Override
  public void insert_NoticeInfo(Notice notice) {

//		Date date = new Date();    
//		String year = String.format("%tY", date);   
//		String month = String.format("%tB", date);   
//		String day = String.format("%te", date);   
//		notice.setCreate_date(year+month+day);
    noticeMapper.insert_Info(notice);
  }

  @Override
  public void delete_NoticeInfo(Integer id) {

    noticeMapper.delete_Info(id);
  }

  /**
   * 文档管理
   */
  @Override
  public List<Document> get_DocumentList() {

    return documentMapper.get_List();
  }

  @Override
  public List<Document> get_DocumentLikeList(String content) {

    return documentMapper.get_LikeList(content);
  }

  @Override
  public Document get_DocumentInfo(Integer id) {

    return documentMapper.get_Info(id);
  }

  @Override
  public void update_DocumentInfo(Document notice) {

    documentMapper.update_Info(notice);
  }

  @Override
  public void insert_DocumentInfo(Document notice) {

//		Date date = new Date();    
//		String year = String.format("%tY", date);   
//		String month = String.format("%tB", date);   
//		String day = String.format("%te", date);   
//		notice.setCreate_date(year+month+day);
    documentMapper.insert_Info(notice);
  }

  @Override
  public void delete_DocumentInfo(Integer id) {

    documentMapper.delete_Info(id);
  }

  @Override
  public User login(String loginname, String password) {
    User user = userMapper.get_login(loginname, MD5Util.crypt(password));
    return user;
  }

  @Override
  public Map<String, Object> get_UserList(int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    Map<String, Object> map = new HashMap<>();
    List<User> list = userMapper.get_List();
    map.put("size", list.size());
    map.put("list", list);
    return map;
  }

  @Override
  public Map<String, Object> get_UserLikeList(String content, int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<User> list = userMapper.get_LikeList(content);
    Map<String, Object> map = new HashMap<>();
    map.put("size", list.size());
    map.put("list", list);
    return map;
  }

  @Override
  public User get_UserInfo(Integer id) {
    return userMapper.get_Info(id);
  }

  @Override
  public void update_UserInfo(User notice) {

    userMapper.update_Info(notice);
  }

  @Override
  public void insert_UserInfo(User notice) {

//		Date date = new Date();    
//		String year = String.format("%tY", date);   
//		String month = String.format("%tB", date);   
//		String day = String.format("%te", date);   
//		notice.setCreate_date(year+month+day);
    notice.setLevel("123");
    userMapper.insert(notice);
//		userMapper.insert_Info(notice);
  }

  @Override
  public void delete_UserInfo(Integer id) {

    userMapper.delete_Info(id);
  }
}
