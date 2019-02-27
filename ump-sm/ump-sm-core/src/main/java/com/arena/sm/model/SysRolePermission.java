package com.arena.sm.model;

import com.arena.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * 角色权限对应关系
 *
 * @author guofazhan
 * @version [版本号, 2019/2/27 0027 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@TableName("tab_sys_role_permission")
public class SysRolePermission extends BaseEntity<SysRolePermission> {

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
	 * 权限 ID
	 */
	@TableField("permission_id")
	private String permissionId;

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

	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	@Override
	public String toString() {
		return "SysRolePermission{" + "id='" + id + '\'' + ", roleId='" + roleId + '\'' + ", permissionId='"
				+ permissionId + '\'' + "} " + super.toString();
	}

	@Override
	protected Serializable pkVal() {
		return id;
	}
}
