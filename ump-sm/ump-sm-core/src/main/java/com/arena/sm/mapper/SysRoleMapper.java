package com.arena.sm.mapper;

import com.arena.sm.model.SysRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * 角色管理mapper
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

	List<SysRole> selectByUserId(String userId);
}
