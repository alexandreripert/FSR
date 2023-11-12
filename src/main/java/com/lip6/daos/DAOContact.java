package com.lip6.daos;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.lip6.entities.Address;
import com.lip6.entities.Contact;
import com.lip6.entities.PhoneNumber;
import com.lip6.utils.JpaUtil;

public class DAOContact implements IDAOContact {

	/**
	 * Rajoute un contact dans la base de donnees.
	 * 
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @return renvoit le nouveau contact
	 */
	
	public  boolean addContact(Contact c) {

		//Avant l'utilisation de classe JpaUtil	
		//EntityManagerFactory emf=Persistence.createEntityManagerFactory("projetJPA");
		
		//1: obtenir une connexion et un EntityManager, en passant par la classe JpaUtil
		
	    boolean success=false;
	  
		try {
			 
	    EntityManager em=JpaUtil.getEmf().createEntityManager();
	 
		// 2 : Ouverture transaction 
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		
		//a.setContact(c);
		
		em.persist(c);
		
		
		
		// 5 : Fermeture transaction 
		tx.commit();
		
		
		 
		// 6 : Fermeture de l'EntityManager et de unit� de travail JPA 
		em.close();
	
		// 7: Attention important, cette action ne doit s'executer qu'une seule fois et non pas à chaque instantiation du ContactDAO
		//Donc, pense bien à ce qu'elle soit la dernière action de votre application
		//JpaUtil.close();	
		
		success=true;
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		return success;
	}
	/**
	 * Suppresion d'un contact a partir de son identifiant
	 * 
	 * @param id
	 * @return vrai si la suppression a bien ete effectuee
	 */
	@Override
	public int deleteContact(long id) {
		int success = 0;
		System.out.println(id);
		//Avant l'utilisation de classe JpaUtil	
		//EntityManagerFactory emf=Persistence.createEntityManagerFactory("projetJPA");
		
		//1: obtenir une connexion et un EntityManager, en passant par la classe JpaUtil
		
		try {
			 
	    EntityManager em=JpaUtil.getEmf().createEntityManager();
	    
		// 2 : Ouverture transaction 
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		
		Contact c=em.find(Contact.class, id);
		
		em.remove(c);
		
		// 5 : Fermeture transaction 
		tx.commit();
		
		
		 
		// 6 : Fermeture de l'EntityManager et de unit� de travail JPA 
		em.close();
		
	
		success=1;
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
	

		return success;
	}

	/**
	 * Recuperation d'un contact a partir de son identifiant
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Contact getContact(long id) {
	System.out.println(id);
		//Avant l'utilisation de classe JpaUtil	
		//EntityManagerFactory emf=Persistence.createEntityManagerFactory("projetJPA");
		
		//1: obtenir une connexion et un EntityManager, en passant par la classe JpaUtil
		
		try {
		EntityManager em=JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx =  em.getTransaction();
		Contact c = null;
		tx.begin();
		
		/*
		 // NativeQuery SQL
		final String nativeQuery="SELECT * FROM contact WHERE idContact=?";
		
		List<Contact> listcontacts= em.createNativeQuery(nativeQuery,Contact.class).setParameter(1, id).getResultList();
		
		c= listcontacts.get(0);
		*/
		
		//JPQL + FETCH 
		String requete="Select c FROM Contact c LEFT JOIN FETCH c.address WHERE c.idContact=:id" ;
		TypedQuery<Contact> query=em.createQuery(requete,Contact.class);
		query.setParameter("id", id);
		List<Contact> listcontacts= query.getResultList();
			c=listcontacts.get(0);
			System.out.println(c);
			//c.getPhones().forEach(x->System.out.println(x.getPhoneNumber()));
			
		
	   /*   
	    //find 
		Contact c=em.find(Contact.class, id);	
		
		*/
		tx.commit();
		em.close();
		
	
		return c;
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
	return null;
	}

	/**
	 * Methode qui modifie les coordonees d'un contact
	 * 
	 * @param id
	 * @param firstname
	 * @param alstname
	 * @param email
	 * @return
	 */
	@Override
	public boolean modifyContact(long id, String firstname, String lastname, String email, Address newAddress, PhoneNumber phone, PhoneNumber phone2) {
		boolean success = false;
	
		try {
			
			 EntityManager em=JpaUtil.getEmf().createEntityManager();
			    
				// 2 : Ouverture transaction 
				EntityTransaction tx =  em.getTransaction();
				tx.begin();
				
				Contact c=em.find(Contact.class, id);
				
				c.setFirstName(firstname);
				c.setLastName(lastname);
				c.setEmail(email);
				
				Address address = c.getAddress();
				address.setStreet(newAddress.getStreet());
                address.setCity(newAddress.getCity());
                address.setZip(newAddress.getZip());
                address.setCountry(newAddress.getCountry());
                
                Set<PhoneNumber> phoneNumbers = c.getPhones();

                Iterator<PhoneNumber> iterator = phoneNumbers.iterator();
                if (iterator.hasNext()) {
                    PhoneNumber phone1 = iterator.next();
                    phone1.setPhoneKind(phone.getPhoneKind());
                    phone1.setPhoneNumber(phone.getPhoneNumber());
                }
                if (iterator.hasNext()) {
                    PhoneNumber phone22 = iterator.next();
                    phone22.setPhoneKind(phone2.getPhoneKind());
                    phone22.setPhoneNumber(phone2.getPhoneNumber());
                }

				
				// 5 : Fermeture transaction 
				tx.commit();
				
				
				 
				// 6 : Fermeture de l'EntityManager et de unit� de travail JPA 
				em.close();
			success = true;
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * Renvoit la liste des contacts correspondant au prenom firrstname
	 * 
	 * @param firstname
	 * @return
	 */


}
