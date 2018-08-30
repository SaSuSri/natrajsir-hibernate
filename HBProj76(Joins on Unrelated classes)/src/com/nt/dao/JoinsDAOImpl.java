package com.nt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.utility.HibernateUtil;

public class JoinsDAOImpl implements JoinsDAO {
	private final String HQL_JOIN="FROM Student st INNER JOIN EmpDetails ed ON st.sno=ed.no";
	@Override
	public void showData() {
		Session ses=null;
		ses = HibernateUtil.getSession();
		Query query=ses.createQuery(HQL_JOIN);

		List<Object[]>list=query.list();
		for (Object[] row : list) {
			for (Object object : row) {
				System.out.print(object+"  ");
			}
			System.out.println();
		}//for
		
	}//method

}//class
