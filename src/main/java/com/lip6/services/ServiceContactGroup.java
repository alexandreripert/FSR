package com.lip6.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lip6.daos.IDAOContactGroup;
import com.lip6.entities.Contact;
import com.lip6.entities.ContactGroup;

@Service
public class ServiceContactGroup implements IServiceContactGroup {
	
private IDAOContactGroup daocg;
	
	@Autowired
	public ServiceContactGroup (IDAOContactGroup daocg) {
		this.daocg=daocg;
	}
	
public void createContactGroup(ContactGroup cg) {
		
	
		boolean ok=daocg.addContactGroup(cg);
		if (ok)
			System.out.println("Groupe ajout�!");
		else
			System.out.println("Groupe non ajout�!");
	}

	public void deleteContactGroup(long id) {
	
	
		int ok=daocg.deleteContactGroup(id);
		if (ok!=0)
			System.out.println("Groupe supprime!");
		else
			System.out.println("Groupe non supprime!");
	
}
	
	public void updateContactGroup(long id,String groupname) {
		
		
		 boolean ok=daocg.modifyContactGroup(id, groupname);
		if (ok)
			System.out.println("Groupe modifié!");
		else
			System.out.println("Groupe non modifié!");
		
	}

public ContactGroup searchIDContactGroup(long id) {
	ContactGroup ok = daocg.getContactGroup(id);
   if (ok != null) {
       System.out.println(ok.getGroupId() + "," + ok.getGroupName());
   } else {
       System.out.println("Aucun groupe trouvé avec l'ID : " + id);
   }
   
   return daocg.getContactGroup(id);
   
}

public boolean addContactToGroup(long contactId, long groupId) {
    return daocg.addContactToGroup(contactId, groupId);
}

public Set<Contact> listContactsByGroup(long groupId) {
    return daocg.getContactsByGroupId(groupId);
}

public boolean removeContactFromGroup(long contactId, long groupId) {
    return daocg.removeContactFromGroup(contactId, groupId);
}
}
