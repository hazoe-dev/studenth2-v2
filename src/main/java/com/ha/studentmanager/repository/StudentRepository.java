package com.ha.studentmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ha.studentmanager.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{

	boolean existsById(String id);

}
