package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// <1>
@Controller
public class HomeController {

  // <2>
  @GetMapping("/")

  public String home() {

    // <3>
    return "home";
  }

}
