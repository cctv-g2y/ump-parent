package com.arena.sm.mapper;

import com.arena.sm.model.SysMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 系统菜单Mapper
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

	List<SysMenu> selectByUserId(String userId);
}
