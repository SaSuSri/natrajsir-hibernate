package com.nt.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ICICIGenerator implements IdentifierGenerator{
 private static final String GET_SEQ_VALUE="SELECT ICICSEQUENCE.NEXTVAL  FROM DUAL";
	@Override
	public Serializable generate(SessionImplementor session, Object domain) throws HibernateException {
		Connection con=null; 
        PreparedStatement ps=null;
        ResultSet rs=null;
        int val=0;
		try{
		//get jdbc con object
		con=session.connection();
		//get PreparedStatement obj
		ps=con.prepareStatement(GET_SEQ_VALUE);
		//Execute Query
		rs=ps.executeQuery();
		//get value from ResultSet
		if(rs.next())
			val=rs.getInt(1);
		//generator Id value
		if(val<=9)
			return "ICICI000"+val;
		else if(val<=99)
			return "ICICI00"+val;
		else 
			return "ICICI0"+val;
	}//try
	catch(Exception e){
		return "can not generate id value";
	}
	}//method
}//class
