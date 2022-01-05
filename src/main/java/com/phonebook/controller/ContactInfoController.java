package com.phonebook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.phonebook.pojo.Contact;
import com.phonebook.service.ContactServiceImpl;

@Controller
public class ContactInfoController {
	@Autowired
	private ContactServiceImpl contactService;

	private static final Logger logger =LoggerFactory.getLogger(ContactInfoController.class);

	/**
	 * method is to show index page and send pojo object to index for form data
	 * capture
	 * 
	 * @param model
	 * @return view-Name
	 */
	@GetMapping("/")
	public String displayContactForm(Model model) { // for display index page
		logger.debug("**** displayContactForm() method execution started ****");
		Contact contactObj = new Contact();
		model.addAttribute("contact", contactObj);
		logger.debug("**** displayContactForm() method execution ended ****");
		logger.info("**** displayContactForm() method executed successfully ****");
		return "index";
		
	}

	/**
	 * This method is to save contact
	 * At the time of controller to UI use model 
	 * And at the time of redirection use RedirectAttribute 
	 * @param c
	 * @param model
	 * @return view-Name
	 */
	@PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact") Contact c, RedirectAttributes attribute) { // for save and update
		boolean isSaved = contactService.saveContact(c);
		logger.debug("**** Save Contact execution Started");
		if (isSaved) {
			if(c.getContactId() !=null) {
				attribute.addFlashAttribute("successMsg", "Contact Updated");
				logger.info("Contact Updated Successfully");
			}
			else {
				attribute.addFlashAttribute("successMsg", "Contact Saved");
				logger.info("Contact Saved SuccessFully");
			}
			
		} else {
			attribute.addFlashAttribute("errMsg", "Failed to save contact");
			logger.info("Failed To Save Contact");
		}
		logger.debug("****handleSubmitBtn() method execution ended ****");
		return "redirect:/savedContact";  //redirecting to avoid double posting problem 
	}

	/**
	 * This method is used to display success msg post contact submission
	 * 
	 * @return view-Name
	 */
		  @GetMapping("/savedContact") 
		  public String isContactSaved(Model model) {
			logger.debug("**** isContactSaved() method execution started ****");
		  	
			model.addAttribute("contact",new Contact());
		  	
		  	logger.debug("**** isContactSaved() method execution ended ****");
		  	
		  	logger.info("isContactSaved method executed successfully");
		  	
		  	return "index"; 
		  }
		 
	@GetMapping("/viewContacts")
	public String handleViewCtcsHyperlink(Model model) { // for hyperlink viewAllContacts
		logger.debug("****handleViewCtcsHyperlink() method execution started****");
		List<Contact> allContacts = contactService.getAllContacts();
		model.addAttribute("contacts",allContacts);
		logger.debug("****handleViewCtcsHyperlink() method execution ended****");
		logger.info("handleViewCtcsHyperlink() method executed successfully");
		return "viewContacts";
	}
}
