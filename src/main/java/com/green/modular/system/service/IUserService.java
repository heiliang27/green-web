package com.green.modular.system.service;

import com.green.modular.system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author limingliang
 * @since 2018-12-11
 */
public interface IUserService extends IService<User> {

	User getUserByAccest(String account);

}
