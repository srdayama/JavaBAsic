package com.clc.service;

import java.util.List;

import com.clc.entity.EmployeeBean;

public interface EmployeeService {
	public boolean addEmp(EmployeeBean bean);
	public EmployeeBean getEmp(int empId);
	public boolean deleteEmp(int empId);
	public List<EmployeeBean> getAllEmps();
	public EmployeeBean updateEmp(EmployeeBean bean);
}
