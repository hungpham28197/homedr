package com.homedirect.template.database;
import javax.persistence.EntityManagerFactory;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 *  Author : duy.bui
 *          Email:duy.bui@homedirect.com.vn
 * Dec 27, 2016
 */
//@Configuration
//@EnableJpaRepositories(
//    entityManagerFactoryRef = "entityManagerFactory", 
//    transactionManagerRef = "mysqlTransactionManager",
//    basePackages = {"com.homedirect.template.repository"})
public class MySqlConfiguration {

  private final Logger logger = LoggerFactory.getLogger(MySqlConfiguration.class);

  @Autowired
  public MySqlConfiguration(Environment env) {
    logger.info("\n\n----> MysqlConfiguration constructor <----\n\n");
  }

  @Primary
  @Bean(name = "mysqlDataSourceProperties")
  @ConfigurationProperties(prefix="mysql.datasource")
  protected DataSourceProperties userMysqlDataSourceProperties() {
    return new DataSourceProperties();
  };

  private DataSource createDataSource(DataSourceProperties properties) {
    return (DataSource) DataSourceBuilder.create(properties.getClassLoader()).type(DataSource.class)
        .driverClassName(properties.determineDriverClassName())
        .url(properties.determineUrl()).username(properties.determineUsername())
        .password(properties.determinePassword()).build();
  }

  @Autowired
  @Bean(name = "mysqlDataSource")
  public DataSource mysqlDataSource(@Qualifier("mysqlDataSourceProperties") DataSourceProperties properties) {
    DataSource dataSource = createDataSource(properties);
    DatabaseDriver databaseDriver = DatabaseDriver.fromJdbcUrl(properties.determineUrl());
    String validationQuery = databaseDriver.getValidationQuery();
    if (validationQuery != null) {
      dataSource.setTestOnBorrow(true);
      dataSource.setValidationQuery(validationQuery);
    }
    return dataSource;
  }

  @Primary
  @Autowired
  @Bean(name = "entityManagerFactory")
  public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(EntityManagerFactoryBuilder builder, 
      @Qualifier("mysqlDataSource") DataSource mysqlDataSource) {
    LocalContainerEntityManagerFactoryBean bean = builder.dataSource(mysqlDataSource)
        .packages("com.homedirect.template.model")
        .persistenceUnit("mysql")
        .build();
    return bean;
  }

  @Autowired
  @Bean(name = "mysqlTransactionManager")
  public PlatformTransactionManager mysqlTransactionManager(@Qualifier("entityManagerFactory")  EntityManagerFactory mysqlEntityManagerFactory) {
    return new JpaTransactionManager(mysqlEntityManagerFactory);
  }
}
