package com.bridgelabz.addressbook.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.model.Contact;
import com.bridgelabz.addressbook.repository.AddressBookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService{

	@Autowired
    private AddressBookRepository addressBookRepository;
	
	@Override
	public List<Contact> getContact() {
		
		return addressBookRepository.findAll();
	}

	@Override
	public Contact getContactById(long id) {
		
		return addressBookRepository.findById(id)
				.orElseThrow(() -> new AddressBookException("Address book contact "+id+" does not exists"));
	}

	@Override
	public Contact createContact(ContactDTO contactDTO) {
		Contact contactData = new Contact(contactDTO);
		log.debug("Address book data ", contactData);
		return addressBookRepository.save(contactData);
	}

	@Override
	public Contact updateContact(long id, ContactDTO contactDTO) {
		Contact contactData = this.getContactById(id);
		contactData.updateData(contactDTO);
        return addressBookRepository.save(contactData);
	}

	@Override
	public void deleteContact(long id) {
		Contact contactData = this.getContactById(id);
		addressBookRepository.delete(contactData);		
	}
	   
}
