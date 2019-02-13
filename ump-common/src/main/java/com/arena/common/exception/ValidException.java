package com.arena.common.exception;

import com.arena.common.resp.CmmRespCode;

/**
 * 校验异常
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ValidException extends ArenaException {

	public ValidException(String message) {
		super(CmmRespCode.COMM_VALID_ERROR, message);
	}

	public ValidException(String message, Throwable e) {
		super(CmmRespCode.COMM_VALID_ERROR, message, e);
	}

	public ValidException(Throwable e) {
		super(CmmRespCode.COMM_VALID_ERROR, e);
	}
}
