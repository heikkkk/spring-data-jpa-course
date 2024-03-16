package com.example.demo.student.service;

import com.example.demo.student.dto.StudentDto;
import com.example.demo.student.dto.StudentResponseDto;
import com.example.demo.school.model.School;
import com.example.demo.student.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

  public Student toStudent(StudentDto dto) {
    Student student = new Student();
    student.setFirstName(dto.firstName());
    student.setLastName(dto.lastName());
    student.setEmail(dto.email());
    School school = new School();
    school.setId(dto.schoolId());
    student.setSchool(school);
    return student;
  }

  public StudentResponseDto toStudentResponseDto(Student student) {
    return new StudentResponseDto(
        student.getFirstName(),
        student.getLastName(),
        student.getEmail());
  }

}
