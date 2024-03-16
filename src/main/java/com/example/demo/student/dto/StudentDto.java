package com.example.demo.student.dto;

public record StudentDto(
    String firstName,
    String lastName,
    String email,
    Long schoolId
) {
}
