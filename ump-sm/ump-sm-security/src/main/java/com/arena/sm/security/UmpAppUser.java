package com.arena.sm.security;

import com.arena.sm.model.SysDept;
import com.arena.sm.model.SysMenu;
import com.arena.sm.model.SysRole;
import com.arena.sm.model.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 用户信息
 *
 * @author guofazhan
 * @version [版本号, 2019/2/14 0014 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class UmpAppUser extends User implements UmpUserDetails {

	/**
	 * 用户信息
	 */
	private final SysUser user;
	/**
	 * 部门信息
	 */
	private final SysDept dept;
	/**
	 * 角色信息
	 */
	private final List<SysRole> roles;

	/**
	 * 菜单信息
	 */
	private final List<SysMenu> menus;

	public UmpAppUser(SysUser user, boolean enabled, SysDept dept, List<SysRole> roles, List<SysMenu> menus,
			Collection<? extends GrantedAuthority> authorities) {
		super(user.getUsername(), user.getPassword() == null ? "" : user.getPassword(), enabled, true, true, true,
				authorities);
		this.user = user;
		this.dept = dept;
		this.roles = null != roles ? Collections.unmodifiableList(roles) : Collections.EMPTY_LIST;
		this.menus = null != menus ? Collections.unmodifiableList(menus) : Collections.EMPTY_LIST;
	}

	@Override
	public SysUser getUser() {
		return user;
	}

	@Override
	public SysDept getDept() {
		return dept;
	}

	@Override
	public List<SysRole> getRoles() {
		return roles;
	}

	@Override
	public List<SysMenu> getMenus() {
		return menus;
	}
}
