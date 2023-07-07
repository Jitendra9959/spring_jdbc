package com.spring.beans;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.dao.StudentDao;
import com.springjdbc.entities.Student;

public class Test {

	public static void main(String[] args) {

		// WithOut config- file
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		// with config- file
//		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/spring/common/application-context.xml");

		// INSERT-data in database 1-approach.
//		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);

//		String quary = "insert into student(id,name, mobile) values(?,?,?)";
		/*
		 * int result = template.update(quary, 103, "Rahul", 9982787871L);
		 * System.out.println("number of record inserted..." + result);
		 *//*
			 * int result = template.update(quary,101,"Sikendra", 9955412299L);
			 * 
			 * System.out.println("number of record inserted.."+result);
			 */

		// Second Approach.

//		StudentDao bean = context.getBean("studentDao", StudentDao.class);
//		Student student = new Student();
//		student.setId(107);
//		student.setName("Tinkal");
//		student.setMobile("9955667263");
//		int insert = bean.insert(student);
//		System.out.println("student added.." + insert);

		// UPDATA into database.

		StudentDao dao = context.getBean("studentDao", StudentDao.class);
		/*
		 * Student student=new Student(); student.setId(101); student.setName("Komal");
		 * student.setMobile("7231137891");
		 * 
		 * int update=dao.change(student); System.out.println("data changed.."+update);
		 */

		// DELETE
		/*
		 * Scanner sc = new Scanner(System.in); System.out.println("Enter Id.."); int id
		 * = sc.nextInt(); System.out.println("Enter Name.."); String name = sc.next();
		 * System.out.println("enter moblieNo.."); String moblieNo = sc.next();
		 * 
		 * Student student = new Student(); student.setId(id); student.setName(name);
		 * student.setMobile(moblieNo); int insert = dao.insert(student);
		 * 
		 * System.out.println("Row inserted.." + insert);
		 */

		/*
		 * int delete = dao.delete(101); System.out.println("deleted record.." +
		 * delete);
		 */
		Student student2 = dao.getStudent(102);
		System.out.println(student2);

		List<Student> allStudents = dao.getAllStudents();

		for (Student s : allStudents) {
			System.out.println(s);

		}

	}
}
