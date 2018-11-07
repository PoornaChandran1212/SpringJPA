package com.kg.spjpa.repository;

import com.kg.spjpa.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// import com.javaspringclub.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}