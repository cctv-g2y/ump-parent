package com.arena.fastdfs;

import org.csource.fastdfs.*;

/**
 * fastdfs 客户端
 *
 * @author guofazhan
 * @version [版本号, 2019/2/18 0018 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public final class FastDFSClient {

	/**
	 * TrackerServerPool
	 */
	private final TrackerServerPool pool;

	public FastDFSClient(TrackerServerPool pool) {
		this.pool = pool;
	}

	/**
	 * 上传文件
	 *
	 * @param fileBuff
	 * @param fileExtName
	 * @return
	 * @throws Exception
	 */
	private String send(byte[] fileBuff, String fileExtName) throws Exception {
		String upPath = null;
		TrackerServer trackerServer = null;
		StorageServer storageServer = null;
		try {
			//从对象池获取trackerServewr对象
			trackerServer = this.pool.borrowObject();
			// 获取客户端对象
			StorageClient1 client1 = new StorageClient1(trackerServer, storageServer);
			upPath = client1.upload_file1(fileBuff, fileExtName, null);

		} catch (Exception e) {// 捕获上传文件异常

		} finally {
			if (null != storageServer && ProtoCommon.activeTest(storageServer.getSocket())) {
				storageServer.close();
			}
			if (null != trackerServer && ProtoCommon.activeTest(trackerServer.getSocket())) {
				trackerServer.close();
			}
			this.pool.returnObject(trackerServer);
		}

		return upPath;
	}

	/**
	 * 下载文件
	 *
	 * @param fileId
	 * @return
	 * @throws Exception
	 */
	public byte[] downloadFile(String fileId) throws Exception {
		byte[] fileBuff = null;
		TrackerServer trackerServer = null;
		StorageServer storageServer = null;

		try {

			trackerServer = this.pool.borrowObject();

			StorageClient1 client1 = new StorageClient1(trackerServer, storageServer);
			// 下载文件
			fileBuff = client1.download_file1(fileId);
		} catch (Exception e) {

		} finally {
			if (null != storageServer && ProtoCommon.activeTest(storageServer.getSocket())) {
				storageServer.close();
			}
			if (null != trackerServer && ProtoCommon.activeTest(trackerServer.getSocket())) {
				trackerServer.close();
			}
			this.pool.returnObject(trackerServer);
		}
		return fileBuff;
	}

	/**
	 * 删除文件
	 *
	 * @param fileId
	 * @return
	 * @throws Exception
	 */
	public int deleteFile(String fileId) throws Exception {
		int result = 0;
		TrackerServer trackerServer = null;
		StorageServer storageServer = null;
		try {
			trackerServer = this.pool.borrowObject();
			StorageClient1 client1 = new StorageClient1(trackerServer, storageServer);
			result = client1.delete_file1(fileId);// 删除文件
		} catch (Exception e) {

		} finally {
			if (null != storageServer && ProtoCommon.activeTest(storageServer.getSocket())) {
				storageServer.close();
			}
			if (null != trackerServer && ProtoCommon.activeTest(trackerServer.getSocket())) {
				trackerServer.close();
			}
			this.pool.returnObject(trackerServer);
		}
		return result;

	}

	/**
	 * 判断文件是否存在
	 *
	 * @param fileId
	 * @return
	 * @throws Exception
	 */
	public int queryFileInfo(String fileId) throws Exception {
		int result = 1;

		TrackerServer trackerServer = null;
		StorageServer storageServer = null;
		try {

			trackerServer = this.pool.borrowObject();

			StorageClient1 client1 = new StorageClient1(trackerServer, storageServer);
			FileInfo fileInfo = client1.query_file_info1(fileId);// 删除文件
			if (null != fileInfo) {
				result = 0;
			}
		} catch (Exception e) {

		} finally {

			if (null != storageServer && ProtoCommon.activeTest(storageServer.getSocket())) {
				storageServer.close();
			}
			if (null != trackerServer && ProtoCommon.activeTest(trackerServer.getSocket())) {
				trackerServer.close();
			}
			this.pool.returnObject(trackerServer);
		}
		return result;
	}
}
