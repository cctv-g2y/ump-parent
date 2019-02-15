package com.arena.sm.security.cache;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * 缓存 user
 *
 * @author guofazhan
 * @version [版本号, 2019/2/15 0015 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class CachedUmpAppUser {

	/**
	 *
	 */
	private final UserDetails appUser;

	/**
	 * 检测时间
	 */
	private final long lastCheck;

	public CachedUmpAppUser(UserDetails appUser) {
		this.appUser = appUser;
		this.lastCheck = System.currentTimeMillis();

	}

	public UserDetails getAppUser() {
		return appUser;
	}

	public long getLastCheck() {
		return lastCheck;
	}

	@Override
	public String toString() {
		return "CachedUmpAppUser{" + "appUser=" + appUser + ", lastCheck=" + lastCheck + '}';
	}
}
