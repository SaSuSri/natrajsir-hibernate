package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeHLO;

public interface EmployeeDAO {
	
	public long getEmployeesCount();
	public List<EmployeeHLO> getEmployeeDetails(int startPos);

}
