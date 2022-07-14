package com.student.crud.service;

import java.util.List;

import com.student.crud.entity.Student;

public interface StudentServiceInterface {
	public List<Student> findAll();
	public Student findById(int id);
	public void save(Student student);
	public void deleteById(int id);

}
