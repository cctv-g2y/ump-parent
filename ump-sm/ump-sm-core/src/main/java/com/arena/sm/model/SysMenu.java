package com.arena.sm.model;

import com.arena.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * 系统菜单实体类
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@TableName("tab_sys_menu")
public class SysMenu extends BaseEntity<SysMenu> {
	/**
	 * id
	 */
	@TableId(value = "id", type = IdType.UUID)
	private String menuId;

	/**
	 * 父级id
	 */
	@TableField("parent_id")
	private String parentId;

	/**
	 * 菜单名称
	 */
	@TableField("menu_name")
	private String menuName;

	/**
	 * 菜单url
	 */
	@TableField("url")
	private String url;

	/**
	 * 菜单对应的权限信息
	 */
	@TableField("permission_id")
	private String permissionId;

	/**
	 * 类型 0：目录 1：菜单 2：按钮
	 */
	@TableField("type")
	private Integer type;

	/**
	 * 菜单图标
	 */
	@TableField("icon")
	private String icon;

	/**
	 * 排序号
	 */
	@TableField("order_num")
	private Integer orderNum;

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	@Override
	public String toString() {
		return "SysMenu{" + "menuId='" + menuId + '\'' + ", parentId='" + parentId + '\'' + ", menuName='" + menuName
				+ '\'' + ", url='" + url + '\'' + ", permissionId='" + permissionId + '\'' + ", type=" + type
				+ ", icon='" + icon + '\'' + ", orderNum=" + orderNum + "} " + super.toString();
	}

	@Override
	protected Serializable pkVal() {
		return menuId;
	}
}
