package com.mybatis.admin.model.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatis.admin.exception.AdminException;
import com.mybatis.admin.exception.AdminExceptionEnum;
import com.mybatis.admin.model.UsersBean;
import com.mybatis.admin.model.dao.UsersDao;

@Service
@Transactional
public class UsersService {

	@Autowired
	private UsersDao usersDao;

	public List<UsersBean> getUsersList() {
		return usersDao.getUsersList();
	}

	public UsersBean getUsers(Integer userId) {
		return usersDao.getUsers(userId);
	}

	public boolean isUsersDataExist(UsersBean usersBean) {
		Integer count = usersDao.isUsersDataValid(usersBean.getAccount());
		if (count > 0) {
			return true;
		}
		return false;
	}

	public void insertUsers(UsersBean usersBean) {
		if (!isUsersDataExist(usersBean)) {
			usersBean.setCreatTime(new Timestamp(System.currentTimeMillis()));
			usersDao.insertUsers(usersBean);
		} else {
			throw new AdminException(AdminExceptionEnum.insertError);
		}
	}

	public void updateUsers(UsersBean usersBean, Integer userId) {
		if (isUsersDataExist(usersBean)) {
			usersBean.setUpdateTime(new Timestamp(System.currentTimeMillis()));
			usersDao.updateUsers(usersBean);
		} else {
			throw new AdminException(AdminExceptionEnum.updateError);
		}
	}

	public void deleteUsers(Integer userId) {
		usersDao.deleteUsers(userId);
	}

}
