package com.home.database.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.home.database.bean.EmployeeBean;
import com.home.database.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/")
public class EmployeeMvcController {
	@Autowired
	EmployeeServiceImpl service;
	
	private EmployeeServiceImpl empService;
	
	public  EmployeeMvcController(EmployeeServiceImpl empService) {
		this.empService=empService;
	}

	@RequestMapping
	public String getAllEmployees(Model model) {
		List<EmployeeBean> list = service.getAllEmployees();

		model.addAttribute("employees", list);
		return "list-employees";
	}

	@RequestMapping(path = { "/edit", "/edit/{id}" })
	public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id) {
		if (id.isPresent()) {
			EmployeeBean bean = service.getEmployeeById(id.get());
			model.addAttribute("employee", bean);
		} else {
			model.addAttribute("employee", new EmployeeBean());
		}
		return "add-edit-employee";
	}

	@RequestMapping(path = "/delete/{id}")
	public String deleteEmployeeById(Model model, @PathVariable("id") Long id) {
		service.deleteEmployeeById(id);
		return "redirect:/";
	}

	@RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
	public String createOrUpdateEmployee(EmployeeBean employee) {
		service.createEmployee(employee);
		return "redirect:/";
	}
}
