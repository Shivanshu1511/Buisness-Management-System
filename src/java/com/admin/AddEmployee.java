package com.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.connection.DatabaseConnection;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class AddProducts
 */
@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try{
                       String name=request.getParameter("emp_name");
                       String mobile=request.getParameter("mobile");
                       String email=request.getParameter("email");
                       String designation=request.getParameter("designation");
                       int isActive=1;
                       String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                       int addEmployee=DatabaseConnection.insertUpdateFromSqlQuery("insert into tblemployee(name, mobile, email, designation) values('"
								+ name + "','" + mobile + "','" + email + "','" + designation + "')");
                       if(addEmployee>0)
                       {
                       String message="Employee Add Successfully";
				session.setAttribute("message", message);
				response.sendRedirect("admin-add-employee.jsp");
                       }
                       else
                       {
                        String message="Employee Add Failed Try Again";
				session.setAttribute("message", message);
				response.sendRedirect("admin-add-employee.jsp");
                       }
                }
                catch(Exception e)
                {
                String message="Error : Something went wrong";
				session.setAttribute("message", message);
				response.sendRedirect("admin-add-employee.jsp");
                }
	}
}
