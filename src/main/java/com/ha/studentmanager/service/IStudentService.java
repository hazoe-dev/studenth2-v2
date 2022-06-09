package com.ha.studentmanager.service;

import java.util.List;

import com.ha.studentmanager.dto.StudentDto;
import com.ha.studentmanager.model.Student;

public interface IStudentService {
	public StudentDto getStudent(String id);

	public List<StudentDto> getStudents();

	public StudentDto saveStudent(StudentDto studentDto);
	
	public void deleteStudent(String id);

	public Boolean existsStudentId(String id);

	public List<String> deleteStudent(String[] ids);
	
}
