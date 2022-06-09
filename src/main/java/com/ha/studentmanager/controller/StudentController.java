package com.ha.studentmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ha.studentmanager.dto.StudentDto;
import com.ha.studentmanager.service.IStudentService;

@Controller
@RequestMapping("/")
public class StudentController {
	@Autowired
	private IStudentService studentService;
	private List<String> depNames = List.of("Anh văn", "Kinh tế", "Hóa học", "Sinh vật học", "Tin học", "Vật lý");

	@GetMapping
	public ModelAndView showList() {
		ModelAndView mav = new ModelAndView("studentManager");
		List<StudentDto> students = studentService.getStudents();
		mav.addObject("students", students);
		return mav;
	}

	@GetMapping("/student-{id}")
	public ModelAndView showDetail(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("studentDetail");
		StudentDto student = studentService.getStudent(id);
		mav.addObject("student", student);
		return mav;
	}

	@GetMapping("/student-edit-{id}")
	public ModelAndView showEdit(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("editStudent");
		StudentDto student = studentService.getStudent(id);
		mav.addObject("student", student);
		mav.addObject("depNames", depNames);
		return mav;
	}

	@PostMapping("/student-edit-{id}")
	public ModelAndView showEdit(@PathVariable String id, @ModelAttribute StudentDto student) {
//		ModelAndView mav = new ModelAndView("editStudent");
		StudentDto newStudent = studentService.saveStudent(student);
		ModelAndView mav = new ModelAndView("redirect:/");
//		mav.addObject("student",newStudent);
//		mav.addObject("depNames",depNames);
		return mav;
	}

	@GetMapping("/student-new")
	public ModelAndView showNew() {
		ModelAndView mav = new ModelAndView("newStudent");
		return mav;
	}

	@PostMapping("/createStudent")
	public ModelAndView creatStudent(@ModelAttribute StudentDto studentDto) {
		studentService.saveStudent(studentDto);
		return new ModelAndView("redirect:/");
	}

	@PostMapping("/student-delete")
	public ModelAndView deleteStudent(@RequestParam String[] ids) {
		studentService.deleteStudent(ids);
		ModelAndView mav = new ModelAndView("redirect:/");
		return mav;
	}
}
