package com.lip6.services;

import com.lip6.daos.DAOContact;
import com.lip6.daos.IDAOContact;
import com.lip6.entities.Address;
import com.lip6.entities.Contact;

public interface IServiceContact {
	
	public void createContact(Contact c, Address a) ;
	
	public void deleteContact(long id) ;
	
	public void updateContact(long id,String firstname, String lastname,String email, Address address);
	
	public void searchIDContact(long id);

}
