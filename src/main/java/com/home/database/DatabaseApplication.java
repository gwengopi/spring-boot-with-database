package com.home.database;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.home.database.bean.EmployeeBean;
import com.home.database.repository.EmployeeDAO;
import com.home.database.service.EmployeeService;

@SpringBootApplication
public class DatabaseApplication implements CommandLineRunner {

	@Autowired
	EmployeeService empService;
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EmployeeBean empBean = new EmployeeBean();
		empBean.setEmail("Ben@gmail.com");
		empBean.setFirstName("Ben");
		empBean.setLastName("10");
		empService.createEmployee(empBean);
	}

}
