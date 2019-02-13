package com.arena.sm.model;

import com.arena.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * 用户对应角色的实体类
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@TableName("tab_sys_user_role")
public class SysUserRole extends BaseEntity<SysUserRole> {

	/**
	 * 主键ID
	 */
	@TableId(value = "id", type = IdType.UUID)
	private String id;

	/**
	 * 用户ID
	 */
	@TableField("user_id")
	private String userId;

	/**
	 * 角色ID
	 */
	@TableField("role_id")
	private String roleId;

	/**
	 * 用户姓名
	 */
	@TableField(exist = false)
	private String userName;

	/**
	 * 角色名称
	 */
	@TableField(exist = false)
	private String roleName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "SysUserRole{" + "id='" + id + '\'' + ", userId='" + userId + '\'' + ", roleId='" + roleId + '\''
				+ ", userName='" + userName + '\'' + ", roleName='" + roleName + '\'' + "} " + super.toString();
	}

	@Override
	protected Serializable pkVal() {
		return id;
	}
}
