/**
 * 
 */
package com.kumar.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kumar.DAO.AdminDAO;
import com.kumar.util.Utility;

/**
 * @author Munna Kumar Singh
 */
public class ListUser extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		ResultSet rs = null;
		RequestDispatcher rd=null;
		HttpSession session = null;
		
		try
		{
			String submit=request.getParameter("submit").trim();
			
			AdminDAO adminDAO = AdminDAO.getInstance();
			rs = adminDAO.getUsers();
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/Resources/JSP/Admin/users.jsp?no=1");
				rd.forward(request, response);
			}
			if(submit.equals("Add"))
			{
				if(Utility.parse1(request.getParameter("add1")).equals("YES"))
				{
					String username = request.getParameter("username");
					
					String password= request.getParameter("password");
					String name = request.getParameter("name");
					String email = request.getParameter("email");
					String dept = request.getParameter("dept");
					String designation = request.getParameter("designation");
					String address = request.getParameter("address");
					String city = request.getParameter("city");
					String phone = request.getParameter("phone");
					String mobile = request.getParameter("mobile");
					
					boolean result=adminDAO.checkUserExistence(username);
					if(!result)
					{
						 result = adminDAO.addUserDetails(username,password,name,email,Integer.parseInt(dept),Integer.parseInt(designation),address,city,phone,mobile);
						 if(result)
						 {
							 request.setAttribute("rs", rs);
							 rd=request.getRequestDispatcher("/Resources/JSP/Admin/users.jsp?no=1&no1=1");
							 rd.forward(request, response);
						 }
						else
						{
							rd=request.getRequestDispatcher("/Resources/JSP/Admin/users.jsp?no=2&no1=2");
							rd.forward(request, response);
						}
					}
					else
					{
						rd=request.getRequestDispatcher("/Resources/JSP/Admin/users.jsp?no=2&no1=1");
						rd.forward(request, response);
					}
				}
				else
				{
					rd=request.getRequestDispatcher("/Resources/JSP/Admin/users.jsp?no=2");
					rd.forward(request, response);
				}
			}
			
			if(submit.equals("Edit"))
			{
				String []chk=request.getParameterValues("chk");
				
				if(Utility.parse1(request.getParameter("edit1")).equals("YES"))
				{
					String s[]=new String[11];
					s[0]=request.getParameter("id");
					s[1]=request.getParameter("username");
					s[2]=request.getParameter("password");
					s[3]=request.getParameter("name");
					s[4]=request.getParameter("dept");
					s[5]=request.getParameter("designation");
					s[6]=request.getParameter("address");
					s[7]=request.getParameter("city");
					s[8]=request.getParameter("phone");
					s[9]=request.getParameter("mobile");
					s[10]=request.getParameter("email");
					
					adminDAO.editUserDetails(s);
					
					rs = adminDAO.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/Admin/users.jsp?no=1&no1=2");
					rd.forward(request, response);
				}
				else if(chk==null)
				{
					rs = adminDAO.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/Admin/users.jsp?no=1&no1=3");
					rd.forward(request, response);
				}
				else if(chk.length!=1)
				{
					rs = adminDAO.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/Admin/users.jsp?no=1&no1=4");
					rd.forward(request, response);
				}
				else if(chk.length==1)
				{
					rs = adminDAO.getSpecificUserDetails(Integer.parseInt(chk[0]));
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/Admin/users.jsp?no=3");
					rd.forward(request, response);
				}
			}
			
			if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null)
				{
					rs = adminDAO.getUsers();
					
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/Admin/users.jsp?no=1&no1=3");
					rd.forward(request, response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						adminDAO.deleteUserDetails(Integer.parseInt(chk[i]));
					}
					rs = adminDAO.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/Admin/users.jsp?no=1&no1=5");
					rd.forward(request, response);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin ListUser Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in Admin ListUser Servlet......"+e);
		}
	}
}
