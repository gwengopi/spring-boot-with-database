package com.home.database.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.database.bean.EmployeeBean;
import com.home.database.entity.EmployeeEntity;
import com.home.database.repository.EmployeeDAO;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO repository;

	public List<EmployeeBean> getAllEmployees() {
		List<EmployeeEntity> result = (List<EmployeeEntity>) repository.findAll();
		List<EmployeeBean> list = new ArrayList<>();
		EmployeeBean bean;
		for (EmployeeEntity employee : result) {
			bean = new EmployeeBean();
			BeanUtils.copyProperties(employee, bean);
			list.add(bean);
		}
		return list;
	}

	public EmployeeBean getEmployeeById(Long id) {
		EmployeeEntity employee = repository.findById(id).get();
		EmployeeBean bean = new EmployeeBean();
		BeanUtils.copyProperties(employee, bean);
		return bean;

	}

	public EmployeeBean createEmployee(EmployeeBean bean) {
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(bean, entity);
		EmployeeEntity retEntity = repository.save(entity);
		EmployeeBean retBean = new EmployeeBean();
		BeanUtils.copyProperties(retEntity, retBean);
		return retBean;

	}

	public void deleteEmployeeById(Long id) {
		Optional<EmployeeEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			repository.deleteById(id);
		}

	}
}