package com.kit.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kit.Model.Student;
import com.kit.Service.StudentServiceIMPL;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:5173") 
public class StudentController {
	@Autowired
	private StudentServiceIMPL studentServiceIMPL;
	@GetMapping
	public List<Student>getAllStudent(){
		return studentServiceIMPL.getAllStudent();
	}
	@GetMapping("/{id}")
	public Optional<Student>getStudentById(@PathVariable Long id){
		return studentServiceIMPL.getStudentById(id);
	}
	@PostMapping
    public Student createStudent(@RequestBody Student student) {
		return studentServiceIMPL.createStudent(student);
	}
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		System.out.println(" this work");
		studentServiceIMPL.deleteStudentById(id);
	}

}
