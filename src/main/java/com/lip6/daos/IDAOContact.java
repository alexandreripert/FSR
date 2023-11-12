package com.lip6.daos;

import com.lip6.entities.Address;
import com.lip6.entities.Contact;
import com.lip6.entities.PhoneNumber;

public interface IDAOContact {

	
	//public  boolean addContact(long idContact, String firstname, String lastname, String email);
	
	
	public boolean addContact(Contact c);
	public int deleteContact(long id);
	public Contact getContact(long id);
	public boolean modifyContact(long id, String firstname, String lastname, String email, Address address, PhoneNumber phone, PhoneNumber phone2);
	
}
