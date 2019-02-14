package com.arena.sm.configure.security;

import com.arena.sm.security.UmpAuthenticationProvider;
import com.arena.sm.security.UmpUserDetailService;
import com.arena.sm.service.ISysDeptService;
import com.arena.sm.service.ISysMenuService;
import com.arena.sm.service.ISysRoleService;
import com.arena.sm.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * 安全相关的配置信息
 *
 * @author guofazhan
 * @version [版本号, 2019/2/14 0014 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
public class SecurityConfigure {

	/**
	 * 部门服务
	 */
	@Autowired
	private ISysDeptService sysDeptService;

	/**
	 * 用户服务
	 */
	@Autowired
	private ISysUserService sysUserService;

	/**
	 * 菜单服务
	 */
	@Autowired
	private ISysMenuService sysMenuService;

	/**
	 * 角色服务
	 */
	@Autowired
	private ISysRoleService sysRoleService;

	@Bean
	public UmpUserDetailService userDetailsService() {
		return new UmpUserDetailService(sysDeptService, sysUserService, sysMenuService, sysRoleService);
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		return new UmpAuthenticationProvider(userDetailsService());
	}

	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/rest/**").authorizeRequests().antMatchers("/rest/**").authenticated().and().httpBasic();
		}
	}
}
