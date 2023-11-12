package com.lip6.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lip6.daos.IDAOContact;
import com.lip6.entities.Address;
import com.lip6.entities.Contact;
import com.lip6.entities.PhoneNumber;

@Service
public class ServiceContact implements IServiceContact {
	
	
	private IDAOContact daoc;
	
	@Autowired
	public ServiceContact (IDAOContact daoc) {
		this.daoc=daoc;
	}
	
	
	public void createContact(Contact c, Address a, Set<PhoneNumber> p) {
		
		c.setAddress(a);
		
		 for(PhoneNumber phone : p) {
		        phone.setContact(c); //
		        c.getPhones().add(phone);
		    }
	
		boolean ok=daoc.addContact(c);
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
	
public void updateContact(long id,String firstname, String lastname,String email, Address address, PhoneNumber phone, PhoneNumber phone2) {
		
		
		 boolean ok=daoc.modifyContact(id, firstname, lastname, email, address, phone, phone2);
		if (ok)
			System.out.println("Contact modifié!");
		else
			System.out.println("Contact non modifié!");
		
	}

public Contact searchIDContact(long id) {
	Contact ok = daoc.getContact(id);
    if (ok != null) {
        System.out.println(ok.getIdContact() + "," + ok.getFirstName() + "," + ok.getLastName() + "," + ok.getEmail());
        if (ok.getAddress() != null) {
            Address a = ok.getAddress();
            System.out.println("Adresse: " + a.getStreet() + ", " + a.getCity() + ", " + a.getZip() + ", " + a.getCountry());
        }
    } else {
        System.out.println("Aucun contact trouvé avec l'ID : " + id);
    }
    return daoc.getContact(id);
}

}
