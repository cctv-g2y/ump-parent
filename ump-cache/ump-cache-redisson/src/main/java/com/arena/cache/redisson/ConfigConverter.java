package com.arena.cache.redisson;

import org.redisson.config.Config;

/**
 * @author guofazhan
 * @version [版本号, 2019/2/15 0015 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface ConfigConverter {

	/**
	 * 将自定义的配置转换为redisson配置
	 *
	 * @param customConfig
	 * @return
	 */
	Config converter(CustomConfig customConfig);
}
