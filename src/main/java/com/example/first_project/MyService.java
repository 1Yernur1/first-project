package com.example.first_project;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
  private final MyRepoSitory myRepoSitory;

  @Autowired
  public MyService(MyRepoSitory myRepoSitory) {
    this.myRepoSitory = myRepoSitory;
  }

  public List<MyEntity> getAllMyEntities() {
    return myRepoSitory.findAll();
  }

  public Optional<MyEntity> getMyEntityById(Long id) {
    return myRepoSitory.findById(id);
  }

  public MyEntity createMyEntity(MyEntity myEntity) {
    return myRepoSitory.save(myEntity);
  }

  public MyEntity updateMyEntity(Long id, MyEntity myEntity) {
    MyEntity newMyEntity = myRepoSitory.findById(id).orElseThrow();
    newMyEntity.setName(myEntity.getName());
    return myRepoSitory.save(newMyEntity);
  }

  public void deleteMyEntity(Long id) {
    myRepoSitory.deleteById(id);
  }
}
