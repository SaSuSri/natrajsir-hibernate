package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeService {
   public  int  getPageCount();
   public List<EmployeeDTO>  getReportData(int pageNo);
}
