package com.example.demo.studentprofile;

import com.example.demo.student.model.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class StudentProfile {

  @Id
  @GeneratedValue
  private Long id;
  private String bio;
  @OneToOne
  @JoinColumn(
      name = "student_id"
  )
  private Student student;

  public StudentProfile() {
  }

  public StudentProfile(String bio) {
    this.bio = bio;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Student getStudent() {
    return student;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }
}
