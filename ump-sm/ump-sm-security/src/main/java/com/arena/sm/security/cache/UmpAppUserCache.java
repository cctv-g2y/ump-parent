package com.arena.sm.security.cache;

/**
 * 缓存接口
 *
 * @author guofazhan
 * @version [版本号, 2019/2/15 0015 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface UmpAppUserCache {

	/**
	 * 获取用户信息
	 *
	 * @param username
	 * @return
	 */
	CachedUmpAppUser getUser(String username);

	/**
	 * @param username
	 * @param throwExceptionOnNotFound
	 * @param throwExceptionOnInactive
	 * @param checkValidity
	 * @return
	 */
	CachedUmpAppUser getUser(String username, boolean throwExceptionOnNotFound, boolean throwExceptionOnInactive,
			boolean checkValidity);

	/**
	 * 放入缓存
	 *
	 * @param username
	 * @param cachedUser
	 */
	void putUser(String username, CachedUmpAppUser cachedUser);

	/**
	 * 失效
	 *
	 * @param username
	 */
	void invalidate(String username);

}
