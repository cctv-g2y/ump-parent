package com.arena.common.resp;


/**
 * 返回码接口
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface ResultCode {

	/**
	 * 构建响应消息
	 *
	 * @return
	 */
	default R<?> buildRespCode() {
		return new R<>().setRetCode(getCode()).setRetDesc(getDesc());
	}

	/**
	 * 返回编码
	 *
	 * @return
	 */
	String getCode();

	/**
	 * 返回描述
	 *
	 * @return
	 */
	String getDesc();
}
