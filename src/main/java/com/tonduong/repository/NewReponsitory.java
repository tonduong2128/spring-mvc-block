package com.tonduong.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tonduong.entity.NewEntity;
import com.tonduong.entity.UserEntity;

@Service
public interface NewReponsitory extends JpaRepository<NewEntity, Long>{ //Entity, Kểu dữ liệu khóa chính
	

}
