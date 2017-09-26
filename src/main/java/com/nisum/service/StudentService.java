package com.nisum.service;

import com.nisum.model.Student;

public interface StudentService {

	public void addStudent(Student student) throws Exception;

	public Iterable<Student> getAllStudent();

	public Student getStudentById(int rollNo) throws Exception;

	public void updateStudent(Student student) throws Exception;

	public void deleteStudent(int rollNo) throws Exception;

}
