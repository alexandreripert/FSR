package com.lip6.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lip6.entities.ContactGroup;
import com.lip6.services.IServiceContact;
import com.lip6.services.IServiceContactGroup;
import com.lip6.services.ServiceContactGroup;

@WebServlet("/AddContactGroupServlet")
public class AddContactGroupServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IServiceContact serviceContactGroup;
	
	public AddContactGroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			//long id=Long.parseLong(request.getParameter("id"));
				String groupname=request.getParameter("groupname");

				ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
				
				String[] allBeanNames = context.getBeanDefinitionNames();
		        for(String beanName : allBeanNames) {
		            System.out.println(beanName + "******************");
		        }
		        
		        ContactGroup cg= (ContactGroup) context.getBean("ContactGroup");
	        	cg.setGroupName(groupname);

	        	IServiceContactGroup serviceGroup= (ServiceContactGroup) context.getBean("serviceContactGroup");
	            
	            
	            serviceGroup.createContactGroup(cg);
		}
	}

