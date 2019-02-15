package com.arena.sm.security;

import com.arena.sm.model.SysDept;
import com.arena.sm.model.SysMenu;
import com.arena.sm.model.SysRole;
import com.arena.sm.model.SysUser;
import com.arena.sm.service.ISysDeptService;
import com.arena.sm.service.ISysMenuService;
import com.arena.sm.service.ISysRoleService;
import com.arena.sm.service.ISysUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * UMP 用户服务
 *
 * @author guofazhan
 * @version [版本号, 2019/2/14 0014 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DefaultUmpUserDetailService implements UserDetailsService {

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

	public DefaultUmpUserDetailService(ISysDeptService sysDeptService, ISysUserService sysUserService,
			ISysMenuService sysMenuService, ISysRoleService sysRoleService) {
		this.sysDeptService = sysDeptService;
		this.sysUserService = sysUserService;
		this.sysMenuService = sysMenuService;
		this.sysRoleService = sysRoleService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		SysUser user = null;
		try {
			user = sysUserService.selectUserByUsername(username);
		} catch (Exception ex) {
			// don't care
		}
		if (null == user) {
			throw new UsernameNotFoundException(String.format("user (%s) could not be found", username));
		}
		return createUmpAppUser(user);
	}

	/**
	 * 根据SysUser创建UmpAppUser
	 *
	 * @param user
	 * @return
	 */
	protected UmpAppUser createUmpAppUser(SysUser user) {
		String userId = user.getUserId();
		SysDept dept = findDeptById(user.getDeptId());
		List<SysRole> roles = findRoleByUserId(userId);
		List<SysMenu> menus = findMenuByUserId(userId);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		return new UmpAppUser(user, true, dept, roles, menus, grantedAuthorities);
	}

	/**
	 * 根据deptId 查询部门信息
	 *
	 * @param deptId
	 * @return
	 */
	protected SysDept findDeptById(String deptId) {
		SysDept dept = null;
		try {
			dept = sysDeptService.selectById(deptId);
		} catch (Exception ex) {
			// don't care
		}
		return dept;
	}

	/**
	 * 根据用户ID查询角色列表
	 *
	 * @param userId
	 * @return
	 */
	protected List<SysRole> findRoleByUserId(String userId) {
		List<SysRole> roles = null;
		try {
			roles = sysRoleService.selectByUserId(userId);
		} catch (Exception ex) {
			// don't care
		}
		return roles;
	}

	/**
	 * 根据用户ID查询菜单列表
	 *
	 * @param userId
	 * @return
	 */
	protected List<SysMenu> findMenuByUserId(String userId) {
		List<SysMenu> menus = null;
		try {
			menus = sysMenuService.selectByUserId(userId);
		} catch (Exception ex) {
			// don't care
		}
		return menus;
	}
}
