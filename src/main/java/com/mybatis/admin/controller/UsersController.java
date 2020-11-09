package com.mybatis.admin.controller;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybatis.admin.model.UsersBean;
import com.mybatis.admin.model.service.UsersService;

@RestController
@SuppressWarnings("rawtypes")
public class UsersController {

	private UsersService usersService;
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

	@GetMapping(path = "/api/users")
	public ResponseEntity getUsersList() {
		List<UsersBean> usersList = usersService.getUsersList();

		if (usersList.isEmpty()) {
			logger.info("getUsersListController - {}", "no data exist");
			return getErrorResponse("no data exist");
		}
		return getResponse(usersList);
	}

	@GetMapping(path = "/api/users/{userId}")
	public ResponseEntity getUsers(@PathVariable Integer userId) {
		if (userId == null || org.apache.commons.lang3.StringUtils.isBlank(String.valueOf(userId))) {
			logger.info("getUsersController - {}", "please check your input data");
			return getErrorResponse("please check your input data");
		}

		UsersBean usersBean = usersService.getUsers(userId);

		if (usersBean == null || StringUtils.isEmpty(usersBean)) {
			logger.info("getUsersController - {}", "no data exist");
			return getErrorResponse("no data exist");
		}
		return getResponse(usersBean);
	}
	
	@PostMapping(path = "/api/users")
	public ResponseEntity insertUsers(@RequestBody UsersBean usersBean) {
		if(isUsersValid(usersBean)) {
			usersService.insertUsers(usersBean);
		}else {
			return getErrorResponse("please check your input data");
		}
		return getResponse(Collections.singletonMap("status", "insert success!"));
	}
	
//	@PutMapping(path = "/api/users/{userId}")
//	public ResponseEntity updateUsers(@RequestBody UsersBean usersBean, @PathVariable Integer userId) {
//		if(isUsersValid(usersBean) && userId != null && com.baomidou.mybatisplus.core.toolkit.StringUtils.isBlank(String.valueOf(userId))) {
//			usersService.updateUsers(usersBean, userId);
//		}
//	}

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
