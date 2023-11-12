package com.lip6.servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lip6.entities.Contact;
import com.lip6.services.IServiceContactGroup;
import com.lip6.services.ServiceContactGroup;

@WebServlet("/ListContactsByGroupServlet")
public class ListContactsByGroupServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long groupId = Long.parseLong(request.getParameter("groupId"));
        
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        IServiceContactGroup serviceContactGroup= (ServiceContactGroup) context.getBean("serviceContactGroup");
        
        Set<Contact> contacts = serviceContactGroup.listContactsByGroup(groupId);

        for (Contact contact : contacts) {
            System.out.println(contact.getFirstName() + " " + contact.getLastName());
        }
        
        request.setAttribute("contacts", contacts); // Ajouter les contacts à la requête
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("listContacts.jsp");
        dispatcher.forward(request, response);
    }
}
