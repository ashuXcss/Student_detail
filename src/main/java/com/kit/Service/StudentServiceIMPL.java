package com.kit.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.Model.Student;
import com.kit.Repo.StudentRepo;

@Service
public class StudentServiceIMPL implements StudentService {
	@Autowired
     private StudentRepo studentRepo;
	@Override
	public List<Student> getAllStudent() {
		
		return studentRepo.findAll();
	}

	@Override
	public Optional<Student> getStudentById(Long id) {
		return studentRepo.findById(id);
	}

	@Override
	public Student createStudent(Student student) {
		   
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepo.deleteById(id);
		
	}
	

}
