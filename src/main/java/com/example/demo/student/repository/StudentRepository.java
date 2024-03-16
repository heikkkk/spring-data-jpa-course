package com.example.demo.student.repository;

import com.example.demo.student.model.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

  List<Student> findAllByFirstNameContaining(String firstname);
}
