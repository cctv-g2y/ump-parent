package com.arena.common.resp;

/**
 * 公共响应返回码
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class CmmRespCode implements ResultCode {

	/**
	 * 成功
	 */
	public static final ResultCode SUCCESS = new CmmRespCode("000000", "success");

	/**
	 * 异常
	 */
	public static final ResultCode COMM_ERROR = new CmmRespCode("000001", "系统繁忙，请稍后再试！");

	/**
	 * 网络异常
	 */
	public static final ResultCode COMM_NET_ERROR = new CmmRespCode("000002", "当前网络不可用，请检查网络设置！");

	/**
	 * 校验失败
	 */
	public static final ResultCode COMM_VALID_ERROR = new CmmRespCode("000003", "校验失败");

	/**
	 * FALLBACK
	 */
	public static final ResultCode COMM_FALLBACK = new CmmRespCode("000004", "流量过载，请稍后再试！");

	/**
	 * timeout
	 */
	public static final ResultCode COMM_TIMEOUT_ERROR = new CmmRespCode("000005", "系统繁忙，请稍后再试");

	/**
	 * 返回编码
	 */
	private final String code;

	/**
	 * 返回端描述
	 */
	private final String desc;

	/**
	 * 返回码
	 *
	 * @param code
	 * @param desc
	 */
	protected CmmRespCode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getDesc() {
		return desc;
	}
}
