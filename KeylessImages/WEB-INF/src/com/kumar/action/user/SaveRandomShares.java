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
import com.kumar.util.Coversion;
import com.kumar.util.FileMenipulation;
import com.kumar.util.ImageProcess;
import com.kumar.util.Image_Merge;
import com.kumar.util.MergeImage_RRnGGnBB;
import com.kumar.util.ShiftImage;

/**
 * @author Munna Kumar Singh Dec 10, 2012 3:33:14 PM
 *         Project:-KeyLessImageEncryption Package:-com.nitin.action.admin
 *         File:-DecryptImage.java
 */
public class SaveRandomShares extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		boolean flag = false;

		String root = "";
		String fileName = "", fileExtension = "";
		String path = "", action = "";
		String srcFilePath = "";
		String destFilePath = "";
		String randomShare1 = "", randomShare2 = "";

		try {
			fileName = request.getParameter("fileName");
			action = request.getParameter("submit");

			if (fileName != "")
				fileExtension = fileName
						.substring(fileName.lastIndexOf(".") + 1, fileName
								.lastIndexOf(""));// bmp
			fileExtension = "." + fileExtension;// .bmp

			root = request.getRealPath("");

			if (action.equals("Cancel")) {
				System.out
						.println("User Has Requested To Cancel The Process.. ");
				rd = request
						.getRequestDispatcher("/Resources/JSP/User/cancel.jsp");
				rd.forward(request, response);
			}
			if (action.equals("Save Random Share1"))
			{
				System.out.println("User Has Requested To Save Random Share1.. ");

				randomShare1 = "Share1_" + fileName;
				srcFilePath = root + "\\Files\\RandomShare\\" + randomShare1;

				destFilePath = "C:/Users/SHRAVAN KUMAR/Desktop/"+ randomShare1;
				flag = FileMenipulation.copyFile(srcFilePath, destFilePath,	randomShare1);

				if (flag)
				{
					System.out.println("Random Share1 Saved Successfully.....");
					request.setAttribute("fileName", fileName);
					rd = request.getRequestDispatcher("/Resources/JSP/User/display_randomshares.jsp?no=3");
					rd.forward(request, response);
				} 
				else
				{
					System.out.println("Opps,Exception While Saving The Random Share1!!!!!");
					request.setAttribute("fileName", fileName);
					rd = request
							.getRequestDispatcher("/Resources/JSP/User/display_randomshares.jsp?no=2");
					rd.forward(request, response);
				}
			}
			if (action.equals("Save Random Share2")) {

				System.out.println("User Has Requested Save To Random Share2.. ");

				randomShare2 = "Share2_" + fileName;
				srcFilePath = root + "\\Files\\RandomShare\\" + randomShare2;
				destFilePath = "C:/Users/SHRAVAN KUMAR/Desktop/"
						+ randomShare2;
				flag = FileMenipulation.copyFile(srcFilePath, destFilePath,	randomShare2);

				if (flag) {
					System.out.println("Random Share2 Saved Successfully.....");
					request.setAttribute("fileName", fileName);
					rd = request
							.getRequestDispatcher("/Resources/JSP/User/display_randomshares.jsp?no=4");
					rd.forward(request, response);
				} else {
					System.out
							.println("Opps,Exception While Saving The Random Share1!!!!!");
					request.setAttribute("fileName", fileName);
					rd = request
							.getRequestDispatcher("/Resources/JSP/User/display_randomshares.jsp?no=2");
					rd.forward(request, response);
				}
			}

		} catch (Exception e) {
			System.out
					.println("Opps's Exception is in User==>SaveRandomShares Servlet : ");
			e.printStackTrace();
			out
					.println("Opps's Exception is in User==>SaveRandomShares Servlet......"
							+ e);
		}
	}
}
