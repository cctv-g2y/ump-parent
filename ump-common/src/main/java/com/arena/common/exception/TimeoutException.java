package com.arena.common.exception;

import com.arena.common.resp.CmmRespCode;

/**
 * 超时异常
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class TimeoutException extends ArenaException {

	public TimeoutException(String message) {
		super(CmmRespCode.COMM_TIMEOUT_ERROR, message);
	}

	public TimeoutException(String message, Throwable e) {
		super(CmmRespCode.COMM_TIMEOUT_ERROR, message, e);
	}

	public TimeoutException(Throwable e) {
		super(CmmRespCode.COMM_TIMEOUT_ERROR, e);
	}
}
