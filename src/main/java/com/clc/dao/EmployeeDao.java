package com.clc.dao;

import java.util.List;

import com.clc.entity.EmployeeEntity;

public interface EmployeeDao {
	public boolean insertEmp(EmployeeEntity entity);

	public EmployeeEntity fetchEmp(int empId);

	public boolean removeEmp(int empId);

	public List<EmployeeEntity> fetchAllEmps();

	public EmployeeEntity modifyEmp(EmployeeEntity entity);
}
