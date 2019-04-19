package cn.pzhu.pserson.controller;

import cn.pzhu.pserson.domain.Dept;
import cn.pzhu.pserson.domain.Job;
import cn.pzhu.pserson.service.EmployeeService;
import cn.pzhu.pserson.service.JobService;
import cn.pzhu.pserson.service.RainService;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JobController {

  @Autowired
  @Qualifier("RainService")
  private RainService rainservice;

  @Autowired
  EmployeeService employeeService;

  @Autowired
  JobService jobService;

  // 如果在目录下输入为空，则跳转到指定链接
  @RequestMapping(value = "/job/")
  public ModelAndView index2(ModelAndView mv) {
    mv.setViewName("job/list");
    return mv;
  }

  // 如果在目录下输入任何不存在的参数，则跳转到list
  @RequestMapping(value = "/job/{formName}")
  public String index2(@PathVariable String formName) {
    String blank = "/job/list";
    return blank;
  }

  @RequestMapping(value = "/job/list", method = RequestMethod.GET)
  public String index(Model model, String content, int pageNum, int pageSize) {
    PageInfo pageInfo = jobService.findAll(content,pageNum,pageSize);
    model.addAttribute("list", pageInfo.getList());
    model.addAttribute("pageInfo", pageInfo);
    return "job/list";
  }

  @RequestMapping(value = "/job/add", method = RequestMethod.GET)
  public String add(Model model, Integer id) {
    if (id != null) {
      Job job = rainservice.get_JobInfo(id);
      model.addAttribute("job", job);
    }
    Map<String, Object> info = employeeService.getInfo();
    model.addAttribute("dept_list", (List<Dept>) info.get("depts"));
    return "/job/add";
  }

  @RequestMapping(value = "/job/add", method = RequestMethod.POST)
  public ModelAndView add(ModelAndView mv, @ModelAttribute Job job, Integer id) {
    System.out.println(id);
    if (id != null) {
//      rainservice.update_JobInfo(job);
      jobService.update(job);
    } else {
      jobService.insert(job);
//      rainservice.insert_JobInfo(job);
    }
    mv.setViewName("redirect:/job/list?pageNum=1&pageSize=6");
    return mv;
  }

  @RequestMapping(value = "/job/delete", method = RequestMethod.GET)
  public void delete(Integer id) {
    System.out.println(id);
    if (id != null) {
      rainservice.delete_JobInfo(id);
    }
  }
}
