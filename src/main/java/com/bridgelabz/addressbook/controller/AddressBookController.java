package com.bridgelabz.addressbook.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.addressbook.Util.TokenUtil;
import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.Contact;
import com.bridgelabz.addressbook.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/addresshome")
@Slf4j
public class AddressBookController {
	
	@Autowired
    private IAddressBookService addressbookservice;
	
	@Autowired
    TokenUtil tokenUtil;
	
	@RequestMapping(value = { "", "/", "/get" })
    public ResponseEntity<ResponseDTO> getContactData() {
        List<Contact> contactData = addressbookservice.getContact();
        log.debug("Address Book DTO: " +contactData.toString());
        ResponseDTO response = new ResponseDTO("Get call success", contactData);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }

	@GetMapping("/get/all")
    public List<Contact> getAllContactData() {
        List<Contact> contactData = addressbookservice.getContact();
        return contactData;
    }

	
	 @GetMapping("/get/{Id}")
	    public ResponseEntity<ResponseDTO> getContactData(@PathVariable("Id") long Id) {
		 Contact contactData = addressbookservice.getContactById(Id);
	        ResponseDTO response = new ResponseDTO("Get call success for id", contactData);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	    }

	    @PostMapping("/create")
	    public ResponseEntity<ResponseDTO> createContactData(@Valid @RequestBody ContactDTO contactDTO) {
			System.out.println(contactDTO);
	        Contact contactData = addressbookservice.createContact(contactDTO);
	        log.debug("Address Book DTO: " , contactData.toString());
	        ResponseDTO response = new ResponseDTO("Created contact data for", contactData);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	    }

	    @PutMapping("/update/{Id}")
	    public ResponseEntity<ResponseDTO> updateContactData(@PathVariable("Id") long Id,
	                                                         @Valid @RequestBody ContactDTO contactDTO) {
	        Contact contactData = addressbookservice.updateContact(Id, contactDTO);
	        log.debug("AddressBook Contact After Update " + contactData.toString());

	        ResponseDTO response = new ResponseDTO("Updated contact data for" +Id, contactData );
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	    }

	    @DeleteMapping("/delete/{Id}")
	    public ResponseEntity<ResponseDTO> deleteContactData(@PathVariable("Id") long Id) {
	        addressbookservice.deleteContact(Id);

	        ResponseDTO response = new ResponseDTO("Delete call success for id ", "deleted id:" + Id);
	        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	    }
}
