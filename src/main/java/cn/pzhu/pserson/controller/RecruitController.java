package cn.pzhu.pserson.controller;

import cn.pzhu.pserson.domain.Dept;
import cn.pzhu.pserson.domain.Job;
import cn.pzhu.pserson.domain.Recruit;
import cn.pzhu.pserson.domain.request.RecruitReqDTO;
import cn.pzhu.pserson.domain.response.RecruitResDTO;
import cn.pzhu.pserson.service.EmployeeService;
import cn.pzhu.pserson.service.RecruitService;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/recruit")
public class RecruitController {

  @Autowired
  RecruitService recruitService;

  @Autowired
  EmployeeService employeeService;

  @RequestMapping("/list")
  public String listAll(Model model,int pageNum,int pageSize,String content) {
    PageInfo recruit = recruitService.getRecruit(pageNum, pageSize, content);
    model.addAttribute("pageInfo",recruit);
    model.addAttribute("list",recruit.getList());
    return "recruit/list";

  }

  @RequestMapping("/toadd")
  public String add(Model model) {
    Map<String, Object> info = employeeService.getInfo();
    model.addAttribute("dept_list", (List<Dept>) info.get("depts"));
    return "recruit/add";
  }

  @ResponseBody
  @GetMapping("/joblist")
  public List<Job> getJobList(int id,Model model) {
    List<Job> list = recruitService.getJobList(id);
    return list;
  }

  @PostMapping("/add")
  public ModelAndView add(@ModelAttribute Recruit recruit, ModelAndView mv,Integer id) {
    recruitService.insertOne(recruit);
    mv.setViewName("redirect:/recruit/list?pageNum=1&pageSize=6");
    return mv;
  }

  @RequestMapping("/toupdate")
  public String toUpdate(Model model,Integer id) {
    Map<String, Object> info = employeeService.getInfo();
    model.addAttribute("dept_list", (List<Dept>) info.get("depts"));
    RecruitResDTO recruit = recruitService.getRecruit(id);
    model.addAttribute("recruit",recruit);
    return "recruit/update";
  }

  @RequestMapping("/delete")
  public void delete(Integer id){
    recruitService.delete(id);
  }
}
