package com.opencv.algorithm;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

/**
 * @author ramesh
 *
 */
public class Rotation 
{
	public static boolean rotation(String filePath)
	{
		boolean flag=false;
		try
		{
			System.out.println("=============== rotation [START] =================");
			
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			Mat image = Highgui.imread(filePath, Highgui.CV_LOAD_IMAGE_UNCHANGED);
			Core.transpose(image, image);
			Core.flip(image, image, 1);
			Highgui.imwrite(filePath, image);
			image.release();
			flag=true;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
	
	
	
	public static void main(String[] args) 
	{
		
		String filePath = "108200.jpg";
		String filePath1 = "rotat.jpg";
		
		rotation(filePath);
		/*Mat image = Highgui.imread(filePath, Highgui.CV_LOAD_IMAGE_UNCHANGED);
		Core.transpose(image, image);
		Core.flip(image, image, 1);
		Highgui.imwrite(filePath1, image);
		image.release();
		*/
		
		
		
		
		
	}

}
