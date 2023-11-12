package com.lip6.services;

import java.util.Set;

import com.lip6.entities.Contact;
import com.lip6.entities.ContactGroup;


public interface IServiceContactGroup {

	public void createContactGroup(ContactGroup gc);
	public void deleteContactGroup(long id);
	public void updateContactGroup(long id,String groupname);
	public ContactGroup searchIDContactGroup(long id);
	public boolean addContactToGroup(long contactId, long groupId);
	public Set<Contact> listContactsByGroup(long groupId);
}
