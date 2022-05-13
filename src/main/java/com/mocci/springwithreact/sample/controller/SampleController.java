package com.mocci.springwithreact.sample.controller;

import com.mocci.springwithreact.sample.dto.SampleDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sample")
public class SampleController {

  @RequestMapping(path = "/greeting", method = RequestMethod.GET)
  // @GetMApping("/greeting") 동일함
  public String main() {
    // return "hi spring controller";
    return "greeting.html";
  }

  @GetMapping("/member")
  public SampleDTO getMember() {
    SampleDTO sd = new SampleDTO();
    sd.name = "sungjong";
    sd.number = 1012345678;
    sd.juso = "aaa";
    return sd;
  }

}
