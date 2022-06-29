package com.project.dto;

import lombok.Data;

@Data
public class NewspaperDto {
	int id;
	String newspaperName;
	double price;
	String language;
	int noOfPages;
}