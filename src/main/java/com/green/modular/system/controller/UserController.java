package com.green.modular.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.green.common.base.BaseController;
import com.green.modular.system.entity.User;
import com.green.modular.system.service.IUserService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author limingliang
 * @since 2018-12-11
 */
@RestController
@RequestMapping("/system/user")
public class UserController extends BaseController {
	@Autowired
	IUserService userService;

	/** 查询用户信息通过用户名称 */
	@RequestMapping(value = "/account/{account}", method = RequestMethod.GET)
	public User getUserByAccest(@PathVariable("account") String account) {
		User user = userService.getUserByAccest(account);
		return user;
	}
	
	@RequestMapping("/list")
	public List<User> list(){
		return userService.list(null);
	}
	
}
