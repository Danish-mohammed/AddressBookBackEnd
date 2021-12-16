package com.bridgelabz.addressbook.service;

import java.util.List;
import com.bridgelabz.addressbook.dto.ContactDTO;
import com.bridgelabz.addressbook.model.Contact;

public interface IAddressBookService {
	List<Contact> getContact();

    Contact getContactById(long id);

    Contact createContact(ContactDTO contactDTO);

    Contact updateContact(long id, ContactDTO contactDTO);

    void deleteContact(long id);   
}
