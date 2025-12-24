package com.attendance.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.attendance.model.Student;
import com.attendance.repository.StudentRepository;

@Service
public class StudentService {

	private final StudentRepository repo;

	public StudentService(StudentRepository repo) {
		this.repo = repo;
	}

	public Student save(Student s) {
		return repo.save(s);
	}

	public List<Student> getAll() {
		return repo.findAll();
	}
}
