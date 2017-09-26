package com.nisum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.model.Student;
import com.nisum.service.StudentServiceImplementation;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentServiceImplementation studentServiceImplementation;

		
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public Iterable<Student> getAllStudent() {

		return studentServiceImplementation.getAllStudent();

	}

	
	@RequestMapping(value = "/student/{rollNo}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable int rollNo) throws Exception {
		
		
		return studentServiceImplementation.getStudentById(rollNo);

	}
	
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public void addStudent(@RequestBody Student student) throws Exception {
		
		studentServiceImplementation.addStudent(student);
		
	}
	
	
	@RequestMapping(value = "/student/{rollNo}", method = RequestMethod.PUT)
	public void updateStudent(@PathVariable int rollNo, @RequestBody Student student) throws Exception {
		
		student.setRollNo(rollNo);
		
		studentServiceImplementation.updateStudent(student);
	}
	
	
	@RequestMapping(value = "/student/{rollNo}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable int rollNo) throws Exception {
		
		studentServiceImplementation.deleteStudent(rollNo);
		
	}
}
