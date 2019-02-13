package com.arena.sm.model;

import com.arena.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * 角色对应权限的实体类
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@TableName("tab_sys_role_menu")
public class SysRoleMenu extends BaseEntity<SysRoleMenu> {

	/**
	 * 主键id
	 */
	@TableId(value = "id", type = IdType.UUID)
	private String id;

	/**
	 * 角色ID
	 */
	@TableField("role_id")
	private String roleId;

	/**
	 * 菜单ID
	 */
	@TableField("menu_id")
	private String menuId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		return "SysRoleMenu{" + "id='" + id + '\'' + ", roleId='" + roleId + '\'' + ", menuId='" + menuId + '\'' + "} "
				+ super.toString();
	}

	@Override
	protected Serializable pkVal() {
		return id;
	}
}
