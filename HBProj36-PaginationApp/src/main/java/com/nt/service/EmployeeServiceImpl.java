package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.EmployeeHLO;
import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOFactory;
import com.nt.dto.EmployeeDTO;
import com.nt.utility.ReportParameters;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public int getPageCount() {
		int pagesCount=0;
		long recordsCount=0;
		EmployeeDAO dao=null;
		//get & use DAO
		dao=EmployeeDAOFactory.getInstance();
		recordsCount=dao.getEmployeesCount();
		pagesCount=(int)recordsCount/ReportParameters.PAGE_SIZE;
		
		if(recordsCount%ReportParameters.PAGE_SIZE!=0)
			pagesCount++;
		return pagesCount;
	}

	@Override
	public List<EmployeeDTO> getReportData(int pageNo) {
		  int startPos=0;
		  EmployeeDAO dao=null;
		  List<EmployeeHLO> listBO=null;
		  List<EmployeeDTO> listDTO=null;
		  EmployeeDTO dto=null;
         //get StartPos to get records for  pagination
		  startPos=(pageNo*ReportParameters.PAGE_SIZE)-ReportParameters.PAGE_SIZE;
		  //get & use DAO
			dao=EmployeeDAOFactory.getInstance();
		   listBO=dao.getEmployeeDetails(startPos);
		   //convert ListBO to ListDTO
		   listDTO=new ArrayList<EmployeeDTO>();
		   for(EmployeeHLO bo:listBO){
			   dto=new EmployeeDTO();
			   dto.setEid(bo.getEid());
			   dto.setFirstName(bo.getFirstName());
			   dto.setLastName(bo.getLastName());
			   dto.setEmail(bo.getEmail());
			   listDTO.add(dto);
		   }
		return listDTO;
	}//method
}//class
