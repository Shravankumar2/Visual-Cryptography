/**
 * @author Ramesh V
*/
package com.user.action;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.misc.Cleaner;


import com.dao.AdminDAO;




@SuppressWarnings("serial")
public class SearchImage extends HttpServlet 
{
	static Thread t;
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		System.out.println("********SearchImage************");
		//PrintWriter out1 = response.getWriter();
		ResultSet rs = null;
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		boolean flag = false;
		int imageId = 0;
		
		String fileName="",root1 = "",filePath = "",filePath2 = "",root2 = "",root3="",filePath3="";	
		long start=0,end=0;
		
		try
		{
			
			
			//RANSCAR ranscar=new RANSCAR();
		
		   //long startTime = System.currentTimeMillis();
		   start = System.nanoTime();
		 
		   if( session.getAttribute( "waitPage" ) == null ) 
		   {  
			   PrintWriter out = response.getWriter();
		 
	    	   session.setAttribute( "waitPage", Boolean.TRUE );  
	    	   out.println( "<html><head>" );  
	    	   out.println( "<title>Please Wait...</title>" );  
	       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
	    	   out.println( "</head><body bgcolor=''>" );
	    	   out.println("<section id='content' style='position: absolute;top:25;left:100px;width: 650px;'>");
	    	   out.println("<center>");
	    	   //out.println("<br>");
	    	   out.println("<font color='blue' size='5'>");
	    	   out.println( "Wait Please...<br>" );
	    	   out.println( "Image Search Process is in Progress.....<br><br>" );
	    	   out.print( "<img src='res/images/spinner.gif'></img><br><br>");
	    	   out.println("<font color='red' size='5'>");
	    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
	    	   out.println("</font><br>");
	    	   out.println("<font color='green' size='5'>");
	    	   out.println( "Images Are Getting Searched..... " );
	    	   out.println("</font><br>");
	    	   out.println( "Please wait....</h1><br>");  
	    	   out.println("</center>");
	    	   out.println("</section>");
	    	   out.close();  
		     }
			 else
			 {
				session.removeAttribute( "waitPage" );
				
				try
				{
					System.out.println("-----------else -----");
					 root1 = request.getRealPath("")+"\\File\\uploadedImg\\";
					 fileName = (String) session.getAttribute("img_name");//input image name
					 filePath = root1+fileName;//input image path
					 //Selected Image FilePath : F:\October_2015_Workspace\ANNF_FeatureMatch_OpenCV_1\File\ uploadedImg\Lion.jpg;
					 System.out.println("Selected Image FilePath : " + filePath);					
					//Getting Distance With All DB Files
					 root2 = request.getRealPath("")+"\\File\\search\\";
					 
					 
					 rs = AdminDAO.getImage();
					 while(rs.next())
					 {		System.out.println("-----------while -----");				
						imageId = rs.getInt(1);
						fileName = rs.getString(2);
						filePath2 = root2+fileName;
						
						//Image FilePath2 : F:\October_2015_Workspace\ANNF_FeatureMatch_OpenCV_1\File\search\1_dog_ball.jpg
						System.out.println("Image FilePath2 : " + filePath2);
						   //distance = histogram.compare(filePath, filePath2);
						   String fwritepath=request.getRealPath("")+"//matchedImages//"+fileName;
						    //matchedImages path  : F:\October_2015_Workspace\ANNF_FeatureMatch_OpenCV_1//matchedImages//1_dog_ball.jpg
						   
						    
						   
						   
						   //image Rotation Opencv
						  //  SendImageFnameToRotation(filePath);
						    
						    System.out.println("matchedImages path  : "+fwritepath);
						   // SendImageFname(filePath,filePath2,imageId);
						    SendImageFname2(filePath,filePath2,imageId,fwritepath);
						    flag=true;  					    
					 }				 
					 if(flag)
					 {
						
						 Thread.sleep(70000);
						
						rd=request.getRequestDispatcher("/res/jsp/user/view_file.jsp");
						rd.forward(request, response);
						
					 }
					 else
					 {
						rd=request.getRequestDispatcher("/res/jsp/user/imageSearch.jsp?no=0&no1=2");
						rd.forward(request, response);
					 }
					
				
					 
				}
				catch (Exception e)
				{
					System.out.println("Opps,Exception In SearchImage Servlet Main Block : " );
					e.printStackTrace();
					rd=request.getRequestDispatcher("/res/jsp/user/imageSearch.jsp?no=0&no1=2");
					rd.forward(request, response);
				}
		   
			 }
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in SearchImage Servlet : ");
			e.printStackTrace();
			//out.println("Opps's Error is in SearchImage Servlet : "+e);
			rd=request.getRequestDispatcher("/res/jsp/user/imageSearch.jsp?no=0&no1=2");
			try
			{
				rd.forward(request, response);
			} 
			catch (ServletException e1)
			{
				e1.printStackTrace();
			}
		}
		
		
		
		
	}
	public static void SendImageFname(String filepath,String filepath2,int imgid)
	{
		Socket client;
		SearchImage x=new SearchImage();
		try 
		{
			System.out.println("======histogram======>  send");
			client = new Socket("localhost", 9500);
			DataOutputStream dos=new  DataOutputStream(client.getOutputStream());			
			dos.writeInt(imgid);
			dos.writeUTF(filepath);
			dos.writeUTF(filepath2);   
			dos.writeBoolean(true);
			dos.flush();
			dos.close();
			client.close();				
			System.out.println("======================================");
			
			
		} 
		catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
			
		
	}
	
	
	
	public static void SendImageFname2(String filepath,String filepath2,int imgid,String fwritepath)
	{
		Socket client;
		try 
		{
			System.out.println("=====homography=======>  send");
			client = new Socket("localhost", 8660);
			DataOutputStream dos=new  DataOutputStream(client.getOutputStream());
			dos.writeInt(imgid);
			dos.writeUTF(filepath);
			dos.writeUTF(filepath2);
			dos.writeUTF(fwritepath);
			dos.writeBoolean(true);
			dos.flush();
			dos.close();
			client.close();
		} 
		catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	}
	public static void SendImageFnameToRotation(String fname)
	{
		Socket client;
		try
		{
			System.out.println("=====Roation =======>  send");
			client=new Socket("localhost",8690);
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			dos.writeUTF(fname);
			dos.writeBoolean(true);
			dos.flush();
			dos.close();
			client.close();
			
		}
		catch (UnknownHostException e)
		{
			
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	
}
