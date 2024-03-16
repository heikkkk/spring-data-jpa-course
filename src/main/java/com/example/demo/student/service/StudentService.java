package com.example.demo.student.service;

import com.example.demo.student.dto.StudentDto;
import com.example.demo.student.dto.StudentResponseDto;
import com.example.demo.student.model.Student;
import com.example.demo.student.repository.StudentRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final StudentRepository studentRepository;
  private final StudentMapper studentMapper;

  public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
    this.studentRepository = studentRepository;
    this.studentMapper = studentMapper;
  }

  public StudentResponseDto saveStudent(StudentDto dto) {
    Student student = studentMapper.toStudent(dto);
    Student savedStudent = studentRepository.save(student);
    return studentMapper.toStudentResponseDto(savedStudent);
  }


  public List<StudentResponseDto> findAllStudents() {
    return studentRepository.findAll()
        .stream()
        .map(studentMapper::toStudentResponseDto)
        .collect(Collectors.toList());
  }

  public StudentResponseDto findStudentById(Long id) {
    return studentRepository.findById(id)
        .map(studentMapper::toStudentResponseDto)
        .orElse(null);
  }

  public List<StudentResponseDto> findStudentsByName(String name) {
    return studentRepository.findAllByFirstNameContaining(name)
        .stream()
        .map(studentMapper::toStudentResponseDto)
        .collect(Collectors.toList());
  }

  public void deleteStudentById(Long id) {
    studentRepository.deleteById(id);
  }
}
