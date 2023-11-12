package com.lip6.daos;

import java.util.Set;

import com.lip6.entities.Address;
import com.lip6.entities.Contact;
import com.lip6.entities.ContactGroup;

public interface IDAOContactGroup {
	
	public boolean addContactGroup(ContactGroup g);
	public int deleteContactGroup(long id);
	public ContactGroup getContactGroup(long id);
	public boolean modifyContactGroup(long id, String groupname);
	public boolean addContactToGroup(long contactId, long groupId);
	public Set<Contact> getContactsByGroupId(long groupId);

}
