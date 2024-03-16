package com.example.demo.school.service;

import com.example.demo.school.dto.SchoolDto;
import com.example.demo.school.model.School;
import com.example.demo.school.repository.SchoolRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {

  private final SchoolRepository schoolRepository;
  private final SchoolMapper schoolMapper;

  public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
    this.schoolRepository = schoolRepository;
    this.schoolMapper = schoolMapper;
  }

  public SchoolDto createSchool(SchoolDto dto) {
    School school = schoolMapper.toSchool(dto);
    schoolRepository.save(school);
    return dto;
  }

  public List<SchoolDto> findAllSchools() {
    return schoolRepository.findAll()
        .stream()
        .map(schoolMapper::toSchoolDto)
        .collect(Collectors.toList());
  }
}
