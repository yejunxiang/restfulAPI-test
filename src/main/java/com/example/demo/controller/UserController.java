package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.core.ResponseMap;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String index() {
		return "welcome to springboot!!!";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseMap list() {
		List<UserModel> list = userService.list();
		return ResponseMap.dataOf(list);
	}

	@RequestMapping("/findOne")
	public ResponseMap fingOne(@RequestParam(value = "id") Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserModel userModel = userService.findById(id);

		map.put("id", userModel.getId());
		map.put("age", userModel.getAge());
		map.put("name", userModel.getName());

		return ResponseMap.dataOf(map);
	}
}
