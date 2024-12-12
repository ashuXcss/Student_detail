package com.kit.Service;

import java.util.List;
import java.util.Optional;

import com.kit.Model.Student;

public interface StudentService {
	public List<Student> getAllStudent();
	public Optional<Student> getStudentById(Long id);
	public Student createStudent(Student student);
	public void deleteStudentById(Long id);

}
