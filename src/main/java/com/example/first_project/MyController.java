package com.example.first_project;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MyController {

  @Autowired
  private MyService myService;

  @GetMapping("/")
  public List<MyEntity> getAll() {
    return myService.getAllMyEntities();
  }

  @GetMapping("/{id}")
  public ResponseEntity<MyEntity> getById(@PathVariable Long id) {
    return myService.getMyEntityById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping("/")
  public MyEntity create(@RequestBody MyEntity myEntity) {
    return myService.createMyEntity(myEntity);
  }

  @PutMapping("/{id}")
  public MyEntity update(@PathVariable Long id, @RequestBody MyEntity myEntity) {
    return myService.updateMyEntity(id, myEntity);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    myService.deleteMyEntity(id);
    return ResponseEntity.noContent().build();
  }
}
