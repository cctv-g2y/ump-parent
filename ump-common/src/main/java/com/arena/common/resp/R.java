package com.arena.common.resp;

import java.io.Serializable;

/**
 * 基础响应消息
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public final class R<T> implements Serializable {

	/**
	 * 返回码
	 */
	private String retCode;

	/**
	 * 返回描述
	 */
	private String retDesc;

	/**
	 * 返回数据
	 */
	private T rspBody;

	public String getRetCode() {
		return retCode;
	}

	public R<T> setRetCode(String retCode) {
		this.retCode = retCode;
		return this;
	}

	public String getRetDesc() {
		return retDesc;
	}

	public R<T> setRetDesc(String retDesc) {
		this.retDesc = retDesc;
		return this;
	}

	public T getRspBody() {
		return rspBody;
	}

	public R<T> setRspBody(T rspBody) {
		this.rspBody = rspBody;
		return this;
	}

	@Override
	public String toString() {
		return "R{" + "retCode='" + retCode + '\'' + ", retDesc='" + retDesc + '\'' + ", rspBody=" + rspBody + '}';
	}
}
