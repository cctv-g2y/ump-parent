package com.arena.fastdfs.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 池配置信息
 *
 * @author guofazhan
 * @version [版本号, 2019/2/18 0018 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@ConfigurationProperties(prefix = "ump.fastdfs.pool")
public class PoolConfig {

	/**
	 * 最大链接数
	 */
	private int maxTotal = 8;
	/**
	 *
	 */
	private int maxIdle = 8;
	/**
	 *
	 */
	private int minIdle = 0;

	/**
	 *
	 */
	private long maxWaitMillis = -1L;

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public long getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(long maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	@Override
	public String toString() {
		return "PoolConfig{" + "maxTotal=" + maxTotal + ", maxIdle=" + maxIdle + ", minIdle=" + minIdle
				+ ", maxWaitMillis=" + maxWaitMillis + '}';
	}
}
