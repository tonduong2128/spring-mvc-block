package com.tonduong.dao;

import org.springframework.stereotype.Repository;

import com.tonduong.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
