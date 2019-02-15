package com.arena.cache;

import com.arena.cache.commands.Commands;

/**
 * redis 操作客户端
 *
 * @author guofazhan
 * @version [版本号, 2019/2/12 0012 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface RedisClient<T> {

	/**
	 * @return
	 */
	<M extends Commands> M getCommands();

	/**
	 * 获取实现客户端
	 *
	 * @return
	 */
	T getRealClient();

	/**
	 * 关闭接口
	 */
	void close();
}
