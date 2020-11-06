package com.mybatis.admin.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatis.admin.model.UsersBean;

@Mapper
public interface UsersDao extends BaseMapper<UsersBean> {

	public List<UsersBean> getUsersList();
	public UsersBean getUsers(Integer userId);
	public Integer isUsersDataValid(String account);
	public void insertUsers(UsersBean usersBean);
	public void updateUsers(UsersBean usersBean);
	public void deleteUsers(Integer userId);
}
