package com.project.newspaper.dao;

import java.util.List;

import com.project.dto.NewspaperDto;
import com.project.newspaper.entity.Newspaper;

public interface NewspaperDAO {
	boolean saveNewspaperEntity(Newspaper newspaper);
	Newspaper getNewspaperEntityByID(int id);
	List<Newspaper> getNewspaperEntitiesByName(String name);
	List<Newspaper> getNewspaperEntitiesByPrice(Double price);
	List<Newspaper> getNewspaperEntitiesByLanguage(String language);
	List<Newspaper> getNewspaperEntitiesByNoOfPages(int noOfPages);
	boolean deleteNewspaperEntityByID(int id);
	List<Newspaper> getAllNewspaperEntities();
	boolean updateNewspaperEntityByID(NewspaperDto dto);
}