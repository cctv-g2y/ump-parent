package com.arena.sm.service.impl;

import com.arena.sm.mapper.SysUserMapper;
import com.arena.sm.model.SysUser;
import com.arena.sm.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户查询服务实现
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
	@Override
	public SysUser selectUserByUsername(String username) {
		SysUser param = new SysUser();
		param.setUsername(username);
		return baseMapper.selectOne(param);
	}
}
