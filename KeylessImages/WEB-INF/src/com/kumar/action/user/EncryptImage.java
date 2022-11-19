/**
 * 
 */
package com.kumar.action.user;

import java.awt.image.BufferedImage;
import java.io.File;
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
import com.kumar.DAO.UserDAO;
import com.kumar.util.AlterImage;
import com.kumar.util.ImageProcess;
import com.kumar.util.Utility;
import com.kumar.util.ShiftImage;
import com.kumar.util.Image_Merge;

public class EncryptImage extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		ResultSet rs = null;
		RequestDispatcher rd=null;
		
		String root = "";
		String fileName = "";
		String path = "";
		String keyImgpath = "";
		String sievingPath = "";
		String divisionPath = "";
		String shufflingPath = "";
		
		String outFileLocation = "";
		String outFileName = "";
		
		BufferedImage img = null;
		BufferedImage img1 = null;
		BufferedImage img2 = null;
		
		String xPro = "",fileExtension="";
		int colorPixelIndex=0,imgPart=0;
		
		UserDAO userDAO = null;
		HttpSession session = request.getSession();  
		
		 
		try
		{
			
			String submit=request.getParameter("submit").trim();
			
			userDAO = UserDAO.getInstance();
			
			rs = userDAO.getImageDetails();
			
			root = request.getRealPath("");
			 
			shufflingPath = root+"\\Files\\Shuffle\\";
	    	divisionPath = root+"\\Files\\Division\\";
	    	sievingPath = root+"\\Files\\Sieving\\";
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/Resources/JSP/User/encrypt_image.jsp?no=1");
				rd.forward(request, response);
			}
			
			if(submit.equals("Siev Image"))
			{
				String []chk=request.getParameterValues("chk");
				
				if(chk==null)
				{
					rs = userDAO.getImageDetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/encrypt_image.jsp?no=1&no1=3");
					rd.forward(request, response);
				}
				else if(chk.length!=1)
				{
					rs = userDAO.getImageDetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/Resources/JSP/User/encrypt_image.jsp?no=1&no1=4");
					rd.forward(request, response);
				}
				else if(chk.length==1)
				{
					int id = Integer.parseInt(chk[0]);
					fileName = userDAO.getFileName(id);
					
					path = request.getRealPath("") +"\\Files\\Image\\" + fileName;
					
					sievingPath = request.getRealPath("") +"\\Files\\Sieving\\";
					
					System.out.println("********* Sieving Info **********");
					System.out.println("          Id : " +id);
					System.out.println("        File : " +fileName);
					System.out.println("        Path : " +path);
					System.out.println("Sieving Path : " +sievingPath);
					
					
					File file = new File(path);
					
					if(file.exists())
					{
						
						if ( session.getAttribute( "waitPage" ) == null ) 
					    {  
					    	   session.setAttribute( "waitPage", Boolean.TRUE );  
					    	   out.println( "<html><head>" );  
					    	   out.println( "<title>Please Wait...</title>" );  
					       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
					    	   out.println( "</head><body bgcolor=''>" );  
					    	   out.println( "<br><br><br>" );
					    	   out.print( "<center><img src='Resources/Images/status_processing.gif'></img><br><br>");
					    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
					    	   out.println("<font color='white' size='5'>");
					    	   out.println( "Image Sieving is in Process......  " );
					    	   out.println("</font><br>");
					    	   out.println( "Please wait....</h1></center");  
					    	   out.close();  
					    }  
						else
						{
							session.removeAttribute( "waitPage" );  
							
							/* Deleting the old files from Sieving Directory(Starts) */
							 	File f = new File(request.getRealPath("") +"\\Files\\Sieving");   
							 	
							 	String[] myFiles;      
					            if(f.isDirectory())
					            {  
					                myFiles = f.list();  
					                for (int i=0; i<myFiles.length; i++) 
					                {  
					                    File myFile = new File(f, myFiles[i]);   
					                    myFile.delete();  
					                }  
					             }  
				            /* Deleting the old files from Sieving Directory(Ends) */
							
							try 
							{
								img = ImageProcess.readImage(path);
								ImageProcess.processImage(img,sievingPath,fileName);
								
								request.setAttribute("fileName",fileName);
								rd=request.getRequestDispatcher("/Resources/JSP/User/display_sieving.jsp?no=1");
								rd.forward(request, response);
								
								System.out.println("Sieving Process Done.....");
							}
							catch (Exception e)
							{
								System.out.println("Opps,Exception in User-EncryptImage Servlet sievingImage :");
								e.printStackTrace();
							}
						}
						
						
					}
					else
					{
						rs = userDAO.getImageDetails();
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/Resources/JSP/User/encrypt_image.jsp?no=1&no1=2");
						rd.forward(request, response);
					}
					
					
					
				}
			}
			
			if(submit.equals("Divide Image"))
			{
				
				System.out.println("Inside Divide Image");
				
				fileName = request.getParameter("fileName");
				
				System.out.println("File Name : " + fileName);
				
				if ( session.getAttribute( "waitPage" ) == null ) 
			    {  
			    	   session.setAttribute( "waitPage", Boolean.TRUE );  
			    	   out.println( "<html><head>" );  
			    	   out.println( "<title>Please Wait...</title>" );  
			       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
			    	   out.println( "</head><body bgcolor=''>" );  
			    	   out.println( "<br><br><br>" );
			    	   out.print( "<center><img src='Resources/Images/status_processing.gif'></img><br><br>");
			    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
			    	   out.println("<font color='white' size='5'>");
			    	   out.println( "Image Division is in Process......  " );
			    	   out.println("</font><br>");
			    	   out.println( "Please wait....</h1></center");  
			    	   out.close();  
			    }  
				else
				{
					session.removeAttribute( "waitPage" );  
					
				/* Deleting the old files from Division Directory(Starts) */
				 	File f = new File(request.getRealPath("") +"\\Files\\Division");        
				 	String[] myFiles;      
		            if(f.isDirectory())
		            {  
		                myFiles = f.list();  
		                for (int i=0; i<myFiles.length; i++) 
		                {  
		                    File myFile = new File(f, myFiles[i]);   
		                    myFile.delete();  
		                }  
		             }  
	            /* Deleting the old files from Division Directory(Ends) */
					
					try 
					{
						path = request.getRealPath("") +"\\Files\\Sieving\\";
					    String path1 = path+"red_"+fileName;
					    String path2 = path+"green_"+fileName;
					    String path3 = path+"blue_"+fileName;
					    
					    divisionPath = request.getRealPath("") +"\\Files\\Division\\";
					    
					    BufferedImage redImg = AlterImage.readImage(path1);
					    BufferedImage greenImg = AlterImage.readImage(path2);
					    BufferedImage blueImg = AlterImage.readImage(path3);
					    // Divide Red,Green and Blue Img into 2-2 parts
					    
					    AlterImage.splitRedImage(redImg, divisionPath, fileName);
					    AlterImage.splitGreenImage(greenImg, divisionPath, fileName);
					    AlterImage.splitBlueImage(blueImg, divisionPath, fileName);
					    
					    request.setAttribute("fileName",fileName);
						rd=request.getRequestDispatcher("/Resources/JSP/User/display_division.jsp?no=1");
						rd.forward(request, response);
					    
					    System.out.println("Division Process Done.....");
					    
					    
					} 
					catch (Exception e) 
					{
						System.out.println("Opps,Exception in User-EncryptImage Servlet divideImage :");
						e.printStackTrace();
					}
				}
				
			}
			
// Image Shuffling Action (Starts)
			
			if(submit.equals("Shuffle Image"))
			{
				System.out.println("Inside Shuffle Image Section !!!!!");
				
				fileName = request.getParameter("fileName");
				
				System.out.println("File Name : " + fileName);
				
				if ( session.getAttribute( "waitPage" ) == null ) 
			    {  
			    	   session.setAttribute( "waitPage", Boolean.TRUE );  
			    	   out.println( "<html><head>" );  
			    	   out.println( "<title>Please Wait...</title>" );  
			       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
			    	   out.println( "</head><body bgcolor=''>" );  
			    	   out.println( "<br><br><br>" );
			    	   out.print( "<center><img src='Resources/Images/status_processing.gif'></img><br><br>");
			    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
			    	   out.println("<font color='white' size='5'>");
			    	   out.println( "Image Shuffling is in Process......  " );
			    	   out.println("</font><br>");
			    	   out.println( "Please wait....</h1></center");  
			    	   out.close();  
			    }  
				else
				{
					session.removeAttribute( "waitPage" );  
					System.out.println("Main Block : Image Shuffling Process.");
					
					/* Deleting the old files from Shuffle Directory(Starts) */
					 	File f = new File(request.getRealPath("") +"\\Files\\Shuffle");        
					 	String[] myFiles;      
			            if(f.isDirectory())
			            {  
			                myFiles = f.list();  
			                for (int i=0; i<myFiles.length; i++) 
			                {  
			                    File myFile = new File(f, myFiles[i]);   
			                    myFile.delete();  
			                }  
			             }  
		           /* Deleting the old files from Shuffle Directory(Ends) */

// ######### Shuffling The Image (Starts) #########
			            
				       try 
				       {
				
				    	 shufflingPath = root+"\\Files\\Shuffle\\";
				    	 divisionPath = root+"\\Files\\Division\\";
				    	 //keyImgpath = request.getRealPath("") +"\\Files\\Image\\" + fileName;
				    	 keyImgpath = request.getRealPath("") +"\\Files\\Image\\"+fileName;

				 		 img2 = ImageProcess.readImage(keyImgpath); //Key Image
				 		 
				 		 xPro ="F"; //F = Forward
				 		 if(fileName!="")
				 			fileExtension=fileName.substring(fileName.lastIndexOf(".")+1,fileName.lastIndexOf(""));//bmp
				 		    fileExtension = "."+fileExtension;//.bmp
				 		
				 		 String inputFile = "";
				 		 String outputFile = "";
				 		 String sPath = "";
				 		
				 /* ************************** Green Image Encryption (Starts) ************************** */	
				 		
				 /* Shuffling Green Image (Starts)*/
				 		
				 		//Shuffling Green Image Part1(Starts)
				 		for(int i=0;i<4;i++)
				 		{
				 		
				 			if(i == 0)
				 			{
				 				sPath = divisionPath;
				 				inputFile = "green_div1_"+fileName;
				 				outputFile = "pre_SG1"+fileExtension;
				 			}
				 			else
				 			{
				 				sPath = shufflingPath;
				 				inputFile = "SG1"+fileExtension;
				 				outputFile = "pre_SG1"+fileExtension;
				 			}
				 			
				 				// Column Shifting
				 			//img1 = ImageProcess.readImage(sPath+"green_div1_"+fileName);
				 			img1 = ImageProcess.readImage(sPath+inputFile);
				 			
				 			colorPixelIndex = 1; // 0(Red),1(Green),2(Blue)
				 			imgPart = 1;//1 = red1 ,2 = red2
				 			
				 			ShiftImage.coloumShift(img1,img2,xPro,colorPixelIndex,shufflingPath,imgPart,fileExtension);
				 			
				 				// Row Shifting
				 			//img = ImageProcess.readImage(sPath+"pre_SG1.bmp");
				 			img = ImageProcess.readImage(shufflingPath+outputFile);
				 			ShiftImage.rowShift(img,img2, xPro, colorPixelIndex,shufflingPath,imgPart, fileExtension);
				 		}
				 		//Shuffling Green Image Part1(Ends)
				 			
				 			
				 		//Shuffling Green Image Part2(Starts)
				 		for(int i=0;i<4;i++)
				 		{
				 		
				 			if(i == 0)
				 			{
				 				sPath = divisionPath;
				 				inputFile = "green_div2_"+fileName;
				 				outputFile = "pre_SG2"+fileExtension;
				 			}
				 			else
				 			{
				 				sPath = shufflingPath;
				 				inputFile = "SG2"+fileExtension;
				 				outputFile = "pre_SG2"+fileExtension;
				 			}
				 			// Column Shifting
				 			img1 = ImageProcess.readImage(sPath+inputFile);
				 			colorPixelIndex = 1; // 0(Red),1(Green),2(Blue)
				 			imgPart = 2;//1 = red1 ,2 = red2
				 			
				 			ShiftImage.coloumShift(img1,img2, xPro, colorPixelIndex,shufflingPath,imgPart, fileExtension);
				 			
				 			// Row Shifting
				 			img = ImageProcess.readImage(shufflingPath+outputFile);
				 			ShiftImage.rowShift(img,img2, xPro, colorPixelIndex,shufflingPath,imgPart, fileExtension);
				 		}
				 		//Shuffling Green Image Part2(Ends)
				 		
				 /* Shuffling Green Image (Ends)*/
				 		
				 /* ************************** Green Image Encryption (Ends) ************************** */	
				 		
				 		
				 /* ************************** Red Image Encryption (Starts) ************************** */	
				 		
				 /* Shuffling Red Image (Starts)*/
				 				
				 				//Shuffling Red Image Part1(Starts)
				 				for(int i=0;i<4;i++)
				 				{
				 				
				 					if(i == 0)
				 					{
				 						sPath = divisionPath;
				 						inputFile = "red_div1_"+fileName;
				 						outputFile = "pre_SR1"+fileExtension;
				 					}
				 					else
				 					{
				 						sPath = shufflingPath;
				 						inputFile = "SR1"+fileExtension;
				 						outputFile = "pre_SR1"+fileExtension;
				 					}
				 					
				 						// Column Shifting
				 					//img1 = ImageProcess.readImage(sPath+"green_div1_"+fileName);
				 					img1 = ImageProcess.readImage(sPath+inputFile);
				 					
				 					colorPixelIndex = 0; // 0(Red),1(Green),2(Blue)
				 					imgPart = 1;//1 = red1 ,2 = red2
				 					
				 					ShiftImage.coloumShift(img1,img2, xPro, colorPixelIndex,shufflingPath, imgPart, fileExtension);
				 					
				 						// Row Shifting
				 					//img = ImageProcess.readImage(sPath+"pre_SG1.bmp");
				 					img = ImageProcess.readImage(shufflingPath+outputFile);
				 					ShiftImage.rowShift(img,img2, xPro, colorPixelIndex, shufflingPath, imgPart, fileExtension);
				 				}
				 				//Shuffling Red Image Part1(Ends)
				 					
				 					
				 				//Shuffling Red Image Part2(Starts)
				 				for(int i=0;i<4;i++)
				 				{
				 				
				 					if(i == 0)
				 					{
				 						sPath = divisionPath;
				 						inputFile = "red_div2_"+fileName;
				 						outputFile = "pre_SR2"+fileExtension;
				 					}
				 					else
				 					{
				 						sPath = shufflingPath;
				 						inputFile = "SR2"+fileExtension;
				 						outputFile = "pre_SR2"+fileExtension;
				 					}
				 					// Column Shifting
				 					img1 = ImageProcess.readImage(sPath+inputFile);
				 					colorPixelIndex = 0; // 0(Red),1(Green),2(Blue)
				 					imgPart = 2;//1 = red1 ,2 = red2
				 					
				 					ShiftImage.coloumShift(img1,img2, xPro, colorPixelIndex,shufflingPath,imgPart, fileExtension);
				 					
				 					// Row Shifting
				 					img = ImageProcess.readImage(shufflingPath+outputFile);
				 					ShiftImage.rowShift(img,img2, xPro, colorPixelIndex, shufflingPath, imgPart, fileExtension);
				 				}
				 				//Shuffling Red Image Part2(Ends)
				 				
				 /* Shuffling Red Image (Ends)*/
				 				
				 /* ************************** Red Image Encryption (Ends) ************************** */	
				 		

				 /* ************************** Blue Image Encryption (Starts) ************************** */	
				 				
				 /* Shuffling Blue Image (Starts)*/
				 								
				 				//Shuffling Blue Image Part1(Starts)
				 				for(int i=0;i<4;i++)
				 				{
				 				
				 					if(i == 0)
				 					{
				 						sPath = divisionPath;
				 						inputFile = "blue_div1_"+fileName;
				 						outputFile = "pre_SB1"+fileExtension;
				 					}
				 					else
				 					{
				 						sPath = shufflingPath;
				 						inputFile = "SB1"+fileExtension;
				 						outputFile = "pre_SB1"+fileExtension;
				 					}
				 					
				 						// Column Shifting
				 					//img1 = ImageProcess.readImage(sPath+"green_div1_"+fileName);
				 					img1 = ImageProcess.readImage(sPath+inputFile);
				 					
				 					colorPixelIndex = 2; // 0(Red),1(Green),2(Blue)
				 					imgPart = 1;//1 = red1 ,2 = red2
				 					
				 					ShiftImage.coloumShift(img1,img2, xPro, colorPixelIndex,shufflingPath, imgPart,fileExtension);
				 					
				 						// Row Shifting
				 					//img = ImageProcess.readImage(sPath+"pre_SG1.bmp");
				 					img = ImageProcess.readImage(shufflingPath+outputFile);
				 					ShiftImage.rowShift(img,img2, xPro, colorPixelIndex,shufflingPath,imgPart, fileExtension);
				 				}
				 				//Shuffling Blue Image Part1(Ends)
				 					
				 					
				 				//Shuffling Blue Image Part2(Starts)
				 				for(int i=0;i<4;i++)
				 				{
				 				
				 					if(i == 0)
				 					{
				 						sPath = divisionPath;
				 						inputFile = "blue_div2_"+fileName;
				 						outputFile = "pre_SB2"+fileExtension;
				 					}
				 					else
				 					{
				 						sPath = shufflingPath;
				 						inputFile = "SB2"+fileExtension;
				 						outputFile = "pre_SB2"+fileExtension;
				 					}
				 					// Column Shifting
				 					img1 = ImageProcess.readImage(sPath+inputFile);
				 					colorPixelIndex = 2; // 0(Red),1(Green),2(Blue)
				 					imgPart = 2;//1 = red1 ,2 = red2
				 					
				 					ShiftImage.coloumShift(img1,img2, xPro, colorPixelIndex,shufflingPath,imgPart, fileExtension);
				 					
				 					// Row Shifting
				 					img = ImageProcess.readImage(shufflingPath+outputFile);
				 					ShiftImage.rowShift(img,img2, xPro, colorPixelIndex, shufflingPath, imgPart, fileExtension);
				 				}
				 				//Shuffling Blue Image Part2(Ends)
				 								
				 /* Shuffling Blue Image (Ends)*/
				 								
				 /* ************************** Blue Image Encryption (Ends) ************************** */	
				 			
						
			    // Shuffling Process Ends Here
						
					request.setAttribute("fileName",fileName);
					rd=request.getRequestDispatcher("/Resources/JSP/User/display_shuffled.jsp?no=1");
					rd.forward(request, response);
						
				   System.out.println("Image Shuffling Process Done successfully ..!");
				   		
				       }
				       catch(Exception e)
				       {
				    	   System.out.println("Opps,Exception in User-EncryptImage Servlet==>Shuffle Image Section :");
						   e.printStackTrace();
				       }
				}
				
			}
// ######### Shuffling The Image (Ends) #########
			
			
// Generating The Random Shares (Starts)
			
			if(submit.equals("Generate Random Share"))
			{
				
				System.out.println("Inside Generate Random Share Section.");
				
				fileName = request.getParameter("fileName");
				
				if(fileName!="")
		 			fileExtension=fileName.substring(fileName.lastIndexOf(".")+1,fileName.lastIndexOf(""));//bmp
		 		    fileExtension = "."+fileExtension;//.bmp
				
				System.out.println("File Name : " + fileName);
				
				if ( session.getAttribute( "waitPage" ) == null ) 
			    {  
			    	   session.setAttribute( "waitPage", Boolean.TRUE );  
			    	   out.println( "<html><head>" );  
			    	   out.println( "<title>Please Wait...</title>" );  
			       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
			    	   out.println( "</head><body bgcolor=''>" );  
			    	   out.println( "<br><br><br>" );
			    	   out.print( "<center><img src='Resources/Images/status_processing.gif'></img><br><br>");
			    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
			    	   out.println("<font color='white' size='5'>");
			    	   out.println( "Random Share Generation  is in Process......  " );
			    	   out.println("</font><br>");
			    	   out.println( "Please wait....</h1></center");  
			    	   out.close();  
			    }  
				else
				{
					session.removeAttribute( "waitPage" );  
					
				/* Deleting the old files from RandomShare Directory(Starts) */
				 	File f = new File(request.getRealPath("") +"\\Files\\RandomShare");        
				 	String[] myFiles;      
		            if(f.isDirectory())
		            {  
		                myFiles = f.list();  
		                for (int i=0; i<myFiles.length; i++) 
		                {  
		                    File myFile = new File(f, myFiles[i]);   
		                    myFile.delete();  
		                }  
		             }  
	            /* Deleting the old files from RandomShare Directory(Ends) */
					
					try 
					{
						// Generating The Random Shares
						
						// Getting The Random Share1
						outFileLocation = root+"\\Files\\RandomShare\\";
						outFileName = "Share1_"+fileName;
						
						img = ImageProcess.readImage(shufflingPath+"SR1"+fileExtension);
						img1 = ImageProcess.readImage(shufflingPath+"SG1"+fileExtension);
						img2 = ImageProcess.readImage(shufflingPath+"SB1"+fileExtension);
						
						Image_Merge.mergeImage(img, img1,img2,outFileLocation,outFileName);
						
						// Getting The Random Share2
						outFileName = "Share2_"+fileName;
						
						img = ImageProcess.readImage(shufflingPath+"SR2"+fileExtension);
						img1 = ImageProcess.readImage(shufflingPath+"SG2"+fileExtension);
						img2 = ImageProcess.readImage(shufflingPath+"SB2"+fileExtension);
						Image_Merge.mergeImage(img,img1,img2,outFileLocation,outFileName);
						
					    System.out.println("Random Share Generation Process Done Successfully .....");
					    
					    request.setAttribute("fileName",fileName);
						rd=request.getRequestDispatcher("/Resources/JSP/User/display_randomshares.jsp?no=1");
						rd.forward(request,response);
					    
					    
					} 
					catch (Exception e) 
					{
						System.out.println("Opps,Exception in User-EncryptImage Servlet==>Generate Random Share :");
						e.printStackTrace();
					}
				}
				
			}
			// Generating The Random Shares (Ends)
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User EncryptImage Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in User EncryptImage Servlet......"+e);
		}
	}
}
