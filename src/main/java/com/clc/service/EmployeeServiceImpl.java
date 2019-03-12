package com.clc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clc.dao.EmployeeDaoImpl;
import com.clc.entity.EmployeeBean;
import com.clc.entity.EmployeeEntity;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeDaoImpl daoImpl;

	static {
		System.out.println("Serviceimpl..Static block..");
	}

	public EmployeeServiceImpl() {
		System.out.println("Service Impl Contructor");
	}

	public void setDaoImpl(EmployeeDaoImpl daoImpl) {
		this.daoImpl = daoImpl;
	}

	public EmployeeEntity convertBeanToEntity(EmployeeBean bean) {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setId(bean.getId());
		entity.setName(bean.getName());
		return entity;
	}

	public EmployeeBean convertEntityToBean(EmployeeEntity entity) {
		EmployeeBean bean = new EmployeeBean();
		bean.setId(entity.getId());
		bean.setName(entity.getName());
		return bean;
	}

	public List<EmployeeBean> convertEntitiesToBeans(List<EmployeeEntity> entities) {
		List<EmployeeBean> beans = new ArrayList<EmployeeBean>();
		for (EmployeeEntity entity : entities) {
			beans.add(convertEntityToBean(entity));
		}
		return beans;
	}

	public List<EmployeeEntity> convertBeansToEntity(List<EmployeeBean> beans) {
		List<EmployeeEntity> entities = new ArrayList<EmployeeEntity>();
		for (EmployeeBean bean : beans) {
			entities.add(convertBeanToEntity(bean));
		}
		return entities;
	}

	public boolean addEmp(EmployeeBean bean) {
		return daoImpl.insertEmp(convertBeanToEntity(bean));
	}

	public EmployeeBean getEmp(int empId) {
		return convertEntityToBean(daoImpl.fetchEmp(empId));
	}

	public boolean deleteEmp(int empId) {
		return daoImpl.removeEmp(empId);
	}

	public List<EmployeeBean> getAllEmps() {
		return convertEntitiesToBeans(daoImpl.fetchAllEmps());
	}

	public EmployeeBean updateEmp(EmployeeBean bean) {
		// TODO Auto-generated method stub
		return convertEntityToBean(daoImpl.modifyEmp(convertBeanToEntity(bean)));
	}

}
