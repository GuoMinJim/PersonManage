package cn.pzhu.pserson.config;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfig {

  @ConfigurationProperties(prefix = "spring.datasource")
  @Bean
  public DataSource druid() {
    return new DruidDataSource();
  }

}
