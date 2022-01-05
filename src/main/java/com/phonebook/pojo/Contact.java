package com.phonebook.pojo;

import javax.persistence.Id;

import lombok.Data;
@Data
public class Contact {
	
	@Id
	private Integer contactId;
	private String name;
	private String email;
	private Long phno;
}
