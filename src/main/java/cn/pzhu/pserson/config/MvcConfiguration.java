package cn.pzhu.pserson.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

//@Configuration
//@EnableWebMvc
//@ComponentScan
@Controller
public class MvcConfiguration {

//  @Bean
//  public InternalResourceViewResolver viewResolver() {
//
//    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//    viewResolver.setPrefix("/WEB-INF/page/");
//    viewResolver.setSuffix(".html");
//    return viewResolver;
//  }

  // 首先注入一个ServerEndpointExporterBean,该Bean会自动注册使用@ServerEndpoint注解申明的websocket endpoint。
  @Bean
  public ServerEndpointExporter serverEndpointExporter(){
    return new ServerEndpointExporter();
  }
}
