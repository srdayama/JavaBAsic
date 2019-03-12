package com.clc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clc.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	public SessionFactory sfactory;

	public void setSfactory(SessionFactory sfactory) {
		this.sfactory = sfactory;
	}

	public boolean insertEmp(EmployeeEntity entity) {
		System.out.println("insertEmp Info inside DAOimpl" + entity);
		Session session = null;
		Transaction tr = null;
		try {
			session = sfactory.openSession();
			tr = session.beginTransaction();
			session.save(entity);
			cleanup(session, tr);
			return true;
		} catch (Exception e) {
			tr.rollback();
			return false;
		}
	}

	private void cleanup(Session session, Transaction tr) {
		if (session != null) {
			if (tr != null) {
				session.flush();
				tr.commit();
			}
			session.close();
		}
	}

	public EmployeeEntity fetchEmp(int empId) {
		System.out.println("fetchEmp Info inside DAOimpl" + empId);
		Session session = null;
		try {
			session = sfactory.openSession();
			EmployeeEntity entity = session.get(EmployeeEntity.class, empId);
			cleanup(session, null);
			System.out.println(entity);
			return entity;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean removeEmp(int empId) {
		Session session = null;
		Transaction tr = null;
		EmployeeEntity entity = fetchEmp(empId);
		if (entity != null) {
			try {

				session = sfactory.openSession();
				tr = session.beginTransaction();
				session.remove(entity);
//				session.update(entity);
				cleanup(session, tr);
				return true;
			} catch (Exception e) {
				tr.rollback();
			}
		}
		return false;
	}

	public List<EmployeeEntity> fetchAllEmps() {
		Session session = null;
		try {
			session = sfactory.openSession();
			Criteria cr = session.createCriteria(EmployeeEntity.class);

			List<EmployeeEntity> entities = cr.list();
			cleanup(session, null);
			return entities;
		} catch (Exception e) {
			return null;
		}
	}

	public EmployeeEntity modifyEmp(EmployeeEntity entity) {
		Session session = null;
		Transaction tr = null;
		EmployeeEntity dbEntity = fetchEmp(entity.getId());
		if (dbEntity != null) {
			try {
				session = sfactory.openSession();
				tr = session.beginTransaction();
				dbEntity.setName(entity.getName());

				EmployeeEntity updatedEn = (EmployeeEntity) session.merge(dbEntity);
				cleanup(session, tr);
				return updatedEn;
			} catch (Exception e) {
				tr.rollback();
			}
		}

		return null;
	}

}
