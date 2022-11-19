package com.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

import sun.awt.windows.ThemeReader;

import com.dao.AdminDAO;
import com.dao.UserDAO;

import com.opencv.algorithm.HistogramCompareOpenCV;

public class ImageProcess1 
{
	double distance = 0;
	ImageProcess1()
	{
		System.out.println("==================Histogram====================");
		Thread t=new Thread(new PortListener(9500));
		t.start();
		
	}
	
	class PortListener implements Runnable
	{
		
		int port;
   		public PortListener(int port ) 
   		{
   			this.port=port;
   			run();

   		}
		
		public void run() 
		{
			
			try
			{
				HistogramCompareOpenCV histogram =new HistogramCompareOpenCV();
				
				ServerSocket ServerSocket=new ServerSocket(port);
				while(true)
				{
					
					Socket sock=ServerSocket.accept();
					System.out.println(" accept :"+sock);
					DataInputStream dis=new DataInputStream(sock.getInputStream());
					int fid=dis.readInt();
					String fname=dis.readUTF();
					String fname2=dis.readUTF();
					
					  distance = histogram.compare(fname, fname2);
					boolean  flag = AdminDAO.updateImgDistance(fid, distance);
					System.out.println("image file Distance transaction flag :"+flag);
					  
					  
					
				}
				
			}
			catch(Exception df)
			{
				df.printStackTrace();
			}
		}

		
	}
	
	public static void main(String[] args)
	{
		new ImageProcess1();
	}
}
