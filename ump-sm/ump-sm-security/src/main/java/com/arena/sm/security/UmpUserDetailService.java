package com.arena.sm.security;

import com.arena.sm.service.ISysDeptService;
import com.arena.sm.service.ISysMenuService;
import com.arena.sm.service.ISysRoleService;
import com.arena.sm.service.ISysUserService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * UMP 用户服务
 *
 * @author guofazhan
 * @version [版本号, 2019/2/14 0014 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public abstract class UmpUserDetailService implements UserDetailsService, CustomUserDetailService {

	/**
	 * 部门服务
	 */
	private final ISysDeptService sysDeptService;

	/**
	 * 用户服务
	 */
	private final ISysUserService sysUserService;

	/**
	 * 菜单服务
	 */
	private final ISysMenuService sysMenuService;

	/**
	 * 角色服务
	 */
	private final ISysRoleService sysRoleService;

	public UmpUserDetailService(ISysDeptService sysDeptService, ISysUserService sysUserService,
			ISysMenuService sysMenuService, ISysRoleService sysRoleService) {
		this.sysDeptService = sysDeptService;
		this.sysUserService = sysUserService;
		this.sysMenuService = sysMenuService;
		this.sysRoleService = sysRoleService;
	}
}
