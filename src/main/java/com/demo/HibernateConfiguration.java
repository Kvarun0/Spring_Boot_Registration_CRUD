package com.demo;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	
	@Value("${db.driver}")
	private String driver;
	
	@Value("${db.url}")
	private String url;
	
	@Value("${db.username}")
	private String username;
	
	@Value("${db.password}")
	private String password;
	
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Value("${hibernate.show_sql}")
	private String show_sql;
	
	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2ddl;
	
	@Value("${entitymanager.packagesToScan}")
	private String packagesToScan;
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(driver);
		driverManagerDataSource.setUrl(url);
		driverManagerDataSource.setUsername(username);
		driverManagerDataSource.setPassword(password);
		return driverManagerDataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean(){
		
		LocalSessionFactoryBean localSessionFactoryBean=new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		
		localSessionFactoryBean.setPackagesToScan(packagesToScan);
		
		Properties hibernet_properties=new Properties();
		hibernet_properties.setProperty("hibernate.dialect", dialect);
		hibernet_properties.setProperty("hibernate.show_sql", show_sql);
		hibernet_properties.setProperty("hibernate.hbm2ddl.auto", hbm2ddl);
		
		localSessionFactoryBean.setHibernateProperties(hibernet_properties);
		return localSessionFactoryBean;
	}
	
	@Bean
	public HibernateTransactionManager hibernateTransactionManager(){
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(localSessionFactoryBean().getObject());
		return transactionManager;
	}
	
	
	
	
	
	
}
