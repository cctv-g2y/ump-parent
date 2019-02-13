package com.arena.sm.model;

import com.arena.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.List;

/**
 * 系统角色实体类
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@TableName("tab_sys_role")
public class SysRole extends BaseEntity<SysRole> {

	/**
	 * 角色id
	 */
	@TableId(value = "id", type = IdType.UUID)
	private String roleId;

	/**
	 * 角色名称
	 */
	@TableField("role_name")
	private String roleName;

	/**
	 * 权限id列表
	 */
	@TableField(exist = false)
	private List<String> menuIdList;

	/**
	 * 备注
	 */
	@TableField("mark")
	private String mark;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<String> getMenuIdList() {
		return menuIdList;
	}

	public void setMenuIdList(List<String> menuIdList) {
		this.menuIdList = menuIdList;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "SysRole{" + "roleId='" + roleId + '\'' + ", roleName='" + roleName + '\'' + ", menuIdList=" + menuIdList
				+ ", mark='" + mark + '\'' + "} " + super.toString();
	}

	@Override
	protected Serializable pkVal() {
		return roleId;
	}
}
