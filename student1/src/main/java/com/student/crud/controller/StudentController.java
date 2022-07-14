package com.student.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.crud.entity.Student;
import com.student.crud.service.StudentServiceInterface;

@Controller
//@RestController("/students")
public class StudentController {

	@Autowired
	StudentServiceInterface studentService;
	
	@RequestMapping("/list")
	public String printStudent(Model model){
		List<Student> students = studentService.findAll();
		
		students.forEach(System.out::print);
		
		model.addAttribute("Student", students);
		return "StudentList";
	}
	
	@RequestMapping(value="/AddStudent")
	public String displayForm(Model model)
	{
		Student student = new Student();
		model.addAttribute("Student", student);
		return "SaveStudent";
	}
	
	@PostMapping(value ="/save")
	public String saveBook(@RequestParam int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("course") String course,
			@RequestParam("country") String country) {
		Student student = new Student();
		
		if(id!=0) {
			student.setId(id);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCourse(course);
			student.setCountry(country);
			studentService.save(student);
		} else {
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCourse(course);
			student.setCountry(country);
			studentService.save(student);
		}
		
		
		return "redirect:/list";
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam int id)
	{
		studentService.deleteById(id);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/update")
	public String updateForm(@RequestParam int id, Model model)
	{
		Student student = studentService.findById(id);
		model.addAttribute("Student", student);
		return "SaveStudent";
	}
}
