package com.mocci.springwithreact.sample.controller;

import java.util.List;

import com.mocci.springwithreact.sample.dto.City;
import com.mocci.springwithreact.sample.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("city")
public class CityController {
  private CityService cityService;

  @Autowired
  public CityController(CityService cityService) {
    this.cityService = cityService;
  }

  @GetMapping("all")
  public List<City> getAllCityList() {
    List<City> cityList = cityService.getCityAllList();
    return cityList;
  }

  @GetMapping("{countryCode}")
  public List<City> getCityByCode(@PathVariable("countryCode") String countryCode) {
    List<City> cityList = cityService.getCityByCode(countryCode);
    return cityList;
  }
}
