package com.nt.service;

import java.util.List;

import com.nt.dto.StudentDTO;

public interface StudentService {
	public List<StudentDTO> fetchAllStudents(); 
	public StudentDTO fetchStudentByNo(int no);
	public  String  modifyStudent(StudentDTO dto);

}
