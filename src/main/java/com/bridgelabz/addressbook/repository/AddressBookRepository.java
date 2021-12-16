package com.bridgelabz.addressbook.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bridgelabz.addressbook.model.Contact;

@Repository
public interface AddressBookRepository extends JpaRepository<Contact, Long> {
	
}
