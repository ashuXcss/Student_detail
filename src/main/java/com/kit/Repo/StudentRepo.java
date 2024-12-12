package com.kit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.Model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
