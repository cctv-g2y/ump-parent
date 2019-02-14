package com.arena.sm.service;

import com.arena.sm.model.SysDict;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * 字典管理服务
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface ISysDictService extends IService<SysDict> {

	SysDict queryDictById(String id);

	Page<SysDict> queryPageList(Page<SysDict> pageUtil, Map<String, Object> map);

	int saveDict(SysDict sysDict);

	int delDictById(String id);

	List<SysDict> queryList(Map<String, Object> params);

	List<SysDict> queryListByPid(String parentId);

	List<SysDict> findListByPcode(String pCode);

	SysDict findDictByCode(String code);

	String initcode(String id);
}
