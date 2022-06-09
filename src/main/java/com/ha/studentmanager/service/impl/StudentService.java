package com.ha.studentmanager.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ha.studentmanager.dto.StudentDto;
import com.ha.studentmanager.model.Student;
import com.ha.studentmanager.repository.StudentRepository;
import com.ha.studentmanager.service.IStudentService;

@Service
public class StudentService implements IStudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentDto getStudent(String id) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found by id = " + id));
		StudentDto dto = convertStudentToDto(student);
		return dto;
	}

	private StudentDto convertStudentToDto(Student student) {
		StudentDto dto = new StudentDto();
		BeanUtils.copyProperties(student, dto);
		Calendar birthday = student.getBirthday();
		if (birthday != null) {
			dto.setBirthday(formatDate(birthday));
		}
		return dto;
	}

	private Student convertDtoToStudent(StudentDto dto) {
		Student entity = new Student();
		BeanUtils.copyProperties(dto, entity);
		String sBirthday = dto.getBirthday();
		if (sBirthday != null && sBirthday != "") {
			String[] arrDate = sBirthday.split("-");
			if (arrDate.length == 3) {
				int year = Integer.parseInt(arrDate[0]);
				int month = Integer.parseInt(arrDate[1]) - 1;
				int day = Integer.parseInt(arrDate[2]);

				Calendar c = Calendar.getInstance();
				c.set(year, month, day);
				entity.setBirthday(c);
			}
		}
		return entity;
	}

	private String formatDate(Calendar calendar) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");// yyyy-mm-dd hh:mm:ss
		return dateFormat.format(calendar.getTime());
	}

	@Override
	public List<StudentDto> getStudents() {

		List<Student> students = studentRepository.findAll();
		return students.stream().map(item -> {
			return convertStudentToDto(item);
		}).collect(Collectors.toList());
	}

	@Transactional
	@Override
	public StudentDto saveStudent(StudentDto studentDto) {
		Student student = convertDtoToStudent(studentDto);
		Student newStudent = studentRepository.save(student);

		StudentDto newStudentDto = convertStudentToDto(newStudent);
		return newStudentDto;
	}

	@Transactional
	@Override
	public void deleteStudent(String id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Boolean existsStudentId(String id) {
		return studentRepository.existsById(id);
	}

	@Transactional
	@Override
	public List<String> deleteStudent(String[] ids) {
		List<String> results = new ArrayList<>();
		for (String id : ids) {
			studentRepository.deleteById(id);
			results.add(id);
		}
		return results;
	}

}
