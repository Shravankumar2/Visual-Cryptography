package com.util;

import java.io.DataInputStream;
import java.net.*;


import com.opencv.algorithm.RANSCAR;
import com.opencv.algorithm.Rotation;

public class ImageProcess3 
{
	ImageProcess3()
	{
		
		System.out.println("==================matching====================");
		Thread t=new Thread(new PortListener(9661));
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
				RANSCAR ranscar=new RANSCAR();
				
				
				ServerSocket ServerSocket=new ServerSocket(port);
				while(true)
				{
					
					Socket sock=ServerSocket.accept();
					System.out.println(" accept :"+sock);
					DataInputStream dis=new DataInputStream(sock.getInputStream());
					
					String fname=dis.readUTF();
					String fname2=dis.readUTF();
					String fwritepath=dis.readUTF();
					
					System.out.println(fname);


					
					
					int distance3=ranscar.homography(fname, fname2,fwritepath);
				   
					
					
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
		new ImageProcess3();
	}
}
