package com.nt.generator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RandomNumberGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SessionImplementor session, 
			                                                    Object object) throws HibernateException {
	     Random random=null;
	     int number=0;
	     //Generate Psuedo random number
	     random=new Random();
	     number=random.nextInt(20000);
		return number;
	}//method
}//class
