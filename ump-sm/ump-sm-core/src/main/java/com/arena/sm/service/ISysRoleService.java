package com.arena.sm.service;

import com.arena.sm.model.SysRole;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface ISysRoleService extends IService<SysRole> {

	/**
	 * 根据用户ID查询角色列表
	 *
	 * @param userId
	 * @return
	 */
	List<SysRole> selectByUserId(String userId);
}
