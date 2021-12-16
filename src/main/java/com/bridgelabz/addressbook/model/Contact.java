package com.bridgelabz.addressbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.bridgelabz.addressbook.dto.ContactDTO;

import lombok.Data;

@Entity
@Table(name = "addressbook_data")
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "Contact_Id")
    private long Id;

    private String fullName;
	 private String address;
	 private String state;
	 private String city;
	 private String zip;
	 private String phone;

	
	 public Contact(ContactDTO contactDTO) {
		super();
		this.updateData(contactDTO);
	}

	public void updateData(ContactDTO contactDTO) {
		this.fullName = contactDTO.fullName;
        this.address = contactDTO.address;
        this.city = contactDTO.city;
        this.state = contactDTO.state;
        this.zip = contactDTO.zip;
        this.phone = contactDTO.phone;	
	} 


	@Override
	public String toString() {
		return "Contact [contactId=" + Id + ", fullName=" + fullName + ", address="
				+ address + ", state=" + state + ", city=" + city + ", zip=" + zip + ", phone=" + phone + "]";
	}
	
	
}
