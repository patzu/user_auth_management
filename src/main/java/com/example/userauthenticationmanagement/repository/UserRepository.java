package com.example.userauthenticationmanagement.repository;

import com.example.userauthenticationmanagement.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MyUser, Long> {

}
