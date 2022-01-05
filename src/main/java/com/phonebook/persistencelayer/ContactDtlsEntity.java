package com.phonebook.persistencelayer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "Contact_dtls")
public class ContactDtlsEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "Contact_Id")
	private Integer contactId;
	@Column(name = "Contact_Name")
	private String name;
	@Column(name = "Contact_Email")
	private String email;
	@Column(name = "Contact_Number")
	private Long phno;
}
