package com.student.crud.service;


import java.util.List;
import java.util.Optional;

import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.crud.entity.Student;
import com.student.crud.repository.StudentRepository;

@Service
public class StudentSeviceImplementation implements StudentServiceInterface {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

	@Override
	public Student findById(int id) {
		Optional<Student> student;
		student = studentRepository.findById(id);
		return student.get();
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);
		
	}

	@Override
	public void deleteById(int id) {
		studentRepository.deleteById(id);
		
	}
	
	

}
