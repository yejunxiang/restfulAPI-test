package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.UserModel;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<UserModel> list() {
		return userDao.findAll();
	}

	public UserModel findById(Long id) {
		return userDao.getOne(id);
	}

}
