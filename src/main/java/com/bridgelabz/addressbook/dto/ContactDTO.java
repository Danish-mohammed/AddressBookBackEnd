package com.bridgelabz.addressbook.dto;

import lombok.Data;
import lombok.ToString;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.*;


@ToString
public @Data class ContactDTO {

	// @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Address book is Invalid!!! ")
	// @NotEmpty(message = "first name cannot be null")
	public String fullName;
	
	// @Pattern(regexp = "^[A-Za-z,.0-9]{3,}$", message = "Address is Invalid!!! ")
	// @NotEmpty(message = "Address cannot be null")
	public String address;
	
    // @NotEmpty(message = "State can not be NULL")
	public String state;
    
	// @NotEmpty(message = "city can not be NULL")
	public String city;
	
	// @Pattern(regexp = "^[0-9]{3}\\s{0,1}[0-9]{3}$", message = "Invalid Zip")
	public String zip;
	
	// @Pattern(regexp = "^[[+]?[0-9]{2}?[\\s,-]?]?[7-9]{1}[0-9]{9}$", message = "Invalid Phone number")
	public String phone;

}
