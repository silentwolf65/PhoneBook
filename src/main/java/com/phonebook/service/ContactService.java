package com.phonebook.service;

import java.util.List;

import com.phonebook.pojo.Contact;

public interface ContactService {
	//method to save contact
	public boolean saveContact(Contact contact);
	
	//method to get list of contacts
	public List<Contact> getAllContacts();
	
	//method to fetch contact by id for editing 
	public Contact getContactById(Integer cid);
	
	
	//method to delete contact
	public boolean deleteContact(Integer cid);
	
	
}
