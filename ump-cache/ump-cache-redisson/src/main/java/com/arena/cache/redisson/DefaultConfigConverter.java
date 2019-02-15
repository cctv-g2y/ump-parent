package com.arena.cache.redisson;

import com.arena.cache.redisson.config.*;
import org.redisson.client.codec.Codec;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.*;

/**
 * 默认配置转换器
 *
 * @author guofazhan
 * @version [版本号, 2019/2/15 0015 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DefaultConfigConverter implements ConfigConverter {

	@Override
	public Config converter(CustomConfig customConfig) {

		if (customConfig instanceof ClusterProperties) {
			return converterByCluster((ClusterProperties) customConfig);
		}

		if (customConfig instanceof SentinelProperties) {
			return converterBySentinel((SentinelProperties) customConfig);
		}

		if (customConfig instanceof SingleProperties) {
			return converterBySingle((SingleProperties) customConfig);
		}

		return null;
	}

	/**
	 * 转换cluster配置
	 *
	 * @param singleProperties
	 * @return
	 */
	Config converterBySingle(SingleProperties singleProperties) {
		Config config = new Config();
		config = buildTransportConfig(config, singleProperties);
		//设置cluster配置信
		SingleServerConfig singleServerConfig = config.useSingleServer();
		singleServerConfig.setClientName(singleProperties.getClientName())
				.setConnectTimeout(singleProperties.getConnectTimeout())
				.setIdleConnectionTimeout(singleProperties.getIdleConnectionTimeout())
				.setClientName(singleProperties.getClientName()).setFailedAttempts(singleProperties.getFailedAttempts())
				.setPassword(singleProperties.getPassword())
				.setReconnectionTimeout(singleProperties.getReconnectionTimeout())
				.setRetryInterval(singleProperties.getRetryInterval()).setTimeout(singleProperties.getTimeout())
				.setRetryAttempts(singleProperties.getRetryAttempts());
		singleServerConfig.setAddress(singleProperties.getAddress())
				.setConnectionMinimumIdleSize(singleProperties.getConnectionMinimumIdleSize())
				.setDatabase(singleProperties.getDatabase());
		return config;
	}

	/**
	 * 转换cluster配置
	 *
	 * @param clusterProperties
	 * @return
	 */
	Config converterByCluster(ClusterProperties clusterProperties) {
		Config config = new Config();
		config = buildTransportConfig(config, clusterProperties);
		//设置cluster配置信息
		ClusterServersConfig clusterServersConfig = config.useClusterServers();
		buildBaseConfig(clusterServersConfig, clusterProperties);
		buildBaseMasterSlave(clusterServersConfig, clusterProperties);
		//设置集群地址
		clusterServersConfig.addNodeAddress(clusterProperties.getNodeAddresses().toArray(new String[0]))
				.setScanInterval(clusterProperties.getScanInterval());
		return config;
	}

	/**
	 * 转换sentinel配置
	 *
	 * @param sentinelProperties
	 * @return
	 */
	Config converterBySentinel(SentinelProperties sentinelProperties) {
		Config config = new Config();
		config = buildTransportConfig(config, sentinelProperties);
		//设置Sentinel配置
		SentinelServersConfig sentinelServersConfig = config.useSentinelServers();
		buildBaseConfig(sentinelServersConfig, sentinelProperties);
		buildBaseMasterSlave(sentinelServersConfig, sentinelProperties);
		//设置哨兵地址
		sentinelServersConfig.addSentinelAddress(sentinelProperties.getNodeAddresses().toArray(new String[0]))
				.setMasterName(sentinelProperties.getMasterName()).setDatabase(sentinelProperties.getDatabase());
		return config;
	}

	/**
	 * 构建主从配置信息
	 *
	 * @param config
	 * @param options
	 * @param <T>
	 */
	private <T extends BaseMasterSlaveServersConfig> void buildBaseMasterSlave(T config, BaseMasterSlave options) {
		config.setSlaveConnectionMinimumIdleSize(options.getSlaveConnectionMinimumIdleSize());
		config.setSlaveConnectionPoolSize(options.getSlaveConnectionPoolSize());
		config.setMasterConnectionMinimumIdleSize(options.getMasterConnectionMinimumIdleSize());
		config.setMasterConnectionPoolSize(options.getMasterConnectionPoolSize());
		config.setSubscriptionConnectionPoolSize(options.getSubscriptionConnectionPoolSize());
		config.setSubscriptionConnectionMinimumIdleSize(options.getSubscriptionConnectionMinimumIdleSize());
		config.setReadMode(buildReadMode(options.getReadMode()));
		config.setSubscriptionMode(buildSubscriptionMode(options.getSubscriptionMode()));
		config.setDnsMonitoringInterval(options.getDnsMonitoringInterval());
	}

	/**
	 * 构建订阅模式枚举
	 *
	 * @param subscriptionMode
	 * @return
	 */
	private SubscriptionMode buildSubscriptionMode(String subscriptionMode) {
		if (null != subscriptionMode && !"".equals(subscriptionMode.trim())) {
			for (SubscriptionMode mode : SubscriptionMode.values()) {
				if (mode.name().equalsIgnoreCase(subscriptionMode)) {
					return mode;
				}
			}
		}
		return null;
	}

	/**
	 * 构建读模式枚举
	 *
	 * @param readMode
	 * @return
	 */
	private ReadMode buildReadMode(String readMode) {
		if (null != readMode && !"".equals(readMode.trim())) {
			for (ReadMode mode : ReadMode.values()) {
				if (mode.name().equalsIgnoreCase(readMode)) {
					return mode;
				}
			}
		}
		return null;
	}

	/**
	 * 构建基础配置
	 *
	 * @param config
	 * @param options
	 * @param <T>
	 */
	private <T extends BaseMasterSlaveServersConfig> void buildBaseConfig(T config, BaseOptions options) {
		config.setClientName(options.getClientName());
		config.setConnectTimeout(options.getConnectTimeout());
		config.setIdleConnectionTimeout(options.getIdleConnectionTimeout());
		config.setClientName(options.getClientName());
		config.setFailedAttempts(options.getFailedAttempts());
		config.setPassword(options.getPassword());
		config.setReconnectionTimeout(options.getReconnectionTimeout());
		config.setRetryInterval(options.getRetryInterval());
		config.setTimeout(options.getTimeout());
		config.setRetryAttempts(options.getRetryAttempts());
	}

	/**
	 * 构建通讯配置信息
	 *
	 * @param config
	 * @param transport
	 * @return
	 */
	private Config buildTransportConfig(Config config, Transport transport) {
		if (config == null) {
			config = new Config();
		}
		config.setReferenceEnabled(transport.isReferenceEnabled());
		//构建基础信息
		config = config.setCodec(buildCodec(transport)).setNettyThreads(transport.getNettyThreads())
				.setThreads(transport.getThreads()).setUseLinuxNativeEpoll(transport.isUseLinuxNativeEpoll())
				.setLockWatchdogTimeout(transport.getLockWatchdogTimeout());
		return config;
	}

	private Codec buildCodec(Transport transport) {
		return new StringCodec();
	}
}
