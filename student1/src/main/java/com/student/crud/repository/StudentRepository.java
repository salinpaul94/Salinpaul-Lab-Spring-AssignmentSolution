package com.student.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.crud.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	public String findByFirstName(String firstName);

}
