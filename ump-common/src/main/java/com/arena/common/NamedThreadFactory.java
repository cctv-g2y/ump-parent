package com.arena.common;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 命名线程工厂
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class NamedThreadFactory implements ThreadFactory {

	/**
	 * 线程池的序列号
	 */
	private static final AtomicInteger POOL_SEQ = new AtomicInteger(1);

	/**
	 * 线程序列号
	 */
	private final AtomicInteger mThreadNum = new AtomicInteger(1);

	/**
	 * 线程前缀
	 */
	private final String mPrefix;

	/**
	 * 守护标识
	 */
	private final boolean mDaemo;

	/**
	 * 线程组
	 */
	private final ThreadGroup mGroup;

	/**
	 *
	 */
	public NamedThreadFactory() {
		this("pool-" + POOL_SEQ.getAndIncrement(), false);
	}

	/**
	 * @param prefix
	 */
	public NamedThreadFactory(String prefix) {
		this(prefix, false);
	}

	/**
	 * @param prefix
	 * @param daemo
	 */
	public NamedThreadFactory(String prefix, boolean daemo) {
		mPrefix = prefix + "-thread-";
		mDaemo = daemo;
		SecurityManager s = System.getSecurityManager();
		mGroup = (s == null) ? Thread.currentThread().getThreadGroup() : s.getThreadGroup();
	}

	@Override
	public Thread newThread(Runnable runnable) {
		return newThread(mPrefix, mDaemo, runnable);
	}

	public ThreadGroup getThreadGroup() {
		return mGroup;
	}

	/**
	 * @return
	 */
	public static NamedThreadFactory build() {
		return new NamedThreadFactory();
	}

	/**
	 * @param prefix
	 * @return
	 */
	public static NamedThreadFactory build(String prefix) {
		return new NamedThreadFactory(prefix);
	}

	/**
	 * @param prefix
	 * @param daemo
	 * @return
	 */
	public static NamedThreadFactory build(String prefix, boolean daemo) {
		return new NamedThreadFactory(prefix, daemo);
	}

	/**
	 * @param name
	 * @param daemo
	 * @param r
	 * @return
	 */
	private Thread newThread(String name, boolean daemo, Runnable r) {
		name = name + mThreadNum.getAndIncrement();
		Thread ret = new Thread(mGroup, r, name, 0);
		ret.setDaemon(daemo);
		return ret;
	}
}
