package com.lip6.services;

import java.util.Set;

import com.lip6.entities.ContactGroup;


public interface IServiceContactGroup {

	public void createContactGroup(ContactGroup gc);
	public void deleteContactGroup(long id);
	public void updateContactGroup(long id,String groupname);
	public void searchIDContactGroup(long id);
}
