/**
 * 
 */
package com.kumar.action.user;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.kumar.DAO.UserDAO;
import com.kumar.util.ImageProcess;
import com.kumar.util.Image_Merge;
import com.kumar.util.MergeImage_RRnGGnBB;
import com.kumar.util.ShiftImage;

public class DecryptImage extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		ResultSet rs = null;
		RequestDispatcher rd=null;
		boolean flag = false;
		
		String root = "";
		String fileName = "";
		String path = "";
		String keyImgpath = "";
		String sievingPath = "";
		String divisionPath = "";
		String shufflingPath = "";
		
		String srcfilePath = "";
		String outDestinationPath="";
		
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
			root = request.getRealPath("");
			
			/* Deleting the old files from Decryption Directory(Starts) */
			 	File f = new File(request.getRealPath("") +"\\Files\\Decryption");        
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
			
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart)
 			{
 				FileItemFactory factory = new DiskFileItemFactory();
 	            ServletFileUpload upload = new ServletFileUpload(factory);
 	            
 	            try 
 	            {
 	            	List items = upload.parseRequest(request);
  	                Iterator iterator = items.iterator();
  	                while (iterator.hasNext()) 
  	                {
  	                	FileItem item = (FileItem) iterator.next();
  	                	
  	                	
	                    if (item.isFormField()) 
	                    {
	                    	
	                    	
	                    }
	                    else
	                    {
	                    	 fileName = item.getName();
	                    	 if(fileName!="")
		                    		fileExtension=fileName.substring(fileName.lastIndexOf(".")+1,fileName.lastIndexOf(""));//bmp
	                    	        fileExtension = "."+fileExtension;//.bmp
			                 //filepath = request.getRealPath("")+"\\Files\\Encryption\\"+fileName;
	                    	 path = root+"\\Files\\Decryption\\"+fileName;
			  	             File f1=new File(path);
			  	             item.write(f1);
			  	             flag = true;
			  	             
	                    }
	                        
  	                }
  	                
  	              System.out.println("Input Files For Decryption are Uploaded Successfully......");
	  	        //session.setAttribute("file_ext",fileExtension);
  	                
				}
 	            catch (Exception e)
 	            {
					System.out.println("Opps,Exception While Uploading The Input Files For Decryption : " );
					e.printStackTrace();
				}
 			}
			
/* Decrypting  The Random Shares (Starts) */
			
			if(flag)
			{
				
// Getting It Back From Random Shares
				
				// Getting It Back From Random Share1
				
				// Overiding The File Name
				String[] data = fileName.split("_");
				if(data.length >0)
				{
					fileName = data[1];
				}
				
				srcfilePath = root+"\\Files\\Decryption\\";
				outDestinationPath = root+"\\Files\\Decryption\\";
				keyImgpath = request.getRealPath("") +"\\Files\\Image\\"+fileName;
				
				// ############# Getting It Back From Random Shares (Starts) #############
				
				// Getting It Back From Random Share1
						outFileName="1_img"+fileExtension;
						
						System.out.println("---------------------------------");
						System.out.println("Path : " +srcfilePath+"share1"+fileExtension);
						System.out.println("---------------------------------");
						//img = ImageProcess.readImage(srcfilePath+"share1"+fileExtension);
						img = ImageProcess.readImage(srcfilePath+"Share1_"+fileName);
						ImageProcess.processImage(img,outDestinationPath,outFileName);
						
				// Getting It Back From Random Share2
						outFileName="2_img"+fileExtension;
						img = ImageProcess.readImage(srcfilePath+"Share2_"+fileName);
						ImageProcess.processImage(img,outDestinationPath,outFileName);
						
			// ****************** Image Decryption (Starts) ****************** 		
				
						img2 = ImageProcess.readImage(keyImgpath); //Key Image
						xPro ="R"; //F = Forward
						//fileName = "face1.bmp";
						
						String inputFile = "";
						String outputFile = "";
						String sPath = "";
						
			// Re-Shuffling The Green Image (Starts)
						
						
				// Re-Shuffling Green Image Part1(Starts)
						
						colorPixelIndex = 1; // 0(Red),1(Green),2(Blue)
						imgPart = 1;//1 = red1 ,2 = red2
						
						for(int i=0;i<4;i++)
						{
						
							if(i == 0)
							{
								inputFile = "green_1_img"+fileExtension;
								outputFile = "pre_RSG1"+fileExtension;
							}
							else
							{
								inputFile = "RSG1"+fileExtension;
								outputFile = "pre_RSG1"+fileExtension;
							}
							
							img = ImageProcess.readImage(outDestinationPath+inputFile);
							ShiftImage.rowShift(img,img2, xPro,colorPixelIndex,outDestinationPath,imgPart,fileExtension);
							img = ImageProcess.readImage(outDestinationPath+outputFile);
							ShiftImage.coloumShift(img,img2, xPro, colorPixelIndex,outDestinationPath,imgPart, fileExtension);
						}
						
				// Re-Shuffling Green Image Part1(Ends)
						
				
				// Re-Shuffling Green Image Part2(Starts)
						
						colorPixelIndex = 1; // 0(Red),1(Green),2(Blue)
						imgPart = 2;//1 = red1 ,2 = red2
						
						for(int i=0;i<4;i++)
						{
						
							if(i == 0)
							{
								inputFile = "green_2_img"+fileExtension;
								outputFile = "pre_RSG2"+fileExtension;
							}
							else
							{
								inputFile = "RSG2"+fileExtension;
								outputFile = "pre_RSG2"+fileExtension;
							}
							
							img = ImageProcess.readImage(outDestinationPath+inputFile);
							ShiftImage.rowShift(img,img2, xPro,colorPixelIndex,outDestinationPath,imgPart,fileExtension);
							img = ImageProcess.readImage(outDestinationPath+outputFile);
							ShiftImage.coloumShift(img,img2, xPro, colorPixelIndex,outDestinationPath,imgPart, fileExtension);
						}
						
				// Re-Shuffling Green Image Part2(Ends)


			// Re-Shuffling The Green Image(Ends)
			// ------------------------------------------------------------------------------

			// Re-Shuffling The Red Image (Starts)
						
						
						// Re-Shuffling Red Image Part1(Starts)
								
								colorPixelIndex = 0; // 0(Red),1(Green),2(Blue)
								imgPart = 1;//1 = red1 ,2 = red2
								
								for(int i=0;i<4;i++)
								{
								
									if(i == 0)
									{
										inputFile = "red_1_img"+fileExtension;
										outputFile = "pre_RSR1"+fileExtension;
									}
									else
									{
										inputFile = "RSR1"+fileExtension;
										outputFile = "pre_RSR1"+fileExtension;
									}
									
									img = ImageProcess.readImage(outDestinationPath+inputFile);
									ShiftImage.rowShift(img,img2, xPro,colorPixelIndex,outDestinationPath,imgPart,fileExtension);
									img = ImageProcess.readImage(outDestinationPath+outputFile);
									ShiftImage.coloumShift(img,img2, xPro, colorPixelIndex,outDestinationPath,imgPart, fileExtension);
								}
								
						// Re-Shuffling Red Image Part1(Ends)
								
						
						// Re-Shuffling Red Image Part2(Starts)
								
								colorPixelIndex = 0; // 0(Red),1(Green),2(Blue)
								imgPart = 2;//1 = red1 ,2 = red2
								
								for(int i=0;i<4;i++)
								{
								
									if(i == 0)
									{
										inputFile = "red_2_img"+fileExtension;
										outputFile = "pre_RSR2"+fileExtension;
									}
									else
									{
										inputFile = "RSR2"+fileExtension;
										outputFile = "pre_RSR2"+fileExtension;
									}
									
									img = ImageProcess.readImage(outDestinationPath+inputFile);
									ShiftImage.rowShift(img,img2, xPro,colorPixelIndex,outDestinationPath,imgPart,fileExtension);
									img = ImageProcess.readImage(outDestinationPath+outputFile);
									ShiftImage.coloumShift(img,img2, xPro, colorPixelIndex,outDestinationPath,imgPart, fileExtension);
								}
								
						// Re-Shuffling Red Image Part2(Ends)


			// Re-Shuffling The Red Image (Ends)
						
			// ------------------------------------------------------------------------------
								
			// Re-Shuffling The Blue Image (Starts)
								
								
						// Re-Shuffling Blue Image Part1(Starts)
										
								colorPixelIndex = 2; // 0(Red),1(Green),2(Blue)
								imgPart = 1;//1 = red1 ,2 = red2
								
								for(int i=0;i<4;i++)
								{
								
									if(i == 0)
									{
										inputFile = "blue_1_img"+fileExtension;
										outputFile = "pre_RSB1"+fileExtension;
									}
									else
									{
										inputFile = "RSB1"+fileExtension;
										outputFile = "pre_RSB1"+fileExtension;
									}
									
									img = ImageProcess.readImage(outDestinationPath+inputFile);
									ShiftImage.rowShift(img,img2, xPro,colorPixelIndex,outDestinationPath,imgPart,fileExtension);
									img = ImageProcess.readImage(outDestinationPath+outputFile);
									ShiftImage.coloumShift(img,img2, xPro, colorPixelIndex,outDestinationPath,imgPart, fileExtension);
								}
								
						// Re-Shuffling Blue Image Part1(Ends)
								
						
						// Re-Shuffling Blue Image Part2(Starts)
								
								colorPixelIndex = 2; // 0(Red),1(Green),2(Blue)
								imgPart = 2;//1 = red1 ,2 = red2
								
								for(int i=0;i<4;i++)
								{
								
									if(i == 0)
									{
										inputFile = "blue_2_img"+fileExtension;
										outputFile = "pre_RSB2"+fileExtension;
									}
									else
									{
										inputFile = "RSB2"+fileExtension;
										outputFile = "pre_RSB2"+fileExtension;
									}
									
									img = ImageProcess.readImage(outDestinationPath+inputFile);
									ShiftImage.rowShift(img,img2, xPro,colorPixelIndex,outDestinationPath,imgPart,fileExtension);
									img = ImageProcess.readImage(outDestinationPath+outputFile);
									ShiftImage.coloumShift(img,img2, xPro, colorPixelIndex,outDestinationPath,imgPart, fileExtension);
								}
								
						// Re-Shuffling Blue Image Part2(Ends)


			// Re-Shuffling The Blue Image (Ends)
								
			// ------------------------------------------------------------------------------
						
						
			// ########## Merging The Image Part1 + Part2 (Starts)##########	
							
					    //Merge Green Image(green_img1+green_img2 = green_img)
						img1 = ImageProcess.readImage(outDestinationPath+"RSG1"+fileExtension);
						img2 = ImageProcess.readImage(outDestinationPath+"RSG2"+fileExtension);
						MergeImage_RRnGGnBB.mergeGreenImage(img1,img2,outDestinationPath,fileExtension);
						
						//Merge Red Image(red_img1+red_img2 =red_img)
						img1 = ImageProcess.readImage(outDestinationPath+"RSR1"+fileExtension);
						img2 = ImageProcess.readImage(outDestinationPath+"RSR2"+fileExtension);
						MergeImage_RRnGGnBB.mergeRedImage(img1,img2,outDestinationPath,fileExtension);
						
						//Merge Blue Image(blue_img1+blue_img2 = blue_img)
						img1 = ImageProcess.readImage(outDestinationPath+"RSB1"+fileExtension);
						img2 = ImageProcess.readImage(outDestinationPath+"RSB2"+fileExtension);
						MergeImage_RRnGGnBB.mergeBlueImage(img1,img2,outDestinationPath,fileExtension);
							
			// ########## Merging The Image Part1 + Part2 (Ends)##########
						
			// ########## Merging The Image Red + Green + Blue (Starts)##########
						img = ImageProcess.readImage(outDestinationPath+"red_img"+fileExtension);
						img1 = ImageProcess.readImage(outDestinationPath+"green_img"+fileExtension);
						img2 = ImageProcess.readImage(outDestinationPath+"blue_img"+fileExtension);
						outFileName = "decrepted_img"+fileExtension;
						Image_Merge.mergeImage(img,img1,img2,outDestinationPath,outFileName);
						
			// ########## Merging The Image Red + Green + Blue (Ends)##########
				
				System.out.println("Image Decrypted Successfully......");
						
				request.setAttribute("fileName",fileName);
				rd=request.getRequestDispatcher("/Resources/JSP/User/display_deccrypted_img.jsp?no=1");
				rd.forward(request, response);
				
			}
			else
			{
				System.out.println("Opps,Something Went Wrong While Uploading The Input Files For Decryption!!!!!");
				request.setAttribute("fileName",fileName);
				rd=request.getRequestDispatcher("/Resources/JSP/User/display_deccrypted_img.jsp?no=2");
				rd.forward(request, response);
			}
			
/* Decrypting  The Random Shares (Ends) */
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Exception is in User==>DecryptImage Servlet : ");
			e.printStackTrace();
			out.println("Opps's Exception is in User DecryptImage Servlet......"+e);
		}
	}
}
