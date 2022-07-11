package com.tonduong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tonduong.entity.RoleEntity;
import com.tonduong.entity.UserEntity;

@Service
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	//Viết đúng tên theo yêu cầu 
	public UserEntity findOneByUsernameAndStatus(String username, Integer status);
}
