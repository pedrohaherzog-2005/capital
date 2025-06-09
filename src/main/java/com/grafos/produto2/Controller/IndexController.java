package com.grafos.produto2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grafos.produto2.Services.IndexServices;

@RestController
@RequestMapping("/grafos")
public class IndexController {
  @Autowired
  private IndexServices indexServices;
  public IndexController(IndexServices indexServices) {
    this.indexServices = indexServices;
  }

  @GetMapping("/get")
  public String getIndexController(){
    return indexServices.Index();
  }

  @PostMapping("")
  public String postIndexController(/*Body body*/){
    return "";
  }
}
