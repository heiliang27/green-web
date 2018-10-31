package com.green.common.core.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.green.modular.entity.User;

/**
 * @author limingliang
 * @version 2018年10月12日 上午10:39:23
 */
public class MyShiroRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		/*User user = new User();
		for (SysRole role : user.getRoleid()) {
			authorizationInfo.addRole(role.getRole());
			for (SysPermission p : role.getPermissions()) {
				authorizationInfo. (p.getPermission());
			}
		}*/
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		User userInfo = new User();				
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, // 用户名
				userInfo.getPassword(), // 密码
				ByteSource.Util.bytes(userInfo.getSalt()), // salt=username+salt
				getName() // realm name
		);
		return authenticationInfo;
	}

}
