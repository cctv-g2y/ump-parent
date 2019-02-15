package com.arena.sm.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 认证校验接口实现
 * @author guofazhan
 * @version [版本号, 2019/2/14 0014 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class UmpAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	/**
	 *
	 */
	private final UserDetailsService userDetailsService;

	public UmpAuthenticationProvider(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		System.out.println("===================================");
		throw new BadCredentialsException("Authentication failed for this username and password");
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		return userDetailsService.loadUserByUsername(username);
	}
}
