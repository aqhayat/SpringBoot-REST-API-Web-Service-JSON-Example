package com.nisum.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nisum.model.Student;

@Service
public class StudentServiceImplementation implements StudentService {

	Map<Integer, Student> map = new HashMap<Integer, Student>();

	@Override
	public void addStudent(Student student) throws Exception {

		if (map.containsKey(student.getRollNo())) {

			throw new Exception("Student Already Exists");

		}

		else {

			map.put(student.getRollNo(), student);
		}

	}

	@Override
	public Iterable<Student> getAllStudent() {

		return map.values();

	}

	@Override
	public Student getStudentById(int rollNo) throws Exception {

		if (map.containsKey(rollNo)) {

			return map.get(rollNo);

		}
		
		else {

			throw new Exception("Student Not Found");
		}

	}

	@Override
	public void updateStudent(Student student) throws Exception {

		if (map.containsKey(student.getRollNo()))

			map.put(student.getRollNo(), student);

		else {

			throw new Exception("Student Not Found");

		}

	}

	@Override
	public void deleteStudent(int rollNo) throws Exception {

		if (map.containsKey(rollNo))

			map.remove(rollNo);

		else {

			throw new Exception("Student Not Found");
		}

	}

}
