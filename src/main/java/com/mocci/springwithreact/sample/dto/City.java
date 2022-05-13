package com.mocci.springwithreact.sample.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {
  private Integer id;
  private String name;
  private String countryCode;
  private String district;
  private Integer population;
}