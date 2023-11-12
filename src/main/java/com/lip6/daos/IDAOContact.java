package com.lip6.daos;

import java.util.ArrayList;

import com.lip6.entities.Address;
import com.lip6.entities.Contact;

public interface IDAOContact {

	
	//public  boolean addContact(long idContact, String firstname, String lastname, String email);
	
	
	public boolean addContact(Contact c, Address a);
	public int deleteContact(long id);
	
	public Contact getContact(long id);
	
	public boolean modifyContact(long id, String firstname, String lastname, String email, Address address);
	
	public ArrayList<Contact> getContactByFirstName(String firstname);
	
	public ArrayList<Contact> getContactByLastName(String lastname);
	
	public ArrayList<Contact> getContactByEmail(String email);
	
}
