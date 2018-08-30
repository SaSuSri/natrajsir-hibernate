package com.nt.test;

import java.sql.Blob;
import java.sql.Clob;

import org.hibernate.Hibernate;
import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpProfile;
import com.nt.utility.FileUtility;
import com.nt.utility.HibernateUtil;

public class InsertClient
{
	public static void main(String s[])throws Exception
	{
		Session ses=null;
		String fileContent=null;
		LobHelper helper=null;
		Clob resume =null;
		byte fileByte[]=null;
		Blob photo=null;
		EmpProfile profile=null;
		Transaction tx=null;
		// Get Session obj
		ses=HibernateUtil.getSession();
       //for CLOB				
		// convert to Text file in to a Stirng
		fileContent=FileUtility.readFileAsString("c:/store/resume.txt");

		//Covert String data in to java.sql.Clob obj
		helper=ses.getLobHelper();
		resume=helper.createClob(fileContent);
		
		//for BLOB
		//convert image file data inot byte[]
		fileByte=FileUtility.getBytesArrayFromFile("c:/store/gavin.png");
		//convert byte[] into java.sql.Blob obj
		 photo=helper.createBlob(fileByte);
		
		 //create Domain class obj having Blob,Clob objs as values
		 profile=new EmpProfile();
		profile.setEid(1001);
		profile.setEname("raja");
		profile.setEresume(resume);
		profile.setEphoto(photo);
		
		try{
			tx=ses.beginTransaction();
			   ses.save(profile);
		    tx.commit();
		    System.out.println("Successfully Inserted here");
		}//try
		catch(Exception e){
			tx.rollback();
		}
				
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class