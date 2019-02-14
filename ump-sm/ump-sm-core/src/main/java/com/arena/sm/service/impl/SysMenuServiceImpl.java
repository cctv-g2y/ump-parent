package com.arena.sm.service.impl;

import com.arena.sm.mapper.SysMenuMapper;
import com.arena.sm.model.SysMenu;
import com.arena.sm.service.ISysMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
	@Override
	public List<SysMenu> selectByUserId(String userId) {
		return baseMapper.selectByUserId(userId);
	}
}
