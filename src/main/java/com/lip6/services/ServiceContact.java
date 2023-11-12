package com.lip6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lip6.daos.DAOContact;
import com.lip6.daos.IDAOContact;
import com.lip6.entities.Address;
import com.lip6.entities.Contact;

@Service
public class ServiceContact implements IServiceContact {
	
	
	private IDAOContact daoc;
	
	@Autowired
	public ServiceContact (IDAOContact daoc) {
		this.daoc=daoc;
	}
	
	
	public void createContact(Contact c, Address a) {
		
		c.setAddress(a);
	
		boolean ok=daoc.addContact(c, a);
		if (ok)
			System.out.println("Contact ajout�!");
		else
			System.out.println("Contact non ajout�!");
		
	}
	
	
	public void deleteContact(long id) {
		
		
		int ok=daoc.deleteContact(id);
		if (ok!=0)
			System.out.println("Contact supprime!");
		else
			System.out.println("Contact non supprime!");
		
	}
	
public void updateContact(long id,String firstname, String lastname,String email) {
		
		
		 boolean ok=daoc.modifyContact(id, firstname, lastname, email);
		if (ok)
			System.out.println("Contact modifié!");
		else
			System.out.println("Contact non modifié!");
		
	}

public void searchIDContact(long id) {
	Contact ok = daoc.getContact(id);
    if (ok != null) {
        System.out.println(ok.getIdContact() + "," + ok.getFirstName() + "," + ok.getLastName() + "," + ok.getEmail());
    } else {
        System.out.println("Aucun contact trouvé avec l'ID : " + id);
    }
}

}
