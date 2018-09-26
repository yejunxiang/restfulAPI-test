package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.model.UserModel;

public interface UserDao extends JpaRepository<UserModel, Long>, JpaSpecificationExecutor<UserModel> {

}
