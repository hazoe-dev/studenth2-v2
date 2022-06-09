package com.ha.studentmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ha.studentmanager.dto.StudentDto;
import com.ha.studentmanager.model.Student;
import com.ha.studentmanager.service.IStudentService;

@RestController
public class StudentApi {
	@Autowired
	private IStudentService studentService;
	
	@GetMapping("/checkStudent/{id}")
	public ResponseEntity<Boolean> checkStudentID(@PathVariable String id) {
		return  ResponseEntity.ok((Boolean)studentService.existsStudentId(id));
	}
	
	@DeleteMapping("/deleteStudent")
	public ResponseEntity<List<String>> deleteStudent(@RequestParam String[] ids) {
		return  ResponseEntity.ok((List<String>)studentService.deleteStudent(ids));
	}
	
}
