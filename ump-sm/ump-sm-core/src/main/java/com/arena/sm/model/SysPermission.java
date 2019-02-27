package com.arena.sm.model;

import com.arena.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * 系统权限信息
 *
 * @author guofazhan
 * @version [版本号, 2019/2/27 0027 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@TableName("tab_sys_permission")
public class SysPermission extends BaseEntity<SysPermission> {

	/**
	 * id
	 */
	@TableId(value = "id", type = IdType.UUID)
	private String permissionId;

	/**
	 * 权限类型
	 */
	@TableField("type")
	private String permissionType;

	/**
	 * 值
	 */
	@TableField("permission")
	private String permissionValue;

	/**
	 * 描述信息
	 */
	@TableField("remark")
	private String remark;

	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}

	public String getPermissionValue() {
		return permissionValue;
	}

	public void setPermissionValue(String permissionValue) {
		this.permissionValue = permissionValue;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "SysPermission{" + "permissionId='" + permissionId + '\'' + ", permissionType='" + permissionType + '\''
				+ ", permissionValue='" + permissionValue + '\'' + ", remark='" + remark + '\'' + "} " + super
				.toString();
	}

	@Override
	protected Serializable pkVal() {
		return permissionId;
	}
}
