package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.dto.NewspaperDto;
import com.project.newspaper.service.NewspaperServiceDAO;
import com.project.newspaper.service.NewspaperServiceDAOImpl;

@Controller
@RequestMapping
public class NewspaperController {
	@Autowired
	private NewspaperServiceDAOImpl newspaperServiceDAO;

	public NewspaperController() {
		System.out.println("NewspaperController.NewspaperController()");
	}

	@RequestMapping("/save.do")
	public String saveNewspaperDetails(@ModelAttribute NewspaperDto newspaperDto, Model model) {
		System.out.println("NewspaperController.saveNewspaperDetails()");

		if (this.newspaperServiceDAO.validateNewspaperDTO(newspaperDto)) {
			if (this.newspaperServiceDAO.saveNewspaperDTO(newspaperDto)) {
				model.addAttribute("Name", newspaperDto.getNewspaperName());
				model.addAttribute("Price", newspaperDto.getPrice());
				model.addAttribute("Language", newspaperDto.getLanguage());
				model.addAttribute("No_of_pages", newspaperDto.getNoOfPages());
			}
		} else {
			model.addAttribute("ValidateMessage", newspaperServiceDAO.getValidateMsg());
		}
		model.addAttribute("ValidateMessage", newspaperServiceDAO.getValidateMsg());
		return "/WEB-INF/Pages/viewNewspaperDetails.jsp";
	}

	@RequestMapping("/searchID.do")
	public String getNewspaperID(@RequestParam int newspaperID, Model model) {
		System.out.println("NewspaperController.getNewspaperID()");
		if (this.newspaperServiceDAO.validateNewspaperID(newspaperID)) {
			NewspaperDto newspaperDto = this.newspaperServiceDAO.getNewspaperWithID(newspaperID);
			if (newspaperDto != null) {
				model.addAttribute("Name", newspaperDto.getNewspaperName());
				model.addAttribute("Price", newspaperDto.getPrice());
				model.addAttribute("Language", newspaperDto.getLanguage());
				model.addAttribute("No_of_pages", newspaperDto.getNoOfPages());
			}
		}

		model.addAttribute("ValidateMessage", newspaperServiceDAO.getValidateMsg());
		return "/WEB-INF/Pages/viewNewspaperDetails.jsp";
	}

	@RequestMapping("/searchName.do")
	public String getNewspaperEntitiesWithName(@RequestParam String newspaperName, Model model) {
		System.out.println("NewspaperController.getNewspaperEntitiesWithName()");
		if (this.newspaperServiceDAO.validateNewspaperName(newspaperName)) {
			List<Object> newspaperDTO = this.newspaperServiceDAO.getNewspaperEntitiesWithName(newspaperName);
			if (newspaperDTO != null) {
				model.addAttribute("ListOfNewspapers", newspaperDTO);
				model.addAttribute("ValidateMessage", "Newspaper Found!");
			}
		}
		model.addAttribute("ValidateMessage", newspaperServiceDAO.getValidateMsg());
		return "/WEB-INF/Pages/viewNewspapersDetailsList.jsp";

	}

	@RequestMapping("/searchPrice.do")
	public String getNewspaperEntitiesWithPrice(@RequestParam double price, Model model) {
		System.out.println("NewspaperController.getNewspaperEntitiesWithPrice()");
		if (this.newspaperServiceDAO.validateNewspaperPrice(price)) {
			List<Object> newspaperDTO = this.newspaperServiceDAO.getNewspaperEntitiesWithPrice(price);
			if (newspaperDTO != null) {
				model.addAttribute("ListOfNewspapers", newspaperDTO);
				model.addAttribute("ValidateMessage", "Newspaper Found!");
			}
		}
		model.addAttribute("ValidateMessage", newspaperServiceDAO.getValidateMsg());
		return "/WEB-INF/Pages/viewNewspapersDetailsList.jsp";

	}

	@RequestMapping("/searchLanguage.do")
	public String getNewspaperEntitiesWithLanguage(@RequestParam String language, Model model) {
		System.out.println("NewspaperController.getNewspaperEntitiesWithLanguage()");
		if (this.newspaperServiceDAO.validateNewspaperLanguage(language)) {
			List<Object> newspaperDTO = this.newspaperServiceDAO.getNewspaperEntitiesWithLanguage(language);
			if (newspaperDTO != null) {
				model.addAttribute("ListOfNewspapers", newspaperDTO);
				model.addAttribute("ValidateMessage", "Newspaper Found!");
			}
		}
		model.addAttribute("ValidateMessage", newspaperServiceDAO.getValidateMsg());
		return "/WEB-INF/Pages/viewNewspapersDetailsList.jsp";
	}

	@RequestMapping("/searchNoOfPages.do")
	public String getNewspaperEntitiesWithNoOfPages(@RequestParam int noOfPages, Model model) {
		System.out.println("NewspaperController.getNewspaperEntitiesWithNoOfPages()");
		if (this.newspaperServiceDAO.validateNewspaperNoOfPages(noOfPages)) {
			List<Object> newspaperDTO = this.newspaperServiceDAO.getNewspaperEntitiesWithNoOfPages(noOfPages);
			if (newspaperDTO != null) {
				model.addAttribute("ListOfNewspapers", newspaperDTO);
				model.addAttribute("ValidateMessage", "Newspaper Found!");
			}
		}
		model.addAttribute("ValidateMessage", newspaperServiceDAO.getValidateMsg());
		return "/WEB-INF/Pages/viewNewspapersDetailsList.jsp";
	}

	@RequestMapping("/deleteNewspaperWithID.do")
	public String deleteNewspaperEntityWithID(@RequestParam int newspaperID, Model model) {
		if (this.newspaperServiceDAO.validateNewspaperID(newspaperID)) {
			NewspaperDto newspaperDto = this.newspaperServiceDAO.deleteNewspaperWithID(newspaperID);
			if (newspaperDto != null) {
				model.addAttribute("Name", newspaperDto.getNewspaperName());
				model.addAttribute("Price", newspaperDto.getPrice());
				model.addAttribute("Language", newspaperDto.getLanguage());
				model.addAttribute("No_of_pages", newspaperDto.getNoOfPages());
			}
		}

		model.addAttribute("ValidateMessage", newspaperServiceDAO.getValidateMsg());
		return "/WEB-INF/Pages/viewNewspaperDetails.jsp";
	}

	@RequestMapping("/getAllNewspaperEntities.do")
	public String getAllNewspaperEntities(Model model) {
		System.out.println("NewspaperController.getAllNewspaperEntities()");

		List<Object> newspaperDTO = this.newspaperServiceDAO.getAllNewspaperEntities();
		if (newspaperDTO != null) {
			model.addAttribute("ListOfNewspapers", newspaperDTO);
		}

		model.addAttribute("ValidateMessage", newspaperServiceDAO.getValidateMsg());
		return "/WEB-INF/Pages/viewNewspapersDetailsList.jsp";

	}

	@RequestMapping("/update.do")
	public String updateNewspaperDetails(@ModelAttribute NewspaperDto newspaperDto, Model model) {
		System.out.println("NewspaperController.updateNewspaperDetails()");

		if (this.newspaperServiceDAO.validateNewspaperID(newspaperDto.getId())) {
			if (this.newspaperServiceDAO.validateNewspaperDTO(newspaperDto)) {
			 	this.newspaperServiceDAO.updateNewspaperWithID(newspaperDto);
				model.addAttribute("Name", newspaperDto.getNewspaperName());
				model.addAttribute("Price", newspaperDto.getPrice());
				model.addAttribute("Language", newspaperDto.getLanguage());
				model.addAttribute("No_of_pages", newspaperDto.getNoOfPages());

			}
		} else {
			model.addAttribute("ValidateMessage", newspaperServiceDAO.getValidateMsg());
		}
		model.addAttribute("ValidateMessage", newspaperServiceDAO.getValidateMsg());
		return "/WEB-INF/Pages/viewNewspaperDetails.jsp";
	}
}