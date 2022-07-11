package com.tonduong.service;

import org.springframework.stereotype.Service;

import com.tonduong.model.UserModel;

public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}
