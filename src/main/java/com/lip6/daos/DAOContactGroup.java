package com.lip6.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.lip6.entities.Address;
import com.lip6.entities.Contact;
import com.lip6.entities.ContactGroup;
import com.lip6.utils.JpaUtil;

public class DAOContactGroup implements IDAOContactGroup {
	
	public boolean addContactGroup(ContactGroup gc) {
		
	    boolean success=false;
	  
		try {
			 
	    EntityManager em=JpaUtil.getEmf().createEntityManager();
	 
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		
		
		em.persist(gc);
			
		tx.commit();
		
		em.close();
	
		success=true;
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		return success;
	}
	
	@Override
	public int deleteContactGroup(long id) {
		int success = 0;
		System.out.println(id);

		try {
			 
	    EntityManager em=JpaUtil.getEmf().createEntityManager();
	    
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		
		ContactGroup cg=em.find(ContactGroup.class, id);
		
		em.remove(cg);
		
		tx.commit();
		
		
		em.close();
		
	
		success=1;
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
	

		return success;
	}
	
	@Override
	public ContactGroup getContactGroup(long id) {
	System.out.println(id);

		try {
		EntityManager em=JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx =  em.getTransaction();
		ContactGroup cg = null;
		tx.begin();
		
		
		//JPQL
		String requete="Select cg FROM ContactGroup cg  WHERE cg .groupId=:id" ;
		TypedQuery<ContactGroup> query=em.createQuery(requete,ContactGroup.class);
		query.setParameter("id", id);
		List<ContactGroup> listcontactgroup= query.getResultList();
			cg=listcontactgroup.get(0);
			System.out.println(cg);

		tx.commit();
		em.close();
		
	
		return cg;
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
	return null;
	}


	@Override
	public boolean modifyContactGroup(long id, String groupname) {
		boolean success = false;
	
		try {
			
			 EntityManager em=JpaUtil.getEmf().createEntityManager();
			    
				EntityTransaction tx =  em.getTransaction();
				tx.begin();
				
				ContactGroup cg=em.find(ContactGroup.class, id);
				
				cg.setGroupName(groupname);
				
				tx.commit();

				em.close();
			success = true;
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean addContactToGroup(long contactId, long groupId) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        boolean success = false;
        
        try {
            tx.begin();
            
            Contact contact = em.find(Contact.class, contactId);
            ContactGroup group = em.find(ContactGroup.class, groupId);
            
            group.getContacts().add(contact);
            contact.getContactGroups().add(group);
            
            em.merge(group);
            
            tx.commit();
            success = true;
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        
        return success;
    }

}
