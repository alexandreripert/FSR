package com.lip6.servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lip6.entities.Address;
import com.lip6.entities.Contact;
import com.lip6.entities.PhoneNumber;
import com.lip6.services.IServiceContact;
import com.lip6.services.ServiceContact;

/**
 * Servlet implementation class AddContactServlet
 */
@WebServlet("/AddContactServlet")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//long id=Long.parseLong(request.getParameter("id"));
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email"); 
		String street=request.getParameter("street");
		String city=request.getParameter("city");
		String zip=request.getParameter("zip");
		String country=request.getParameter("country");
	    String phoneKind = request.getParameter("phoneKind");
	    String phoneNumber = request.getParameter("phoneNumber");
	    String phoneKind2 = request.getParameter("phoneKind2");
	    String phoneNumber2 = request.getParameter("phoneNumber2");
		
		//System.out.println("street : " + street);
		//System.out.println("city: " + city);
		/*		
		ServiceContact src=new ServiceContact();
		src.createContact(id, fname, lname, email);*/
	ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		String[] allBeanNames = context.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
            System.out.println(beanName + "******************");
        }
        Contact c= (Contact) context.getBean("Contact2");
        	c.setEmail(email);
        	c.setFirstName(fname);
        	c.setLastName(lname);

		 Address a = new Address();
		 	a.setCity(city);
		 	a.setStreet(street);
		 	a.setCountry(country);
		 	a.setZip(zip);

		 	c.setAddress(a);
		 	
		    Set<PhoneNumber> phoneNumbers = new HashSet<>();
		    if (phoneKind != null && phoneNumber != null) {
		        PhoneNumber p = new PhoneNumber(phoneKind, phoneNumber);
		        phoneNumbers.add(p);
		    }
		    
		    c.setPhones(phoneNumbers);
		    
		    Set<PhoneNumber> phoneNumbers2 = new HashSet<>();
		    if (phoneKind2 != null && phoneNumber2 != null) {
		        PhoneNumber p2 = new PhoneNumber(phoneKind2, phoneNumber2);
		        phoneNumbers.add(p2);
		    }
		    
		    c.setPhones(phoneNumbers2);
		 	
		 	//System.out.println("Adresse avant la persistance : " + a.getCity() + ", " + a.getStreet() + ", " + a.getZip() + ", " + a.getCountry());
		 	//System.out.println("Adresse associée au contact avant la persistance : " + c.getAddress().getCity() + ", " + c.getAddress().getStreet());
		 	
        IServiceContact service= (ServiceContact) context.getBean("serviceContact");
        
        
        service.createContact(c, a, phoneNumbers);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("menuContact.jsp");
        dispatcher.forward(request, response);
		
	}   

}
