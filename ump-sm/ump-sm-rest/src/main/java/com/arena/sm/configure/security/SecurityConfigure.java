package com.arena.sm.configure.security;

import com.arena.sm.security.CacheUmpUserDetailService;
import com.arena.sm.security.DefaultUmpUserDetailService;
import com.arena.sm.security.UmpAuthenticationProvider;
import com.arena.sm.security.cache.UmpAppUserCacheProperties;
import com.arena.sm.service.ISysDeptService;
import com.arena.sm.service.ISysMenuService;
import com.arena.sm.service.ISysRoleService;
import com.arena.sm.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

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
	@Primary
	@ConfigurationProperties("ump.user.cache")
	public UmpAppUserCacheProperties cacheProperties() {
		return new UmpAppUserCacheProperties();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new CacheUmpUserDetailService(
				new DefaultUmpUserDetailService(sysDeptService, sysUserService, sysMenuService, sysRoleService),
				cacheProperties());
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		return new UmpAuthenticationProvider(userDetailsService());
	}

	@Order(1)
	@Configuration
	@EnableWebSecurity
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

		@Autowired
		private AuthenticationProvider authenticationProvider;

		@Autowired
		private UserDetailsService userDetailsService;

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.authenticationProvider(authenticationProvider).userDetailsService(userDetailsService);
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/rest/user/find/**").permitAll().and().antMatcher("/rest/**")
					.authorizeRequests().antMatchers("/rest/**").authenticated();
			http.httpBasic();
//			//设置认证异常处理器
//			http.exceptionHandling().authenticationEntryPoint(new RestAuthenticationEntryPoint())
//					.accessDeniedHandler(new RestAccessDeineHandler());
		}
	}
}
