package com.arena.sm.model;

import com.arena.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * 字典管理实体类
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@TableName("tab_sys_dictionary")
public class SysDict extends BaseEntity<SysDict> {

	/**
	 * 字典id
	 */
	@TableId(value = "id", type = IdType.UUID)
	private String dicId;

	/**
	 * 编码
	 */
	@TableField("code")
	private String code;

	/**
	 * 名称
	 */
	@TableField("name")
	private String name;

	/**
	 * 排序号
	 */
	@TableField("sorting")
	private Integer sorting;

	/**
	 * 父Id
	 */
	@TableField("parent_id")
	private String parentId;

	/**
	 * 参数
	 */
	@TableField("params")
	private String params;

	/**
	 * 值
	 */
	@TableField("value")
	private String value;

	/**
	 * 描述
	 */
	@TableField("remark")
	private String remark;

	/**
	 * 编辑状态
	 */
	@TableField("edit_state")
	private Integer editState;

	/**
	 * ztree属性
	 */
	@TableField(exist = false)
	private boolean isParent;

	public String getDicId() {
		return dicId;
	}

	public void setDicId(String dicId) {
		this.dicId = dicId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSorting() {
		return sorting;
	}

	public void setSorting(Integer sorting) {
		this.sorting = sorting;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getEditState() {
		return editState;
	}

	public void setEditState(Integer editState) {
		this.editState = editState;
	}

	public boolean isParent() {
		return isParent;
	}

	public void setParent(boolean parent) {
		isParent = parent;
	}

	@Override
	public String toString() {
		return "SysDict{" + "dicId='" + dicId + '\'' + ", code='" + code + '\'' + ", name='" + name + '\''
				+ ", sorting=" + sorting + ", parentId='" + parentId + '\'' + ", params='" + params + '\'' + ", value='"
				+ value + '\'' + ", remark='" + remark + '\'' + ", editState=" + editState + ", isParent=" + isParent
				+ "} " + super.toString();
	}

	@Override
	protected Serializable pkVal() {
		return dicId;
	}
}
