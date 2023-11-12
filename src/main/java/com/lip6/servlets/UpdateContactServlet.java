package com.lip6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lip6.entities.Address;
import com.lip6.entities.PhoneNumber;
import com.lip6.services.IServiceContact;
import com.lip6.services.ServiceContact;

/**
 * Servlet implementation class AddContactServlet
 */
@WebServlet("/UpdateContactServlet")
public class UpdateContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateContactServlet() {
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

		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		long id=Long.parseLong(request.getParameter("id"));
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email"); 
	    String street = request.getParameter("street");
	    String city = request.getParameter("city");
	    String zip = request.getParameter("zip");
	    String country = request.getParameter("country");
	    String phonekind = request.getParameter("phonekind");
	    String phonenumber = request.getParameter("phonenumber");
	    String phonekind2 = request.getParameter("phonekind2");
	    String phonenumber2 = request.getParameter("phonenumber2");
	    
		
	    Address newAddress = new Address();
	    newAddress.setStreet(street);
	    newAddress.setCity(city);
	    newAddress.setZip(zip);
	    newAddress.setCountry(country);
	    
	    PhoneNumber newPhone = new PhoneNumber();
	    newPhone.setPhoneKind(phonekind);
	    newPhone.setPhoneNumber(phonenumber);
	    
	    PhoneNumber newPhone2 = new PhoneNumber();
	    newPhone2.setPhoneKind(phonekind2);
	    newPhone2.setPhoneNumber(phonenumber2);
		
		//ServiceContact src=new ServiceContact();
		IServiceContact service= (ServiceContact) context.getBean("serviceContact");
		service.updateContact(id, fname, lname, email, newAddress, newPhone, newPhone2);
	}

}
