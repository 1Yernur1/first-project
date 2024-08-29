package com.example.first_project;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class MyController {
  @GetMapping("/")
  public ResponseEntity<MyEntity> getMyEntity() {
    MyEntity myEntity = new MyEntity(1L, "myEntity");
    return ResponseEntity.ok(myEntity);
  }
}
