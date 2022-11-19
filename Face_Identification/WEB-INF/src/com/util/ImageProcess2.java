package com.util;

import java.io.DataInputStream;
import java.net.*;



import com.dao.AdminDAO;
import com.opencv.algorithm.RANSCAR;
import com.opencv.algorithm.Rotation;

public class ImageProcess2 
{
	ImageProcess2()
	{
		
		System.out.println("=================Homography=====================");
		Thread t=new Thread(new PortListener(8660));
		t.start();
		
	}
	
	class PortListener implements Runnable
	{
		
		int port;
		double avg_distance = 0;
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
				//
				
				
				
				ServerSocket ServerSocket=new ServerSocket(port);
				while(true)
				{
					int i;
					int sum=0;
					Socket sock=ServerSocket.accept();
					System.out.println(" accept :"+sock);
					DataInputStream dis=new DataInputStream(sock.getInputStream());
					int fid=dis.readInt();
					String fname=dis.readUTF();
					String fname2=dis.readUTF();
					String fwritepath=dis.readUTF();
					
					System.out.println(fname);
					for( i=1;i<=4;i++)
					{
						
						System.out.println("^^^^^^^^^^^^^^^^R cout^^^^^^^^^^^^^^^^^"+i);					
						
						boolean flag1=Rotation.rotation(fname);						
						if(flag1)
						{
							
							int distance3=ranscar.homography(fname, fname2,fwritepath);
							boolean flag = AdminDAO.updateImgDist4Feature3(fid,distance3,i);
							sum+=distance3;
						}
	                    else
	                    {
	                    	System.out.println("+++++++++Roation flase+++++++");
	                    }
					}
					//
					System.out.println("****Sum of the roation is :"+sum);
					avg_distance=sum/4;
					boolean f=AdminDAO.updateAvgImgDist(fid,avg_distance);
					sum=0;
					avg_distance=0;
					/*System.out.println("** Avg of the rotation is:"+sum/4);
					double avg;
					avg=sum/4;
					boolean f=AdminDAO.updateAvgImgDist(fid,avg);
					System.out.println("avg status updatesd:"+f);*/
					
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
		new ImageProcess2();
	}
}
