package com.util;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.opencv.algorithm.Rotation;

public class ImageProcess4 
{
	 ImageProcess4()
	 {
		// TODO Auto-generated constructor stub
		 System.out.println("==================Rotation====================");
		 Thread thread=new Thread(new PortListener(8690));
		 thread.start();
	}


class PortListener implements Runnable
{
	int port;
	
	public PortListener(int port)
	{
	 this.port=port;
	 run();
	}
	public void run()
	{
		try
		{
			ServerSocket serversocket=new ServerSocket(port);
		    
			while(true)
			{
				Socket sock=serversocket.accept();
				System.out.println(""+sock);
				DataInputStream dis=new DataInputStream(sock.getInputStream());
				String fname1=dis.readUTF();
				//String fwritepath=dis.readUTF();
				
				boolean flag=Rotation.rotation(fname1);
				
			}
		
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}

public static void main(String[] arg)
{
	new ImageProcess4();
}
}
