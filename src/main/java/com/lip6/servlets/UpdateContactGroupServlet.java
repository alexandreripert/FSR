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
import com.lip6.services.IServiceContact;
import com.lip6.services.IServiceContactGroup;
import com.lip6.services.ServiceContact;
import com.lip6.services.ServiceContactGroup;

@WebServlet("/UpdateContactGroupServlet")
public class UpdateContactGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateContactGroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		long id=Long.parseLong(request.getParameter("id"));
		String groupname=request.getParameter("groupname");
		
		
		IServiceContactGroup servicegroup= (ServiceContactGroup) context.getBean("serviceContactGroup");
		servicegroup.updateContactGroup(id, groupname);
	}
}
