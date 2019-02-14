package com.arena.sm.service;

import com.arena.sm.model.SysUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface ISysUserService extends IService<SysUser> {

	/**
	 * 根据用户名查询用户
	 *
	 * @param username
	 * @return
	 */
	SysUser selectUserByUsername(String username);
}
