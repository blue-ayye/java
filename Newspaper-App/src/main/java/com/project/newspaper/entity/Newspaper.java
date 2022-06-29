package com.project.newspaper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQuery;

import lombok.Data;

@Data
@Entity
@Table(name = "newspaper_details")
@NamedQuery(name = "Newspaper.getEntityByID", query = "from Newspaper where id = :_id")
@NamedQuery(name = "Newspaper.getEntitiesByName", query = "from Newspaper where newspaperName = :_name")
@NamedQuery(name = "Newspaper.getEntitiesByPrice", query = "from Newspaper where price = :_price")
@NamedQuery(name = "Newspaper.getEntitiesByLanguage", query = "from Newspaper where language = :_language")
@NamedQuery(name = "Newspaper.getEntitiesByNoOfPages", query = "from Newspaper where noOfPages = :_noOfPages")
@NamedQuery(name = "Newspaper.deleteEntityByID", query = "delete from Newspaper where id = :_id")
@NamedQuery(name = "Newspaper.getAllEntities", query = "from Newspaper")
@NamedQuery(name = "Newspaper.updateEntityByID", query = "update Newspaper set newspaperName = :_name, price = :_price, language = :_language, noOfPages = :_noOfPages where id = :_id")
public class Newspaper implements java.io.Serializable {
	
	@Id
	@GeneratedValue(generator = "abc")
	@GenericGenerator(name = "abc", strategy = "increment")
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NEWSPAPER_NAME")
	private String newspaperName;
	
	@Column(name = "PRICE")
	private double price;
	
	@Column(name = "LANGUAGE")
	private String language;
	
	@Column(name = "NO_OF_PAGES")
	private int noOfPages;
	
}