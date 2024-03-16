package com.example.demo.student.controller;

import com.example.demo.student.dto.StudentDto;
import com.example.demo.student.dto.StudentResponseDto;
import com.example.demo.student.service.StudentService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {


  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @PostMapping("/students")
  public StudentResponseDto saveStudent(
      @RequestBody StudentDto dto
  ) {
      return this.studentService.saveStudent(dto);
  }

  @GetMapping("/students")
  public List<StudentResponseDto> findAllStudents() {
    return this.studentService.findAllStudents();
  }

  @GetMapping("/students/{student-id}")
  public StudentResponseDto findStudentById(
      @PathVariable("student-id") Long id
  ) {
      return this.studentService.findStudentById(id);
  }

  @GetMapping("/students/search/{student-name}")
  public List<StudentResponseDto> findStudentsByName(
      @PathVariable("student-name") String name
  ) {
      return this.studentService.findStudentsByName(name);
  }

  @DeleteMapping("students/{student-id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(
      @PathVariable("student-id") Long id
  ) {
      studentService.deleteStudentById(id);
  }


}
