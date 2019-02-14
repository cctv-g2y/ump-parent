/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : ump_dev

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-02-14 12:45:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tab_sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `tab_sys_dept`;
CREATE TABLE `tab_sys_dept` (
  `id` varchar(64) NOT NULL COMMENT 'id',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '上级部门id',
  `dept_name` varchar(64) DEFAULT NULL COMMENT '部门名称',
  `order_num` int(10) DEFAULT NULL COMMENT '排序号',
  `IS_DEL` int(10) unsigned DEFAULT '0' COMMENT '删除状态，0：未删除；1：已删除',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人id',
  `CREATE_TIME` varchar(14) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFY_BY` varchar(64) DEFAULT NULL COMMENT '修改人id',
  `LAST_MODIFY_TIME` varchar(14) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tab_sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `tab_sys_dictionary`;
CREATE TABLE `tab_sys_dictionary` (
  `id` varchar(64) NOT NULL COMMENT 'id',
  `code` varchar(64) DEFAULT NULL COMMENT '编码',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `sorting` int(64) DEFAULT NULL COMMENT '排序号',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父Id',
  `params` varchar(500) DEFAULT NULL COMMENT '参数',
  `value` varchar(500) DEFAULT NULL COMMENT '值',
  `remark` varchar(500) DEFAULT NULL COMMENT '描述',
  `edit_state` int(10) DEFAULT NULL COMMENT '编辑状态',
  `IS_DEL` int(10) unsigned DEFAULT '0' COMMENT '删除状态，0：未删除；1：已删除',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人id',
  `CREATE_TIME` varchar(14) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFY_BY` varchar(64) DEFAULT NULL COMMENT '修改人id',
  `LAST_MODIFY_TIME` varchar(14) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tab_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `tab_sys_menu`;
CREATE TABLE `tab_sys_menu` (
  `id` varchar(64) NOT NULL COMMENT 'id',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父级id',
  `menu_name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(255) DEFAULT NULL COMMENT '菜单url',
  `perms` varchar(255) DEFAULT NULL COMMENT '授权标识',
  `type` int(1) DEFAULT NULL COMMENT '菜单类型0.目录--1.菜单--2.按钮',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(3) DEFAULT NULL COMMENT '排序号',
  `IS_DEL` int(10) unsigned DEFAULT '0' COMMENT '删除状态，0：未删除；1：已删除',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人id',
  `CREATE_TIME` varchar(14) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFY_BY` varchar(64) DEFAULT NULL COMMENT '修改人id',
  `LAST_MODIFY_TIME` varchar(14) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tab_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `tab_sys_role`;
CREATE TABLE `tab_sys_role` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `role_name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `mark` varchar(2000) DEFAULT NULL COMMENT '角色备注',
  `IS_DEL` int(10) unsigned DEFAULT '0' COMMENT '删除状态，0：未删除；1：已删除',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人id',
  `CREATE_TIME` varchar(14) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFY_BY` varchar(64) DEFAULT NULL COMMENT '修改人id',
  `LAST_MODIFY_TIME` varchar(14) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tab_sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `tab_sys_role_menu`;
CREATE TABLE `tab_sys_role_menu` (
  `id` varchar(64) NOT NULL COMMENT 'id',
  `role_id` varchar(64) DEFAULT NULL COMMENT '角色id',
  `menu_id` varchar(64) DEFAULT NULL COMMENT '菜单id',
  `IS_DEL` int(10) unsigned DEFAULT '0' COMMENT '删除状态，0：未删除；1：已删除',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人id',
  `CREATE_TIME` varchar(14) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFY_BY` varchar(64) DEFAULT NULL COMMENT '修改人id',
  `LAST_MODIFY_TIME` varchar(14) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tab_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `tab_sys_user`;
CREATE TABLE `tab_sys_user` (
  `id` varchar(64) NOT NULL COMMENT '用户id',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `tel` varchar(255) DEFAULT NULL COMMENT '电话',
  `dept_id` varchar(64) DEFAULT NULL COMMENT '部门id',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `salt` varchar(255) DEFAULT NULL COMMENT '加密盐',
  `IS_LOCK` varchar(10) DEFAULT '1' COMMENT '状态标记0.禁用--1.正常',
  `IS_DEL` int(10) unsigned DEFAULT '0' COMMENT '删除状态，0：未删除；1：已删除',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人id',
  `CREATE_TIME` varchar(14) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFY_BY` varchar(64) DEFAULT NULL COMMENT '修改人id',
  `LAST_MODIFY_TIME` varchar(14) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tab_sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tab_sys_user_role`;
CREATE TABLE `tab_sys_user_role` (
  `id` varchar(64) NOT NULL COMMENT 'id',
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户id',
  `role_id` varchar(64) DEFAULT NULL COMMENT '角色id',
  `IS_DEL` int(10) unsigned DEFAULT '0' COMMENT '删除状态，0：未删除；1：已删除',
  `CREATE_BY` varchar(64) DEFAULT NULL COMMENT '创建人id',
  `CREATE_TIME` varchar(14) DEFAULT NULL COMMENT '创建时间',
  `LAST_MODIFY_BY` varchar(64) DEFAULT NULL COMMENT '修改人id',
  `LAST_MODIFY_TIME` varchar(14) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
