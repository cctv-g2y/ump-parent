package com.arena.sm.model;

import com.arena.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.List;

/**
 * 系统部门实体类
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@TableName("tab_sys_dept")
public class SysDept extends BaseEntity<SysDept> {

	/**
	 * id
	 */
	@TableId(value = "id", type = IdType.UUID)
	private String deptId;

	/**
	 * 上级部门id
	 */
	@TableField("parent_id")
	private String parentId;

	/**
	 * 部门名称
	 */
	@TableField("dept_name")
	private String deptName;

	/**
	 * 排序号
	 */
	@TableField("order_num")
	private Integer orderNum;

	/**
	 * 上级部门名称
	 */
	@TableField(exist = false)
	private String parentName;

	/**
	 * ztree属性
	 */
	@TableField(exist = false)
	private Boolean open;

	/**
	 * ztree属性
	 */
	@TableField(exist = false)
	private Boolean isParent = true;

	/**
	 * ztree集合
	 */
	@TableField(exist = false)
	private List<?> list;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public Boolean getParent() {
		return isParent;
	}

	public void setParent(Boolean parent) {
		isParent = parent;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "SysDept{" + "deptId='" + deptId + '\'' + ", parentId='" + parentId + '\'' + ", deptName='" + deptName
				+ '\'' + ", orderNum=" + orderNum + ", parentName='" + parentName + '\'' + ", open=" + open
				+ ", isParent=" + isParent + ", list=" + list + "} " + super.toString();
	}

	@Override
	protected Serializable pkVal() {
		return deptId;
	}
}
