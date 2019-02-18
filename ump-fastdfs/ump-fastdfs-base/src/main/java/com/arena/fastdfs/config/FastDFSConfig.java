package com.arena.fastdfs.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * fastDFS配置信息
 *
 * @author guofazhan
 * @version [版本号, 2019/2/18 0018 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@ConfigurationProperties(prefix = "ump.fastdfs")
public class FastDFSConfig {

	/**
	 * 节点地址
	 */
	private List<String> nodeAddresses = new ArrayList();

	/**
	 * 连接超时的时限，单位为毫秒
	 */
	private int connectTimeout = 2000;

	/**
	 * 网络超时的时限，单位为毫秒
	 */
	private int networkTimeout = 2000;

	/**
	 *
	 */
	private boolean antiStealToken = false;

	/**
	 * 字符编码
	 */
	private String charset = "UTF-8";

	/**
	 * 安全KEY
	 */
	private String secretKey;

	public List<String> getNodeAddresses() {
		return nodeAddresses;
	}

	public void setNodeAddresses(List<String> nodeAddresses) {
		this.nodeAddresses = nodeAddresses;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getNetworkTimeout() {
		return networkTimeout;
	}

	public void setNetworkTimeout(int networkTimeout) {
		this.networkTimeout = networkTimeout;
	}

	public boolean isAntiStealToken() {
		return antiStealToken;
	}

	public void setAntiStealToken(boolean antiStealToken) {
		this.antiStealToken = antiStealToken;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	@Override
	public String toString() {
		return "FastDFSConfig{" + "nodeAddresses=" + nodeAddresses + ", connectTimeout=" + connectTimeout
				+ ", networkTimeout=" + networkTimeout + ", antiStealToken=" + antiStealToken + ", charset='" + charset
				+ '\'' + ", secretKey='" + secretKey + '\'' + '}';
	}
}
