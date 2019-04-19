package cn.pzhu.pserson;

import javax.servlet.Filter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("cn.pzhu.pserson.dao.dao")
@SpringBootApplication
@ComponentScan(basePackages = "cn.pzhu.pserson")
@ImportResource("classpath:springmvc-config.xml")
@EnableWebSocket
public class PsersonApplication {

  public static void main(String[] args) {
    SpringApplication.run(PsersonApplication.class, args);
  }

  @Bean
  public FilterRegistrationBean someFilterRegistration() {

    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(new CharacterEncodingFilter());
    registration.addUrlPatterns("/*");
    registration.addInitParameter("encoding", "UTF-8");
    registration.setName("EncodingFilter");
    registration.setOrder(1);
    return registration;
  }

  @Bean
  public Filter EncodingFilter() {
    return new CharacterEncodingFilter();
  }

//  @Bean
//  public InternalResourceViewResolver getJspViewResolver(){
//    InternalResourceViewResolver jspViewResolver=new InternalResourceViewResolver();
//    jspViewResolver.setPrefix("/WEB-INF/page/");
//    jspViewResolver.setSuffix(".jsp");
//    jspViewResolver.setViewClass(JstlView.class);
//    return jspViewResolver;
//  }

//  @Bean
//  public ViewResolver getViewResolver(){
//    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//    resolver.setPrefix("/WEB-INF/page/");
//    resolver.setSuffix(".jsp");
//    resolver.setViewClass(JstlView.class);
//    return resolver;
//  }


}

