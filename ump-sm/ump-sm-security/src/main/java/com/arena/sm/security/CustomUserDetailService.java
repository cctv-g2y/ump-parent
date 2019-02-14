package com.arena.sm.security;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author guofazhan
 * @version [版本号, 2019/2/14 0014 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface CustomUserDetailService {

	/**
	 * 加载用户信息根据用户ID
	 *
	 * @param userId
	 * @return
	 */
	UserDetails loadByUserId(final String userId);

	/**
	 * 加载用户信息根据username
	 *
	 * @param username
	 * @return
	 */
	UserDetails loadUserByUsername(final String username);
}
