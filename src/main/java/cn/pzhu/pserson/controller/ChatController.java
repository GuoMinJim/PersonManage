package cn.pzhu.pserson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/chat")
@Controller
public class ChatController {

  @RequestMapping(value = "/chat")
  public String getIndex(){
    System.out.println("im here");
    ModelAndView view = new ModelAndView("chat");
    return "/chat/chat";
  }


}
