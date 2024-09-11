package com.example.first_project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepoSitory extends JpaRepository<MyEntity, Long> {

}
