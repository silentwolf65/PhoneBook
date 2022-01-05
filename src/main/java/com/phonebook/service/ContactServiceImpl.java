package com.phonebook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.persistencelayer.ContactDtlsEntity;
import com.phonebook.persistencelayer.ContactDtlsRepository;
import com.phonebook.pojo.Contact;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDtlsRepository contactRepo;
	
	/**
	 * This method is used to save contact details
	 * */
	@Override
	public boolean saveContact(Contact contact) {
		ContactDtlsEntity entity = new ContactDtlsEntity();
		BeanUtils.copyProperties(contact, entity); //copying data from one object to another object
		ContactDtlsEntity savedEntity =contactRepo.save(entity);
		return savedEntity.getContactId() !=null;
	}

	/**
	 * This method is to fetch all the records from table
	 * 
	 * @return List<contact>
	 * */
	@Override
	public List<Contact> getAllContacts() {
		List<ContactDtlsEntity> entitiesList =contactRepo.findAll();
		List<Contact> contactsList = new ArrayList<>();
		entitiesList.forEach(entity ->{
			Contact c = new Contact();
			BeanUtils.copyProperties(entity, c);
			contactsList.add(c);
		});
		return contactsList;
	}
	
	/**
	 * This method is to search is contact present or not  
	 * @return contact
	 * */
	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactDtlsEntity> contact =contactRepo.findById(cid);
		if(contact.isPresent()) {
			ContactDtlsEntity entity = contact.get();
			Contact c = new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
		}
		return null;
	}
	
	/**
	 * This method is to delete contact based on id 
	 * 
	 * @return true
	 * */
	@Override
	public boolean deleteContact(Integer cid) {
		contactRepo.deleteById(cid);
		return true;
	}

}
