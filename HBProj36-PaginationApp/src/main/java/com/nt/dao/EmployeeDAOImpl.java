package com.nt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.nt.bo.EmployeeHLO;
import com.nt.utility.HibernateUtil;
import com.nt.utility.ReportParameters;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public long getEmployeesCount() {
		Session ses=null;
		Criteria criteria=null;
		Projection pj_count=null;
		List<Object> list=null;
		long count=0;
		 //get HB Session
		ses=HibernateUtil.getSession();
		//write QBC logic
		criteria=ses.createCriteria(EmployeeHLO.class);
		pj_count=Projections.rowCount();
		criteria.setProjection(pj_count);
		list=criteria.list();
		count=(Long)list.get(0);
		return count; 
	}

	@Override
	public List<EmployeeHLO> getEmployeeDetails(int startPos) {
		Session ses=null;
		Criteria criteria;
		List<EmployeeHLO> listBO=null;
		 // get Session
		ses=HibernateUtil.getSession();
		//write QBC logic
		criteria=ses.createCriteria(EmployeeHLO.class);
		//set pagination params
		criteria.setFirstResult(startPos);
		criteria.setMaxResults(ReportParameters.PAGE_SIZE);
		//execute QBC
		listBO=criteria.list();
		return listBO;
	}

}
