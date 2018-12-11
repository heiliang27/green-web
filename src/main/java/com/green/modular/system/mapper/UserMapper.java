package com.green.modular.system.mapper;

import com.green.modular.system.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author limingliang
 * @since 2018-12-11
 */
public interface UserMapper extends BaseMapper<User> {

	User getUserByAccest(String account);

}
