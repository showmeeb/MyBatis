package com.mybatis.admin.exception;

public class AdminException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer errorCode;
	private String errorMessage;
	
	public AdminException(AdminExceptionEnum code) {
		this.errorCode = code.getCode();
		this.errorMessage = code.getMessage();
	}
	
	
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	

}
