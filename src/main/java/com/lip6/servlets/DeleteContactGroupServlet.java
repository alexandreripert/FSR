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

@WebServlet("/DeleteContactGroupServlet")
public class DeleteContactGroupServlet extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	
    public DeleteContactGroupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long id=Long.parseLong(request.getParameter("id"));
		
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		//ServiceContact src=new ServiceContact();
		IServiceContactGroup serviceGroup= (ServiceContactGroup) context.getBean("serviceContactGroup");
		serviceGroup.deleteContactGroup(id);
		
		 RequestDispatcher dispatcher = request.getRequestDispatcher("menuGroup.jsp");
         dispatcher.forward(request, response);
	}

}
