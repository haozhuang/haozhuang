package com.haoguo.mvc;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Administrator 统一数据传输响应
 */
@Getter
@Setter
public class ResponseWrapper {

	/**
	 * 类型
	 */
	public enum StatusEnum {
		/** 成功 */
		SUCCESS,
		/** 错误 */
		ERROR
	}

	/** 状态 */
	private StatusEnum status;

	/** 响应码 */
	private Integer infoCode;

	/** 响应信息 */
	private String info;

	/** 传输数据 */
	private Object data;

	/**
	 * 无参构造器
	 */
	public ResponseWrapper() {

	}

	/**
	 * @param status
	 *            状态
	 * @param infoCode
	 *            响应码
	 * @param info
	 *            响应信息
	 * @param data
	 *            传输数据
	 */
	public ResponseWrapper(StatusEnum status, Integer infoCode, String info, Object data) {
		this.status = status;
		this.infoCode = infoCode;
		this.info = info;
		this.data = data;
	}

	/**
	 * @author JokerL
	 * @since 2017年3月7日 上午10:20:47
	 * @description 返回成功
	 * @return
	 */
	public static ResponseWrapper success() {
		return new ResponseWrapper(StatusEnum.SUCCESS, null, null, null);
	}

	public static ResponseWrapper success(Integer infoCoder) {
		return new ResponseWrapper(StatusEnum.SUCCESS, infoCoder, null, null);
	}

	public static ResponseWrapper success(String info) {
		return new ResponseWrapper(StatusEnum.SUCCESS, null, info, null);
	}

	public static ResponseWrapper success(Object data) {
		return new ResponseWrapper(StatusEnum.SUCCESS, null, null, data);
	}

	public static ResponseWrapper success(Integer infoCode, String info) {
		return new ResponseWrapper(StatusEnum.SUCCESS, infoCode, info, null);
	}

	public static ResponseWrapper success(Integer infoCoder, String info, Object data) {
		return new ResponseWrapper(StatusEnum.SUCCESS, infoCoder, info, data);
	}

	/**
	 * @author JokerL
	 * @since 2017年3月7日 上午10:24:19
	 * @description 返回失败
	 * @return
	 */
	public static ResponseWrapper error() {
		return new ResponseWrapper(StatusEnum.ERROR, null, null, null);
	}

	public static ResponseWrapper error(Integer infoCode) {
		return new ResponseWrapper(StatusEnum.ERROR, infoCode, null, null);
	}

	public static ResponseWrapper error(String info) {
		return new ResponseWrapper(StatusEnum.ERROR, null, info, null);
	}

	public static ResponseWrapper error(Integer infoCode, String info) {
		return new ResponseWrapper(StatusEnum.ERROR, infoCode, info, null);
	}
}