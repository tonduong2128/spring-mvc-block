package com.tonduong.service.impl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonduong.entity.NewEntity;
import com.tonduong.model.NewModel;
import com.tonduong.repository.NewReponsitory;
import com.tonduong.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private NewReponsitory newReponsitory;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<NewModel> findAll() {
		List<NewEntity> newEntities = newReponsitory.findAll();

		Type listType = new TypeToken<List<NewModel>>() {
		}.getType();
		List<NewModel> newModels = modelMapper.map(newEntities, listType);

		return newModels;
	}
}
