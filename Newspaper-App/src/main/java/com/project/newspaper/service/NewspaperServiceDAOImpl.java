package com.project.newspaper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.dto.NewspaperDto;
import com.project.newspaper.dao.NewspaperDAO;
import com.project.newspaper.entity.Newspaper;

@Service
public class NewspaperServiceDAOImpl implements NewspaperServiceDAO {
	@Autowired
	private NewspaperDAO newspaperDAO;

	private String validateMsg;
	
	public NewspaperServiceDAOImpl() {
		System.out.println("NewspaperServiceDAOImpl.NewspaperServiceDAOImpl()");
	}

	@Override
	public boolean validateNewspaperDTO(NewspaperDto newspaperDto) {
		System.out.println("NewspaperServiceDAOImpl.validateNewspaperDTO()");
//		if (newspaperDto.getNewspaperName() == null || newspaperDto.getNewspaperName().isEmpty() ||
//				newspaperDto.getNewspaperName().isBlank()) {
//			validateMsg = "Invalid Newspaper Name";
//			return false;
//		} else if (newspaperDto.getPrice() <= 0) {
//			validateMsg = "Invalid Newspaper Price";
//			return false;
//		} else if (newspaperDto.getLanguage() == null || newspaperDto.getLanguage().isEmpty() ||
//				newspaperDto.getNewspaperName().isBlank()) {
//			validateMsg = "Invalid Newspaper Language";
//			return false;
//		} else if (newspaperDto.getNoOfPages() <= 0) {
//			validateMsg = "Invalid Newspaper NoOfPages";
//			return false;
//		} else {
//			validateMsg = "All the Newspaper Details are valid";
//			return true;
//		}

		if (validateNewspaperName(newspaperDto.getNewspaperName()) &&
				validateNewspaperPrice(newspaperDto.getPrice()) &&
				validateNewspaperLanguage(newspaperDto.getLanguage()) &&
				validateNewspaperNoOfPages(newspaperDto.getNoOfPages())) {
			setValidateMsg("Newspaper details are valid!");
			return true;
		}
		return false;
	}

	@Override
	public boolean validateNewspaperID(int id) {
		System.out.println("NewspaperServiceDAOImpl.validateNewspaperID()");

		if (id > 0) {
			setValidateMsg("ID: " + id);
			return true;
		}
		setValidateMsg("Invalid Newspaper ID");
		return false;
	}
	
	@Override
	public boolean validateNewspaperName(String name) {
		System.out.println("NewspaperServiceDAOImpl.validateNewspaperName()");
		if(name != null && !name.isEmpty() && !name.isBlank()) {
			return true;
		}
		setValidateMsg("Invalid Newspaper Name");
		return false;
	}

	@Override
	public boolean validateNewspaperPrice(double price) {
		System.out.println("NewspaperServiceDAOImpl.validateNewspaperPrice()");
		if (price > 0) {
			return true;
		}
		setValidateMsg("Invalid Newspaper Price");
		return false;
	}

	@Override
	public boolean validateNewspaperLanguage(String language) {
		System.out.println("NewspaperServiceDAOImpl.validateNewspaperLanguage()");
		if(language != null && !language.isEmpty() && !language.isBlank()) {
			return true;
		}
		setValidateMsg("Invalid Newspaper Language");
		return false;
	}

	@Override
	public boolean validateNewspaperNoOfPages(int noOfPages) {
		System.out.println("NewspaperServiceDAOImpl.validateNewspaperNoOfPages()");
		if (noOfPages > 0) {
			return true;
		}
		setValidateMsg("Invalid Newspaper NumberOfPages");
		return false;
	}

	@Override
	public boolean saveNewspaperDTO(NewspaperDto newspaperDto) {
		System.out.println("NewspaperServiceDAOImpl.saveNewspaperDTO()");
		Newspaper newspaper = new Newspaper();
		BeanUtils.copyProperties(newspaperDto, newspaper);
		boolean result = this.newspaperDAO.saveNewspaperEntity(newspaper);
		return result;
	}

	@Override
	public NewspaperDto getNewspaperWithID(int id) {
		System.out.println("NewspaperServiceDAOImpl.getNewspaperID()");
		Newspaper entity = this.newspaperDAO.getNewspaperEntityByID(id);
		if (entity != null) {
			NewspaperDto dto = new NewspaperDto();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}
		return null;
	}

	@Override
	public List<Object> getNewspaperEntitiesWithName(String name) {
		System.out.println("NewspaperServiceDAOImpl.getNewspaperEntitiesWithName()");
		List<Object> newspaperContainer = null;
		List<Newspaper> newspapers = this.newspaperDAO.getNewspaperEntitiesByName(name);
		if (newspapers != null) {
			setValidateMsg("Number of newspaper found: " + newspapers.size());
			return newspaperContainer = new ArrayList<Object>(newspapers);
		}
		setValidateMsg("newspapers list is null");
		return newspaperContainer;
	}

	@Override
	public List<Object> getNewspaperEntitiesWithPrice(Double price) {
		List<Object> newspaperContainer = null;
		List<Newspaper> newspapers = this.newspaperDAO.getNewspaperEntitiesByPrice(price);
		if (newspapers != null) {
			setValidateMsg("Number of newspaper found: " + newspapers.size());
			return newspaperContainer = new ArrayList<Object>(newspapers);
		}
		setValidateMsg("newspapers list is null");
		return newspaperContainer;
	}

	@Override
	public List<Object> getNewspaperEntitiesWithLanguage(String language) {
		System.out.println("NewspaperServiceDAOImpl.getNewspaperEntitiesWithName()");
		List<Object> newspaperContainer = null;
		List<Newspaper> newspapers = this.newspaperDAO.getNewspaperEntitiesByLanguage(language);
		if (newspapers != null) {
			setValidateMsg("Number of newspaper found: " + newspapers.size());
			return newspaperContainer = new ArrayList<Object>(newspapers);
		}
		setValidateMsg("newspapers list is null");
		return newspaperContainer;
	}

	@Override
	public List<Object> getNewspaperEntitiesWithNoOfPages(int noOfPages) {
		List<Object> newspaperContainer = null;
		List<Newspaper> newspapers = this.newspaperDAO.getNewspaperEntitiesByNoOfPages(noOfPages);
		if (newspapers != null) {
			setValidateMsg("Number of newspaper found: " + newspapers.size());
			return newspaperContainer = new ArrayList<Object>(newspapers);
		}
		setValidateMsg("newspapers list is null");
		return newspaperContainer;
	}

	@Override
	public NewspaperDto deleteNewspaperWithID(int id) {
		System.out.println("NewspaperServiceDAOImpl.deleteNewspaperWithID()");
		Newspaper entity = this.newspaperDAO.getNewspaperEntityByID(id);
		if (entity != null) {
			NewspaperDto dto = new NewspaperDto();
			BeanUtils.copyProperties(entity, dto);
			this.newspaperDAO.deleteNewspaperEntityByID(id);
			System.out.println("Found newspaper with ID: " + id);
			setValidateMsg("Found newspaper with ID: " + id);
			return dto;
		}else {
			System.out.println("Could not find newspaper with ID: " + id);
			setValidateMsg("Could not find newspaper with ID: " + id);
		}
		return null;
	}
	
	@Override
	public List<Object> getAllNewspaperEntities() {
		System.out.println("NewspaperServiceDAOImpl.getAllNewspaperEntities()");
		List<Object> newspaperContainer = null;
		List<Newspaper> newspapers = this.newspaperDAO.getAllNewspaperEntities();
		if (newspapers != null) {
			setValidateMsg("Number of newspaper found: " + newspapers.size());
			return newspaperContainer = new ArrayList<Object>(newspapers);
		}
		setValidateMsg("newspapers list is null");
		return newspaperContainer;
	}

	@Override
	public NewspaperDto updateNewspaperWithID(NewspaperDto dto) {
		System.out.println("NewspaperServiceDAOImpl.updateNewspaperWithID()");
		if (this.newspaperDAO.updateNewspaperEntityByID(dto)) {
			setValidateMsg("Updated: " + dto.getId());
			return dto;
		}else {
			setValidateMsg("Did not update: " + dto.getId());
		}
		return null;
	}
	
	public String getValidateMsg() {
		return validateMsg;
	}

	public void setValidateMsg(String validateMsg) {
		this.validateMsg = validateMsg;
	}



	
}