package com.home.database.service;

import java.util.List;

import com.home.database.bean.EmployeeBean;


public interface EmployeeService {
	public List<EmployeeBean> getAllEmployees();

	public EmployeeBean getEmployeeById(Long id);

	public EmployeeBean createEmployee(EmployeeBean bean);

	public void deleteEmployeeById(Long id);

}
