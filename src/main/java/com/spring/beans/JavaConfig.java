package com.spring.beans;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.dao.StudentDao;
import com.spring.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = {"com.spring.dao"})
public class JavaConfig {

	@Bean(name = { "ds" })
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;

	}

	@Bean(name = { "jdbcTemplate" })
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;

	}

//	@Bean(name = { "daoImpl" })
//	public StudentDao getStudentDao() {
//		StudentDaoImpl daoImpl = new StudentDaoImpl();
//		daoImpl.setJdbcTemplate(getTemplate());
//		return daoImpl;
//	}

}
