package com.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phonebook.pojo.Contact;
import com.phonebook.service.ContactServiceImpl;

@Controller
public class ViewContactsController {
	@Autowired
	private ContactServiceImpl contactService;
	
	
	@GetMapping("/addContact")
	public String handleAddCtcHyperlink(Model model) { //for hyperlink addContact
		Contact contactObj = new Contact();
		model.addAttribute("contact", contactObj);
		return "index";
	}
	
	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer cid, Model model) { //edit contact
		Contact contact = contactService.getContactById(cid);
		model.addAttribute("contact",contact);
		return "index";
	}
	
	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer cid, Model model) {  //delete contact
		//boolean deleteContact = 
		contactService.deleteContact(cid);
		
		return "redirect:/viewContacts";
	}
}
