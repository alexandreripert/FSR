package com.lip6.daos;

import com.lip6.entities.Address;
import com.lip6.entities.Contact;
import com.lip6.entities.ContactGroup;

public interface IDAOContactGroup {
	
	public boolean addContactGroup(ContactGroup g);
	public int deleteContactGroup(long id);
	public ContactGroup getContactGroup(long id);
	public boolean modifyContactGroup(long id, String groupname);

}
