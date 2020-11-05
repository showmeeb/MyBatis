package com.mybatis.admin.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.admin.model.dao.UsersDao;

@Service
@Transactional
public class UsersService {

	@Autowired
	private UsersDao usersDao;
	
	
}
