package com.arena.cache.redisson;

import com.arena.cache.AbstractRedisClient;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * 自定义Redisson客户端
 *
 * @author guofazhan
 * @version [版本号, 2019/2/15 0015 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class RedissonRedisClient extends AbstractRedisClient<RedissonClient> {

	/**
	 * 根据配置创建
	 *
	 * @param config
	 */
	public RedissonRedisClient(Config config) {
		this(Redisson.create(config));
	}

	public RedissonRedisClient(RedissonClient client) {
		super(client);
	}

	@Override
	public void close() {
		//TODO redisson no close
	}
}
