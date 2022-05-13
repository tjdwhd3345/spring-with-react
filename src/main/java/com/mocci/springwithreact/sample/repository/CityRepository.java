package com.mocci.springwithreact.sample.repository;

import java.util.List;

import com.mocci.springwithreact.sample.dto.City;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class CityRepository {
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  public CityRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  public List<City> findAll() {
    String sql = "select * from city limit 1000";

    RowMapper<City> cityMapper = (rs, rowNum) -> {
      City city = new City();
      city.setId(rs.getInt("id"));
      city.setName(rs.getString("name"));
      city.setCountryCode(rs.getString("countryCode"));
      city.setDistrict(rs.getString("district"));
      city.setPopulation(rs.getInt("population"));
      return city;
    };

    return namedParameterJdbcTemplate.query(sql, new MapSqlParameterSource(), cityMapper);
  }

  public List<City> findByCode(String countryCode) {
    String sql = "select * from city where countryCode = :countryCode";
    SqlParameterSource param = new MapSqlParameterSource("countryCode", countryCode);

    RowMapper<City> cityMapper = (rs, rowNum) -> {
      City city = new City();
      city.setId(rs.getInt("id"));
      city.setName(rs.getString("name"));
      city.setCountryCode(rs.getString("countryCode"));
      city.setDistrict(rs.getString("district"));
      city.setPopulation(rs.getInt("population"));
      return city;
    };

    return namedParameterJdbcTemplate.query(sql, param, cityMapper);
  }

}
