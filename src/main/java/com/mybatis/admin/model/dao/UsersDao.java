package com.mybatis.admin.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatis.admin.model.UsersBean;

@Mapper
public interface UsersDao extends BaseMapper<UsersBean> {

	public UsersBean getUsersList();
	public UsersBean getUsers(Integer userId);
	public void insertUsers(UsersBean usersBean);
	public void updateUsers(UsersBean usersBean);
	public void deleteUsers(Integer userId);
}
