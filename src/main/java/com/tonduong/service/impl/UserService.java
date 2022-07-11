package com.tonduong.service.impl;

import com.tonduong.dao.IUserDAO;
import com.tonduong.model.UserModel;
import com.tonduong.service.IUserService;

public class UserService implements IUserService {

	private IUserDAO iUserDAO;

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return iUserDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}
	
}
