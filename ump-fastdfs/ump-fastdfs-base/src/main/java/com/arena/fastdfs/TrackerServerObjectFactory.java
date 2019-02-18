package com.arena.fastdfs;

import com.arena.fastdfs.config.FastDFSConfig;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.csource.fastdfs.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * fast dfs 客户端TrackerServer创建工厂
 *
 * @author guofazhan
 * @version [版本号, 2019/2/18 0018 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TrackerServerObjectFactory extends BasePooledObjectFactory<TrackerServer> {

	/**
	 * 配置信息
	 */
	private final FastDFSConfig dfsConfig;

	public TrackerServerObjectFactory(FastDFSConfig dfsConfig) {
		this.dfsConfig = dfsConfig;
		initClientGlobal();
	}

	/**
	 * 检测链接是否可用
	 *
	 * @param p
	 * @return
	 */
	@Override
	public boolean validateObject(PooledObject<TrackerServer> p) {
		TrackerServer trackerServer = p.getObject();
		try {
			if (ProtoCommon.activeTest(trackerServer.getSocket())) {
				return true;
			}
		} catch (IOException e) {
		}
		return false;
	}

	@Override
	public TrackerServer create() throws Exception {
		TrackerServer trackerServer = null;
		TrackerClient client = new TrackerClient();
		try {
			trackerServer = client.getConnection();
			if (ProtoCommon.activeTest(trackerServer.getSocket())) {
				return trackerServer;
			}
		} catch (Exception e) {
		}
		return trackerServer;
	}

	@Override
	public PooledObject<TrackerServer> wrap(TrackerServer trackerServer) {
		return new DefaultPooledObject(trackerServer);
	}

	/**
	 * 初始化fastdfs配置信息
	 */
	protected void initClientGlobal() {
		List<InetSocketAddress> trackerServers = new ArrayList<>(dfsConfig.getNodeAddresses().size());
		String spr2 = ":";

		for (String addr : dfsConfig.getNodeAddresses()) {
			String[] arr2 = addr.trim().split(spr2);
			String host = arr2[0].trim();
			int port = Integer.parseInt(arr2[1].trim());
			trackerServers.add(new InetSocketAddress(host, port));
		}
		ClientGlobal.setG_tracker_group(new TrackerGroup(trackerServers.toArray(new InetSocketAddress[0])));
		// 连接超时的时限，单位为毫秒
		ClientGlobal.setG_connect_timeout(dfsConfig.getConnectTimeout());
		// 网络超时的时限，单位为毫秒
		ClientGlobal.setG_network_timeout(dfsConfig.getNetworkTimeout());
		ClientGlobal.setG_anti_steal_token(dfsConfig.isAntiStealToken());
		// 字符集
		ClientGlobal.setG_charset(dfsConfig.getCharset());
		ClientGlobal.setG_secret_key(dfsConfig.getSecretKey());
		System.out.println("init fastdfs client global setting !");
	}

	public FastDFSConfig getDfsConfig() {
		return dfsConfig;
	}
}
