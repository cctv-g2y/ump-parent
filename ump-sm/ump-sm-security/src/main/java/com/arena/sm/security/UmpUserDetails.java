package com.arena.sm.security;

import com.arena.sm.model.SysDept;
import com.arena.sm.model.SysMenu;
import com.arena.sm.model.SysRole;
import com.arena.sm.model.SysUser;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * 用户详情信息
 *
 * @author guofazhan
 * @version [版本号, 2019/2/14 0014 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface UmpUserDetails extends UserDetails {

	/**
	 * 获取用户信息
	 *
	 * @return
	 */
	SysUser getUser();

	/**
	 * 获取用户部门
	 *
	 * @return
	 */
	SysDept getDept();

	/**
	 * 获取用户角色
	 *
	 * @return
	 */
	List<SysRole> getRoles();

	/**
	 * 获取用户菜单信息
	 *
	 * @return
	 */
	List<SysMenu> getMenus();
}
