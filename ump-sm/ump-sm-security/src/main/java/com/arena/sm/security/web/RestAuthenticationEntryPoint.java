package com.arena.sm.security.web;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * 匿名用户访问rest api无权限资源时的异常处理
 *
 * @author guofazhan
 * @version [版本号, 2019/2/15 0015 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
	@Override
	public void commence(javax.servlet.http.HttpServletRequest httpServletRequest,
			javax.servlet.http.HttpServletResponse httpServletResponse, AuthenticationException e)
			throws IOException, ServletException {
		httpServletResponse.setStatus(HttpStatus.BAD_GATEWAY.value());
		httpServletResponse.setCharacterEncoding("utf-8");
	}
}
