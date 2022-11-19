package com.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.AdminDAO;
import com.opencv.algorithm.HistogramCompareOpenCV;
import com.opencv.algorithm.RANSCAR;

public class Test {
	public static void main(String[] args) throws SQLException {
		HistogramCompareOpenCV histogram =new HistogramCompareOpenCV();
		
		RANSCAR ranscar=new RANSCAR();
		int imageId = 0;
		String fileName="",root = "",imageFileName="",filePath = "",filePath2 = "";
		double distance;
		boolean flag=false;
		int distance3=0;
		String test="313.jpg";
		  root = "D:\\palani_workspace\\OpenCVDemoProject\\File\\uploadedImg\\"+test;
		
		ResultSet rs = AdminDAO.getImage();
		 while(rs.next())
		 {
			//totalNoOfImgInDb++;
			
			imageId = rs.getInt(1);
			fileName = rs.getString(2);
			filePath2 = root+fileName;
			System.out.println("Image File Path : " + filePath2);
			
			filePath2="D:\\palani_workspace\\OpenCVDemoProject\\File\\search\\"+fileName;
			    
			    distance = histogram.compare(root, filePath2);
			    flag = AdminDAO.updateImgDistance(imageId, distance);
			    int j=0;
			    distance3=ranscar.homography(root, filePath2,"");
			    flag = AdminDAO.updateImgDist4Feature3(imageId,distance3,j);
			    
		 }
	}

}
