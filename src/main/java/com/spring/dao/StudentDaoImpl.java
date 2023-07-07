package com.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springjdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
		String quary = "insert into student(id,name,mobile)values(?,?,?)";
		int result = this.jdbcTemplate.update(quary, student.getId(), student.getName(), student.getMobile());
		return result;
	}

	@Override
	public int change(Student student) {
		String quary = "update student set name=? , mobile=? where id=?";
		int update = this.jdbcTemplate.update(quary, student.getName(), student.getName(), student.getId());
		return update;
	}

	@Override
	public int delete(int studentDao) {
		String quary = "delete from student where id=?";
		int result = this.jdbcTemplate.update(quary, studentDao);
		return result;
	}

	@Override
	public Student getStudent(int studentId) {
		String query = "select * from student where id=?";
		RowMapper<Student> mapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, mapper, studentId);

		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		String query = "select * from student";
		List<Student> allList = this.jdbcTemplate.query(query, new RowMapperImpl());
		return allList;
	}

}
