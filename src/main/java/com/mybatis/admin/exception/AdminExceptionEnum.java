package com.mybatis.admin.exception;

public enum AdminExceptionEnum {

	insertError(1000, "insert error!"), updateError(1001, "update error!");

	private final Integer code;
	private final String message;

	private AdminExceptionEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
