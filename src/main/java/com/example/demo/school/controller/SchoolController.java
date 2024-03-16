package com.example.demo.school.controller;

import com.example.demo.school.dto.SchoolDto;
import com.example.demo.school.service.SchoolService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {

  private final SchoolService schoolService;

  public SchoolController(SchoolService schoolService) {
    this.schoolService = schoolService;
  }

  @PostMapping("/schools")
  public SchoolDto createSchool(
      @RequestBody SchoolDto dto
  ) {
    return this.schoolService.createSchool(dto);
  }

  @GetMapping("/schools")
  public List<SchoolDto> findAllSchools() {
    return schoolService.findAllSchools();
  }


}
