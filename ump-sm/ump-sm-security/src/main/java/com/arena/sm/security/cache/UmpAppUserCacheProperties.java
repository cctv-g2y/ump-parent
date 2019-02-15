package com.arena.sm.security.cache;

/**
 * @author guofazhan
 * @version [版本号, 2019/2/15 0015 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class UmpAppUserCacheProperties {

	/**
	 * The maximum number of entries that the cache should contain.
	 */
	private long maxSize = 2048L;

	/**
	 * The max age in seconds after which the entry should be invalidated.
	 */
	private long maxAge =  3600L;

	protected long userValidityPeriod = 3600000L;

	public long getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(long maxSize) {
		this.maxSize = maxSize;
	}

	public long getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(long maxAge) {
		this.maxAge = maxAge;
	}

	public long getUserValidityPeriod() {
		return userValidityPeriod;
	}

	public void setUserValidityPeriod(long userValidityPeriod) {
		this.userValidityPeriod = userValidityPeriod;
	}

	@Override
	public String toString() {
		return "UmpAppUserCacheProperties{" + "maxSize=" + maxSize + ", maxAge=" + maxAge + ", userValidityPeriod="
				+ userValidityPeriod + '}';
	}
}
