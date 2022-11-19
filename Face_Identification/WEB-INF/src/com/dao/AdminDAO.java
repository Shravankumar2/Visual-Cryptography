package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import servicelocator.ServerConnector;


import com.mysql.jdbc.Connection;

import com.mysql.jdbc.Statement;
import com.util.Utility;

public class AdminDAO 
{
	static int threshold=200;
	
public static boolean LoginCHCK(String uname,String upass)
{
	boolean flag=false;
	Connection con=null;
	con=(Connection) ServerConnector.ServerConnector();
	try {
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_admin where aname='"+uname+"' and apass='"+upass+"' ";
		ResultSet rs=(ResultSet) st.executeQuery(sql);
		
		while(rs.next())
		{
			flag=true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return flag;
	
}

public static boolean Changepass(String aname,String x_new_pass)
{
	
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="update m_admin set apass='"+x_new_pass+"' where aname='"+aname+"'";
		System.out.println("Sql....."+sql);
		int i=st.executeUpdate(sql);
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return true;
}
public static ResultSet profile(String uid)
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_admin where aname='"+uid+"'";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}

public static ResultSet getClassifications() 
{
	ResultSet rs=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		rs = (ResultSet) st.executeQuery("select * from m_classification");
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO==>getClassifications() : ");
		e.printStackTrace();
	}
	return rs;
}

public static boolean checkClassificationExistance(String classificationName)
{
	boolean flag=false;
	String sql = "";
	ResultSet rs=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_classification where c_name='"+classificationName+"'";
		System.out.println("********** Check Classification Existance Info **********");
		System.out.println(sql);
		rs = (ResultSet) st.executeQuery(sql);
		while(rs.next())
		{
			flag=true;
		}
		System.out.println("Classification Existance Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>checkgetClassificationExistance(String classificationName) : ");
		e.printStackTrace();
	}
	return flag;
}


public static boolean addClassificationDetails(String classificationName,String remarks)
{
	boolean flag=false;
	String sql = "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "insert into m_classification(c_name,c_remark) values('"+classificationName+"','"+remarks+"')";
		System.out.println("********** Add Classification Details Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag=true;
		}
		System.out.println("Add Classification Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>addClassificationDetails(String classificationName,String remarks) : ");
		e.printStackTrace();
	}
	return flag;
}


public static ResultSet getClassification(int classificationId) 
{
	ResultSet rs=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		rs = (ResultSet) st.executeQuery("select * from m_classification where c_id='"+classificationId+"'");
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO-getClassification(int classificationId) : ");
		e.printStackTrace();
	}
	return rs;
}

public static String getClassificationName(String classificationId) 
{
	ResultSet rs=null;
	String cname=null,day=null;
	float day_theshold=0.0f,night_theshold=0.0f;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		rs = (ResultSet) st.executeQuery("select * from m_classification where c_id='"+classificationId+"'");
	while(rs.next())
	{
		cname=rs.getString(2);
		day=rs.getString(3);
		day_theshold=rs.getFloat(4);
		night_theshold=rs.getFloat(5);
	}
	
	
	if(day.equalsIgnoreCase("DAY"))
	{
		
	}
	else
	{
		
	}
	
	
	
	
	
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO-getClassification(int classificationId) : ");
		e.printStackTrace();
	}
	return cname;
}



public static boolean updatClassificationDetails(int classificationId,String classificationName,String remarks)
{
	boolean flag=false;
	String sql = "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_classification set c_name='"+classificationName+"',c_remark='"+remarks+"' where c_id='"+classificationId+"'";
		System.out.println("********** Update Classification Details Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag=true;
		}
		System.out.println("Update Classification Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updatClassificationDetails(): ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean deleteClassificationDetails(int classificationId)
{
	boolean flag=false;
	String sql = "";
	int i=0;
	try
	{

		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "delete from m_classification where c_id='"+classificationId+"'";
		System.out.println("********** Delete Classification Details Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag=true;
		}
		System.out.println("Delete Classification Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>deleteClassificationDetails(int classificationId): ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean updateprofile(String uid,String uname,String umail,String uphone,String addr)
{
	String name1="";
	ResultSet rs=null;
	boolean flag=false;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="update m_admin set name='"+uname+"',email='"+umail+"',pno='"+uphone+"',addr='"+addr+"' where aname='"+uid+"'";
		int k=st.executeUpdate(sql);
		if(k>0)
		{
			flag=true;
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return flag;
}

public static boolean imgUpdate(String fname)
{
	boolean flag=false;
	Connection con=null;
	con=(Connection) ServerConnector.ServerConnector();
	try {
		Statement st=(Statement) con.createStatement();
		String sql="insert into Tcount (fname) value('"+fname+"') ";
		int k=st.executeUpdate(sql);
		System.out.println("K :"+k);
		if(k>0)
		{
			flag=true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return flag;
	
}


public static ResultSet getImgcount()
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from Tcount";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}

public static ResultSet getImgcat()
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_imgclasification";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}




public static int getImageCount1LastUpdate()
{
	String sql="";
    int name=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select img_id from m_image order by IMG_ID DESC limit 1";
		System.out.println("********** Get Image count Info **********");
		System.out.println(sql);
		ResultSet rs = (ResultSet) st.executeQuery(sql);
		while(rs.next())
		{
			name = rs.getInt(1);
		}
		System.out.println("image count is ++++"+name);
	}
	catch(Exception e)
	{
		System.out.println("Exception in UserDAO==>getAdminName(String username) : ");
		e.printStackTrace();
	}
	return name;
}




public static boolean addImageDetailsUnTrained(String imageFileName,String category)
{
	boolean flag=false;
	String sql = "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		//sql = "insert into m_image(img_name,cid) values('"+imageFileName+"','"+cid+"')";
		sql = "insert into m_image(img_name,cid) values('"+imageFileName+"','"+category+"')";
		System.out.println("********** Add Image Details Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag=true;
		}
		System.out.println("Add Image Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>addImageDetails(String imageFileName,String remarks) : ");
		e.printStackTrace();
	}
	return flag;

	
	
}

public static ResultSet getUsers()
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_user";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}


public static ResultSet getImage()
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_image";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}

public static ResultSet getImage1()
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_image";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}



public static boolean updateImgFeature2(int imageId,double imgFeature2)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set feature2='"+imgFeature2+"' where img_id='"+imageId+"'";
		System.out.println("********** Update Image Feature2 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Feature2 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgFeature2(int imageId,double imgFeature2) : ");
		e.printStackTrace();
	}
	return flag;
}





//Resetting (ENDS)

public static boolean updateImgFeature1(int imageId,String imgFeature1)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set feature1='"+imgFeature1+"' where img_id='"+imageId+"'";
		System.out.println("********** Update Image Feature1 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Feature1 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgFeature1(int imageId,String imgFeature1): ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean updateImgFeature2(int imageId,String imgFeature2)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set feature2='"+imgFeature2+"' where img_id='"+imageId+"'";
		System.out.println("********** Update Image Feature2 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Feature2 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgFeature2(int imageId,String imgFeature2): ");
		e.printStackTrace();
	}
	return flag;
}






public static ResultSet getTopNimg4Feature1Comparision(int noOfRecords) 
{
	String sql="";
	ResultSet rs=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_image order by f1_dist asc limit 0,"+noOfRecords;
		System.out.println("******* Getting The Images For Feature1 Processing *******");
		System.out.println(sql);
		rs = (ResultSet) st.executeQuery(sql);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO==>getImageTopNimg(int noOfRecords) : ");
		e.printStackTrace();
	}
	return rs;
}

public static ResultSet getTopNimg4Feature2Comparision(int noOfRecords) 
{
	String sql="";
	double defaultValue = -1;
	ResultSet rs=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_image where f2_dist !='"+defaultValue+"' order by f2_dist asc limit 0,"+noOfRecords;
		System.out.println("******* Getting The Images For Feature2 Processing *******");
		System.out.println(sql);
		rs = (ResultSet) st.executeQuery(sql);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO==>getTopNimg4Feature2Comparision(int noOfRecords) : ");
		e.printStackTrace();
	}
	return rs;
}

public static ResultSet getTopNimg4Feature3Comparision(String cid) 
{
	String sql="";
	double defaultValue = -1;
	ResultSet rs=null;
	try
	{
		//int threshold=Integer.parseInt(Utility.getPro("threshold"));
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		//sql = "select * from m_image where cid=1 order by f2_dist desc ";
		sql = "select img_id,img_name from m_image where cid='"+cid+"'";
		
		System.out.println(sql);
		rs = (ResultSet) st.executeQuery(sql);
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO==>getTopNimg4Feature3Comparision(int noOfRecords) : ");
		e.printStackTrace();
	}
	return rs;
}


public static String getClasificationId() 
{
	String sql="";
	double defaultValue = -1,avg_dist=0.0;
	ResultSet rs=null;
	String cid=null,status=null;
	String cname=null,day=null,daytotalavg=null,nighttotalavg=null;
	float f1_theshold=0.0f,f2_theshold=0.0f;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_image order by f1_dist limit 1";
		
		System.out.println(sql);
		rs = (ResultSet) st.executeQuery(sql);
		while(rs.next())
		{
			cid=rs.getString(5);
		}
		System.out.println("+++++++++++cid++++++++++ "+cid);
		
		Connection con1=null;
		con1=(Connection) ServerConnector.ServerConnector();
		Statement st2=(Statement) con1.createStatement();
		rs = (ResultSet) st2.executeQuery("select * from m_classification where c_id='"+cid+"'");
		while(rs.next())
		{
			cname=rs.getString(2);
			day=rs.getString(3);
			f1_theshold=rs.getFloat(4);
			f2_theshold=rs.getFloat(5);
		}
		System.out.println("++++cname++++"+cname);
		System.out.println("++++day++++"+day);
		System.out.println("++++F1_theshold++++"+f1_theshold);
		System.out.println("++++F2_theshold++++"+f2_theshold);
		
		//# Getting Avg DIstance from m_image table...[START]
		Connection con2=null;
		con2=(Connection) ServerConnector.ServerConnector();
			Statement st3=(Statement) con2.createStatement();
			String sql1="select avg(f2_dist),avg(f1_dist) from m_image where cid='"+cid+"'";
			System.out.println("sql:"+sql1);
			rs = (ResultSet) st3.executeQuery(sql1);
			while(rs.next())
			{
				daytotalavg=rs.getString(1);
				nighttotalavg=rs.getString(2);
			}
			System.out.println("++++++ DAY totalavg++++++"+daytotalavg);
			System.out.println("++++++ NIGHT totalavg++++++"+daytotalavg);
		if(day.equalsIgnoreCase("DAY"))
		{
			float dayavg_dist=Float.parseFloat(daytotalavg);
			if(dayavg_dist<f2_theshold)
			{
				System.out.println("Animal Found");
				status="Animal Found";
			}
			else
			{
				System.out.println("No Animal Found");
				status="Animal Not Found";
			}
			
			
		}else if(day.equalsIgnoreCase("NIGHT"))
		{
			float nightavg_dist=Float.parseFloat(nighttotalavg);
			if(nightavg_dist<f1_theshold)
			{
				System.out.println("No Animal Found");
				status="Animal Not Found";
				
			}
			else
			{
				System.out.println("Animal Found");
				status="Animal Found";
			}
		}
		
		
		
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	return cid+"~~"+status;
}


public static boolean updateImgDistance(int imageId,double distance)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set f1_dist='"+distance+"' where img_id='"+imageId+"'";
		
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	return flag;
}

public static boolean updateF2Distance()
{
	boolean flag=false;
	String sql= "";
	double defaultValue = -1;
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set f2_dist='"+defaultValue+"'";
		System.out.println("********** Update F2 Distance(f2_dist) Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update F2_Dist Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateF2Distance() : ");
		e.printStackTrace();
	}
	return flag;
}



public static boolean updateImgDist4Feature2(int imageId,double distance2)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set f2_dist='"+distance2+"' where img_id='"+imageId+"'";
		System.out.println("********** Update Image Distance For Feature2 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Distance2 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgDist4Feature2(int imageId,double distance2) : ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean updateImgDist4Feature3(int imageId,int distance3,int r)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set Rot"+r+"_dist='"+distance3+"' where img_id='"+imageId+"'";
		System.out.println("********** Update Image Distance For Feature3 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Distance3 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgDist4Feature3(int imageId,double distance3) : ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean updateAvgImgDist(int imageId,double avg)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set avg_dist='"+avg+"' where img_id='"+imageId+"'";
		System.out.println("********** Update Image Distance For Feature3 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Distance3 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgDist4Feature3(int imageId,double distance3) : ");
		e.printStackTrace();
	}
	return flag;
}



public static String  get_classification_ID() 
{
	ResultSet rs=null;
	String cid="";
	try
	{
		System.out.println("came to sql...");
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select cid,avg(avg_dist) from m_image group by cid order by avg(avg_dist) desc limit 1";
		System.out.println("sql :"+sql);
		rs = (ResultSet) st.executeQuery(sql);
		while(rs.next())
		{
			cid=rs.getString(1);
		}
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
		e.printStackTrace();
	}
	return cid;
}

public static ResultSet  get_classification_name(String cid) 
{
	ResultSet rs=null;
	String status="";
	
	try
	{
		System.out.println("came to sql...");
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select c_name,c_remark from m_classification where c_id='"+cid+"'";
		System.out.println("sql :"+sql);
		rs = (ResultSet) st.executeQuery(sql);
		
		
		System.out.println("status--- "+status);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
		e.printStackTrace();
	}
	return rs;
}

}
