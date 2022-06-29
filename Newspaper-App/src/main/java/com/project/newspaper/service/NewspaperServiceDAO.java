package com.project.newspaper.service;

import java.util.List;

import com.project.dto.NewspaperDto;

public interface NewspaperServiceDAO {
	boolean validateNewspaperDTO(NewspaperDto newspaperDto);
	boolean validateNewspaperID(int id);
	boolean validateNewspaperName(String name);
	boolean validateNewspaperPrice(double price);
	boolean validateNewspaperLanguage(String language);
	boolean validateNewspaperNoOfPages(int noOfPages);
	
	boolean saveNewspaperDTO(NewspaperDto dto);
	NewspaperDto getNewspaperWithID(int id);
	List<Object> getNewspaperEntitiesWithName(String name);
	List<Object> getNewspaperEntitiesWithPrice(Double price);
	List<Object> getNewspaperEntitiesWithLanguage(String language);
	List<Object> getNewspaperEntitiesWithNoOfPages(int noOfPages);
	
	NewspaperDto deleteNewspaperWithID(int id);
	List<Object> getAllNewspaperEntities();
	
	NewspaperDto updateNewspaperWithID(NewspaperDto dto);
}