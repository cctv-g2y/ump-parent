package com.arena.sm.security;

import com.arena.sm.security.cache.CachedUmpAppUser;
import com.arena.sm.security.cache.UmpAppUserCache;
import com.arena.sm.security.cache.UmpAppUserCacheProperties;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.UncheckedExecutionException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 缓存用户信息包装类
 *
 * @author guofazhan
 * @version [版本号, 2019/2/15 0015 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class CacheUmpUserDetailService implements UserDetailsService, UmpAppUserCache {

	/**
	 * 目标服务
	 */
	private final UserDetailsService target;

	private final UmpAppUserCacheProperties cacheProperties;

	/**
	 * 本地缓存信息
	 */

	/**
	 * 本地缓存信息
	 */
	protected LoadingCache<String, CachedUmpAppUser> userCache;

	public CacheUmpUserDetailService(UserDetailsService target, UmpAppUserCacheProperties cacheProperties) {
		this.target = target;
		this.cacheProperties = cacheProperties;
		initCache();
	}

	protected void initCache() {
		long userCacheMaxSize = cacheProperties.getMaxSize();
		long userCacheMaxAge = cacheProperties.getMaxAge();
		userCache = CacheBuilder.newBuilder().maximumSize(userCacheMaxSize)
				.expireAfterAccess(userCacheMaxAge, TimeUnit.SECONDS).recordStats()
				.build(new CacheLoader<String, CachedUmpAppUser>() {
					@Override
					public CachedUmpAppUser load(final String username) throws Exception {
						return new CachedUmpAppUser(target.loadUserByUsername(username));
					}
				});
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CachedUmpAppUser cachedUser = getUser(username);
		if (cachedUser == null) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}

		long lastDatabaseCheck = cachedUser.getLastCheck();
		long currentTime = System.currentTimeMillis();

		if (cacheProperties.getUserValidityPeriod() <= 0L || (currentTime - lastDatabaseCheck >= cacheProperties
				.getUserValidityPeriod())) {
			userCache.invalidate(username);
			cachedUser = getUser(username);
			if (cachedUser == null) {
				throw new UsernameNotFoundException("User " + username + " was not found in the database");
			}
		}
		return cachedUser.getAppUser();
	}

	@Override
	public CachedUmpAppUser getUser(String username) {
		return getUser(username, false, false, true);
	}

	@Override
	public CachedUmpAppUser getUser(String username, boolean throwExceptionOnNotFound, boolean throwExceptionOnInactive,
			boolean checkValidity) {
		try {
			CachedUmpAppUser cachedUser = userCache.get(username);
			return cachedUser;

		} catch (ExecutionException e) {
			return null;
		} catch (UncheckedExecutionException uee) {
			if (uee.getCause() instanceof RuntimeException) {
				RuntimeException runtimeException = (RuntimeException) uee.getCause();
				if (runtimeException instanceof UsernameNotFoundException) {
					if (throwExceptionOnNotFound) {
						throw runtimeException;
					} else {
						return null;
					}
				}
				if (runtimeException instanceof LockedException) {
					if (throwExceptionOnNotFound) {
						throw runtimeException;
					} else {
						return null;
					}
				}

			}
			throw uee;
		}
	}

	@Override
	public void putUser(String username, CachedUmpAppUser cachedUser) {
		userCache.put(username, cachedUser);
	}

	@Override
	public void invalidate(String username) {
		userCache.invalidate(username);
	}
}
