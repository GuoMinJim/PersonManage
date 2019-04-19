package cn.pzhu.pserson.controller;

import cn.pzhu.pserson.domain.Dept;
import cn.pzhu.pserson.service.DeptService;
import cn.pzhu.pserson.service.RainService;
import com.github.pagehelper.PageInfo;
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
public class DeptController {

  @Autowired
  @Qualifier("RainService")
  private RainService rainservice;

  @Autowired
  private DeptService deptService;

  // 如果在目录下输入为空，则跳转到指定链接
  @RequestMapping(value = "/dept/")
  public ModelAndView index2(ModelAndView mv) {
    mv.setViewName("dept/list");
    return mv;
  }

  // 如果在目录下输入任何不存在的参数，则跳转到list
  @RequestMapping(value = "/dept/{formName}")
  public String index2(@PathVariable String formName) {
//		return formName;
    String blank = "/dept/list";
    return blank;
  }

  @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
  public String index(Model model, String content, int pageNum, int pageSize) {
//    PageInfo pageInfo = rainservice.findAllDept(pageNum, pageSize);
//    if (content != null) {
//      pageInfo = rainservice.findAllDept(content, pageNum, pageSize);
//    }
    PageInfo pageInfo = deptService.getDepts(content,pageNum,pageSize);
    model.addAttribute("list", pageInfo.getList());
    model.addAttribute("pageInfo", pageInfo);
    return "dept/list";
  }

  @RequestMapping(value = "/dept/add", method = RequestMethod.GET)
  public String add(Model model, Integer id) {
//		System.out.println(id);
    if (id != null) {
      Dept dept = rainservice.get_Info(id);
      model.addAttribute("dept", dept);
//			System.out.println(dept.getName());
    }
    return "/dept/add";
  }

  @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
  public ModelAndView add(ModelAndView mv, @ModelAttribute Dept dept, Integer id) {
    System.out.println(id);
//		System.out.println(dept.getId());
    if (id != null) {
      rainservice.update_Info(dept);
      System.out.println(dept.getId());
    } else {
      rainservice.addDept(dept);
    }
//		System.out.println(dept.getName());
    mv.setViewName("redirect:/dept/list?pageNum=1&pageSize=6");
    return mv;
  }

  @RequestMapping(value = "/dept/delete", method = RequestMethod.GET)
  public void delete(Integer id) {
    System.out.println(id);
    if (id != null) {
      rainservice.delete_Info(id);
    }
  }
}
