package com.tonduong.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tonduong.model.NewModel;
import com.tonduong.paging.Pageble;


public interface INewDAO extends GenericDAO<NewModel> {
	NewModel findOne(Long id);

	List<NewModel> findByCategoryId(Long categoryId);

	Long save(NewModel newModel);

	void update(NewModel updateNew);

	void delete(long id);

	List<NewModel> findAll(Pageble pageble);

	List<NewModel> findAll();

	int getTotalItem();
}
