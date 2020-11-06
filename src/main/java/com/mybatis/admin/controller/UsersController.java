package com.mybatis.admin.controller;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import com.mybatis.admin.model.UsersBean;
import com.mybatis.admin.model.service.UsersService;

@RestController
@SuppressWarnings("rawtypes")
public class UsersController {

	private UsersService usersService;
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

	private boolean isUsersValid(UsersBean usersBean) {
		return StringUtils.hasText(usersBean.getAccount()) && StringUtils.hasText(usersBean.getPassword());
	}
	
	private ResponseEntity getResponse(Object body) {
		return new ResponseEntity<>(body, HttpStatus.OK);
	}
	
	private ResponseEntity getErrorResponse(String errorMsg) {
		return new ResponseEntity<>(Collections.singletonMap("errorMsg", errorMsg), HttpStatus.BAD_REQUEST);
	}
}

