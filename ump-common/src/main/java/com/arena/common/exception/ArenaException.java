package com.arena.common.exception;

import com.arena.common.resp.CmmRespCode;
import com.arena.common.resp.ResultCode;

/**
 * 基础异常类
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ArenaException extends RuntimeException {

	/**
	 * 返回码
	 */
	private ResultCode resultCode;

	public ArenaException(String message) {
		this(CmmRespCode.COMM_ERROR, message);
	}

	public ArenaException(Throwable e) {
		this(CmmRespCode.COMM_ERROR, e);
	}

	public ArenaException(String message, Throwable e) {
		this(CmmRespCode.COMM_ERROR, message, e);
	}

	public ArenaException(ResultCode resultCode) {
		this(CmmRespCode.COMM_ERROR, "code:" + resultCode.getCode() + ",desc:" + resultCode.getDesc());
	}

	public ArenaException(ResultCode resultCode, String message) {
		super(message);
		this.resultCode = resultCode;
	}

	public ArenaException(ResultCode resultCode, Throwable e) {
		this(CmmRespCode.COMM_ERROR, "code:" + resultCode.getCode() + ",desc:" + resultCode.getDesc(), e);
	}

	public ArenaException(ResultCode resultCode, String message, Throwable e) {
		super(message, e);
		this.resultCode = resultCode;
	}

	public ResultCode getResultCode() {
		return resultCode;
	}

	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}

	public boolean hasResultCode() {
		return null != resultCode;
	}

	@Override
	public String toString() {
		return "ArenaException{" + "resultCode=" + resultCode + "} " + super.toString();
	}
}
