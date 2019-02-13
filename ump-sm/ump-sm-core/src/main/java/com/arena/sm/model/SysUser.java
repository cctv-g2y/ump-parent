package com.arena.sm.model;

import com.arena.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.List;

/**
 * 系统用户实体类
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@TableName("tab_sys_user")
public class SysUser extends BaseEntity<SysUser> {

	/**
	 * 用户id
	 */
	@TableId(value = "id", type = IdType.UUID)
	private String userId;

	/**
	 * 用户名
	 */
	@TableField("username")
	private String username;

	/**
	 * 密码
	 */
	@TableField("password")
	private String password;

	/**
	 * 盐
	 */
	@TableField("salt")
	private String salt;

	/**
	 * 状态 0：禁用 1：正常
	 */
	@TableField("IS_LOCK")
	private String isLock;

	/**
	 * 角色id列表
	 */
	@TableField(exist = false)
	private List<String> roleIdList;

	/**
	 * 性别
	 */
	@TableField("sex")
	private String sex;

	/**
	 * 电话号码
	 */
	@TableField("tel")
	private String tel;

	/**
	 * 部门id
	 */
	@TableField("dept_id")
	private String deptId;

	/**
	 * 部门名称
	 */
	@TableField(exist = false)
	private String deptName;

	/**
	 * 电子邮箱
	 */
	@TableField("email")
	private String email;

	/**
	 * 地址
	 */
	@TableField("address")
	private String address;

	/**
	 * 个人头像
	 */
	@TableField(exist = false)
	private String userPhoto;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getIsLock() {
		return isLock;
	}

	public void setIsLock(String isLock) {
		this.isLock = isLock;
	}

	public List<String> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<String> roleIdList) {
		this.roleIdList = roleIdList;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	@Override
	public String toString() {
		return "SysUser{" + "userId='" + userId + '\'' + ", username='" + username + '\'' + ", password='" + password
				+ '\'' + ", salt='" + salt + '\'' + ", isLock='" + isLock + '\'' + ", roleIdList=" + roleIdList
				+ ", sex='" + sex + '\'' + ", tel='" + tel + '\'' + ", deptId='" + deptId + '\'' + ", deptName='"
				+ deptName + '\'' + ", email='" + email + '\'' + ", address='" + address + '\'' + ", userPhoto='"
				+ userPhoto + '\'' + "} " + super.toString();
	}

	@Override
	protected Serializable pkVal() {
		return userId;
	}
}
