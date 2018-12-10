package com.green.modular.system.service.impl;

import com.green.modular.system.entity.User;
import com.green.modular.system.mapper.UserMapper;
import com.green.modular.system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author limingliang
 * @since 2018-12-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
