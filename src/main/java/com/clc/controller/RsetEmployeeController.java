package com.clc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clc.entity.EmployeeBean;
import com.clc.service.EmployeeService;

@RestController
@RequestMapping(value = "/api/emps/")
public class RsetEmployeeController {

	@Autowired
	EmployeeService service;

	@RequestMapping(method = RequestMethod.GET)
	public List<EmployeeBean> getAllEmploye() {
		List<EmployeeBean> allEmps = service.getAllEmps();
		System.out.println(allEmps);
		return allEmps;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public EmployeeBean getSingleEmp(@PathVariable int id) {
		return service.getEmp(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addEmployee(@RequestBody EmployeeBean bean) {
		service.addEmp(bean);
		return "Employee added SucessFully";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String updateEmp(@RequestBody EmployeeBean bean) {
		service.updateEmp(bean);
		return "employee adedd updated";
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String deleteSingleEmp(@PathVariable int id) {
		service.deleteEmp(id);
		return "employee deleted...";
	}
}
