package com.mybatis.admin.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdminExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(AdminExceptionHandler.class);
	
	@ExceptionHandler
	public final void handlerException(AdminException adminException) {
		logger.info("handle AdminException...");
		logger.info("error code - {}", adminException.getErrorCode());
		logger.info("error message - {}", adminException.getErrorMessage());
	}
}
