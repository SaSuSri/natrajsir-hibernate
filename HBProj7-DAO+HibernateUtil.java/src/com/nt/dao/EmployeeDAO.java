package com.nt.dao;

import com.nt.domain.EmpDetails;

public interface EmployeeDAO {
	public void insertEmployee(int no,String fname,String lname,String email);
	public EmpDetails getEmployeeByNo(int no);
	public void changeEmailIdByNo(int no,String newEmail);

}
