package com.arena.sm.mapper;

import com.arena.sm.model.SysDict;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;
import java.util.Map;

/**
 * 字典管理mapper
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface SysDictMapper extends BaseMapper<SysDict> {

	List<SysDict> queryPageList(Page<SysDict> page, Map<String, Object> map);

	List<SysDict> queryList(Map<String, Object> map);

	String maxcode(String id);

	List<String> queryIdForPid(String id);

	List<SysDict> findListByPcode(String pCode);
}
