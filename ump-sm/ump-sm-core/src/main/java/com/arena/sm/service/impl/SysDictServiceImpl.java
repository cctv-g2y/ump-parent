package com.arena.sm.service.impl;

import com.arena.sm.mapper.SysDictMapper;
import com.arena.sm.model.SysDict;
import com.arena.sm.service.ISysDictService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 字典管理服务实现
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService {
	/**
	 * 通过id获取字典
	 */
	@Override
	public SysDict queryDictById(String id) {
		return baseMapper.selectById(id);
	}

	@Override
	public Page<SysDict> queryPageList(Page<SysDict> pageUtil, Map<String, Object> map) {
		return null;
	}

	@Override
	public int saveDict(SysDict sysDict) {
		return 0;
	}

	@Override
	public int delDictById(String id) {
		return 0;
	}

	@Override
	public List<SysDict> queryList(Map<String, Object> params) {
		return null;
	}

	@Override
	public List<SysDict> queryListByPid(String parentId) {
		return null;
	}

	@Override
	public List<SysDict> findListByPcode(String pCode) {
		return null;
	}

	@Override
	public SysDict findDictByCode(String code) {
		return null;
	}

	@Override
	public String initcode(String id) {
		return null;
	}

}
