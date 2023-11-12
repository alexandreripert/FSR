package com.lip6.services;

import java.util.Set;

import com.lip6.daos.DAOContact;
import com.lip6.daos.IDAOContact;
import com.lip6.entities.Address;
import com.lip6.entities.Contact;
import com.lip6.entities.PhoneNumber;

public interface IServiceContact {
	
	public void createContact(Contact c, Address a, Set<PhoneNumber> p);
	
	public void deleteContact(long id);
	
	public void updateContact(long id,String firstname, String lastname,String email, Address address, PhoneNumber phone, PhoneNumber phone2);
	
	public void searchIDContact(long id);

}
