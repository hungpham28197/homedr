package com.homedirect.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ImportResource("classpath:application-config.xml")
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration(exclude={
    SolrAutoConfiguration.class,
    org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class
    })
public class ServerApplication extends SpringBootServletInitializer {
  
  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(ServerApplication.class);
  }
  
  public static void main(String[] args) {
    SpringApplication.run(ServerApplication.class, args);
  }
}
