package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.core.ResponseMap;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "用户模块")
@RestController
@RequestMapping("/users")
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/*
	 * @RequestMapping("/index") public String index() { System.out.println("进来了");
	 * return "view/test"; }
	 */

	@ApiOperation(value = "获取用户列表", notes = "")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseMap list() {
		List<UserModel> list = userService.list();
		return ResponseMap.dataOf(list);
	}

	@ApiOperation(value = "获取用户详细信息", notes = "根据用户id来查询用户详细信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseMap fingOne(@RequestParam(value = "id") @ApiParam(name = "id", value = "用户id") Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserModel userModel = userService.findById(id);
		map.put("id", userModel.getId());
		map.put("age", userModel.getAge());
		map.put("name", userModel.getName());
		return ResponseMap.dataOf(map);
	}

	@ApiOperation(value = "创建用户", notes = "根据用户对象来创建用户")
	@ApiImplicitParam(name = "userModel", value = "用户对象", required = true, dataType = "UserModel")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseMap save(@ModelAttribute UserModel userModel) {
		userService.save(userModel);
		return ResponseMap.dataOf("success!!");

	}
}
