package com.mocci.springwithreact.sample.service;

import java.util.List;

import com.mocci.springwithreact.sample.dto.City;
import com.mocci.springwithreact.sample.repository.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
  private final CityRepository cityRepository;

  @Autowired
  public CityService(CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  public List<City> getCityAllList() {
    return this.cityRepository.findAll();
  }

  public List<City> getCityByCode(String countriCode) {
    return this.cityRepository.findByCode(countriCode);
  }
}
