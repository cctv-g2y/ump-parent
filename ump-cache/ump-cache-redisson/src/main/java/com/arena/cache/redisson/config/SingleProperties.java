package com.arena.cache.redisson.config;

import com.arena.cache.redisson.CustomConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author guofazhan
 * @version [版本号, 2019/2/15 0015 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@ConfigurationProperties(prefix = "ump.cache.redisson.single")
public class SingleProperties extends BaseOptions implements CustomConfig {

	/**
	 * 地址
	 */
	private String address;
	/**
	 *
	 */
	private int subscriptionConnectionMinimumIdleSize = 1;
	/**
	 *
	 */
	private int subscriptionConnectionPoolSize = 50;
	/**
	 *
	 */
	private int connectionMinimumIdleSize = 10;
	/**
	 *
	 */
	private int connectionPoolSize = 64;
	/**
	 *
	 */
	private int database = 0;
	/**
	 *
	 */
	private boolean dnsMonitoring = true;
	/**
	 *
	 */
	private long dnsMonitoringInterval = 5000L;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSubscriptionConnectionMinimumIdleSize() {
		return subscriptionConnectionMinimumIdleSize;
	}

	public void setSubscriptionConnectionMinimumIdleSize(int subscriptionConnectionMinimumIdleSize) {
		this.subscriptionConnectionMinimumIdleSize = subscriptionConnectionMinimumIdleSize;
	}

	public int getSubscriptionConnectionPoolSize() {
		return subscriptionConnectionPoolSize;
	}

	public void setSubscriptionConnectionPoolSize(int subscriptionConnectionPoolSize) {
		this.subscriptionConnectionPoolSize = subscriptionConnectionPoolSize;
	}

	public int getConnectionMinimumIdleSize() {
		return connectionMinimumIdleSize;
	}

	public void setConnectionMinimumIdleSize(int connectionMinimumIdleSize) {
		this.connectionMinimumIdleSize = connectionMinimumIdleSize;
	}

	public int getConnectionPoolSize() {
		return connectionPoolSize;
	}

	public void setConnectionPoolSize(int connectionPoolSize) {
		this.connectionPoolSize = connectionPoolSize;
	}

	public int getDatabase() {
		return database;
	}

	public void setDatabase(int database) {
		this.database = database;
	}

	public boolean isDnsMonitoring() {
		return dnsMonitoring;
	}

	public void setDnsMonitoring(boolean dnsMonitoring) {
		this.dnsMonitoring = dnsMonitoring;
	}

	public long getDnsMonitoringInterval() {
		return dnsMonitoringInterval;
	}

	public void setDnsMonitoringInterval(long dnsMonitoringInterval) {
		this.dnsMonitoringInterval = dnsMonitoringInterval;
	}

	@Override
	public String toString() {
		return "SingleProperties{" + "address='" + address + '\'' + ", subscriptionConnectionMinimumIdleSize="
				+ subscriptionConnectionMinimumIdleSize + ", subscriptionConnectionPoolSize="
				+ subscriptionConnectionPoolSize + ", connectionMinimumIdleSize=" + connectionMinimumIdleSize
				+ ", connectionPoolSize=" + connectionPoolSize + ", database=" + database + ", dnsMonitoring="
				+ dnsMonitoring + ", dnsMonitoringInterval=" + dnsMonitoringInterval + "} " + super.toString();
	}
}
