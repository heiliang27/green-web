package com.green.modular.system.service.impl;

import com.green.core.datasource.annotation.DataSource;
import com.green.modular.system.entity.User;
import com.green.modular.system.mapper.UserMapper;
import com.green.modular.system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author limingliang
 * @since 2018-12-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
	@Autowired
	UserMapper userMapper;

	/** 查询用户信息通过用户名称 */
	@Override
	@DataSource(name = "hadesDataSource")
	public User getUserByAccest(String account) {
		return userMapper.getUserByAccest(account);
	}	

}
