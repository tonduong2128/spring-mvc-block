package com.tonduong.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tonduong.model.NewModel;
import com.tonduong.paging.Pageble;


public interface INewService {
	List<NewModel> findAll();
}
