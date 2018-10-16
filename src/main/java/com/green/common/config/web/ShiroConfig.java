package com.green.common.config.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.green.common.core.shiro.MyShiroRealm;

/**
 * @author limingliang
 * @version 2018年10月12日 上午10:37:24
 */
@Configuration
public class ShiroConfig {

	/** 安全管理器 */
	@Bean
	public DefaultWebSecurityManager securityManager(MyShiroRealm myShiroRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm);
		return securityManager;
	}

	
	/** 保证实现了Shiro内部lifecycle函数的bean执行 */
	@Bean
	public LifecycleBeanPostProcessor lifecycleBean() {
		return new LifecycleBeanPostProcessor();
	}

	
	/** Shiro的过滤器链 */
	@Bean
	public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(securityManager);
		/**	* 默认的登陆访问url */
		shiroFilter.setLoginUrl("/login");
		/** * 登陆成功后跳转的url */
		shiroFilter.setSuccessUrl("/");
		/**	* 没有权限跳转的url	 */
		shiroFilter.setUnauthorizedUrl("/global/error");
		/** * 配置shiro拦截器链		 *
		 * anon 不需要认证 authc 需要认证 user 验证通过或RememberMe登录的都可以
		 */
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("/static/**", "anon");
		hashMap.put("/login", "anon");
		hashMap.put("/kaptcha", "anon");
		hashMap.put("/**", "user");
		shiroFilter.setFilterChainDefinitionMap(hashMap);
		return shiroFilter;
	}

	/** TODO 自定义的Realm*/
	@Bean
	public MyShiroRealm myShiroRealm() {
		return new MyShiroRealm();
	}
}
