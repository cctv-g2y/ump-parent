package com.arena.fastdfs;

import com.arena.fastdfs.config.PoolConfig;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.csource.fastdfs.TrackerServer;

/**
 * fastdfs 客戶端TrackerServer池
 *
 * @author guofazhan
 * @version [版本号, 2019/2/18 0018 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TrackerServerPool extends GenericObjectPool<TrackerServer> {

	/**
	 * 配置信息
	 */
	private final PoolConfig poolConfig;

	public TrackerServerPool(PoolConfig poolConfig, PooledObjectFactory<TrackerServer> factory) {
		super(factory);
		this.poolConfig = poolConfig;
		this.setConfig(buildGenericObjectPoolConfig(poolConfig));
	}

	/**
	 * 构建配置信息
	 *
	 * @param poolConfig
	 * @return
	 */
	protected GenericObjectPoolConfig buildGenericObjectPoolConfig(PoolConfig poolConfig) {
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		try {
			config.setJmxNamePrefix(TrackerServerPool.class.getSimpleName());
			config.setJmxEnabled(false);
			config.setMaxTotal(poolConfig.getMaxTotal());
			config.setMaxWaitMillis(poolConfig.getMaxWaitMillis());
			config.setMaxIdle(poolConfig.getMaxIdle());
			config.setMinIdle(poolConfig.getMinIdle());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return config;
	}

	public PoolConfig getPoolConfig() {
		return poolConfig;
	}
}
