package com.lip6.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lip6.services.IServiceContactGroup;
import com.lip6.services.ServiceContactGroup;

@WebServlet("/AddContactToGroupServlet")
public class AddContactToGroupServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long contactId = Long.parseLong(request.getParameter("contactId"));
        long groupId = Long.parseLong(request.getParameter("groupId"));

        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        IServiceContactGroup serviceContactGroup= (ServiceContactGroup) context.getBean("serviceContactGroup");
        
        if(serviceContactGroup.addContactToGroup(contactId, groupId)) {
            System.out.println("Contact ajouté au groupe !");
        } else {
            System.out.println("Échec de l'ajout du contact au groupe.");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("menuGroup.jsp");
        dispatcher.forward(request, response);
    }
}

