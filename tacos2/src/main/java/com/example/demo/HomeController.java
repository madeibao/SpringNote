package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller            // <1>
public class HomeController {

  // <2>
  @GetMapping("/")
  public String home() {
    // <3>
    return "home";
  }

}
