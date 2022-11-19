<%@page import="com.dao.UserDAO"%>
<%@page import="com.util.Utility"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.dao.AdminDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title></title>
   <link rel="shortcut icon" href="http://visuallightbox.com/favicon.ico">
   
   <link href="<%=request.getContextPath()%>/res/CSS/style.css" rel="stylesheet" type="text/css">
   
   <script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/pagination1.js"></script>
   

<!-- Start VisualLightBox.com HEAD section -->
    
    <link href="<%=request.getContextPath()%>/res/CSS/vlightbox1.css" rel="stylesheet" type="text/css">
    
	<link href="<%=request.getContextPath()%>/res/CSS/visuallightbox.css" rel="stylesheet" type="text/css">
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery.min.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/ga.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/visuallightbox.js"></script>
	

 <!-- End VisualLightBox.com HEAD section -->
 
 <link rel="stylesheet" href="<%=request.getContextPath()%>/res/CSS/default.css">
 
 <script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/a.js"></script>
 
 <script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/highlight.js"></script>
 
 <script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/conversion.js"></script>
 
 <script src="<%=request.getContextPath() %>/res/JS/thumbscript1.js" type="text/javascript"></script>
 <script src="<%=request.getContextPath() %>/res/JS/vlbdata1.js" type="text/javascript"></script>

<style type="text/css">

body
{

	position:relative;
	margin: 0;
	background: url("res/images/page.jpg") repeat scroll 0 0 #2D5552;
	font-family: "KreonRegular",sans-serif;
	font-size: 16px;
	color: #0845ca;
	text-shadow: 1px 2px 0 rgba(0, 107, 138, 0.1);
	text-align:center;
	
}

</style>

</head>
<body>
<%!
	ArrayList<String> list = null;
	ResultSet rs = null;
	String imageFileName = "",threshhold4Feature3="";
	int noOfRecords = 0; 
	

	
	
%>

<%
	
	//String cid=request.getParameter("cid");

	list = new ArrayList<String>();
	
	String cid=AdminDAO.get_classification_ID();
	
    rs = AdminDAO.getTopNimg4Feature3Comparision(cid);
 
    if(!rs.next())
    {
    	// no data 
    	
%>
<script type="text/javascript">
alert("no record found");
</script>

<%    } 
   
    	
   		 while(rs.next())
    		{
   			System.out.println("===========else========"+rs.getString(2));
    			list.add(rs.getString(2));
    		}
   		 System.out.println(list);
	
%>

<div id="content">	
<header id="header">

<table id="results" style="width: 100%; margin: 0 auto;" cellpadding="0px" cellspacing="0px">

<tbody>
<tr>
	<td>
	
	<div id="vlightbox1">
	
			
	<%
		int rows = 1;
		int br = 4;//4 Clumn Per Row
		
		for (int i = 0; i < list.size(); i++) 
		{
		    imageFileName = list.get(i);
		    System.out.println("========================================");
		    System.out.println("image Name :"+imageFileName);
		    System.out.println("========================================");
	%>
			<a class="vlightbox1" href="<%=request.getContextPath() %>/File/search/<%=imageFileName%>">
				<img src="<%=request.getContextPath() %>/File/search/<%=imageFileName%>" alt="Image Lightbox" width="150" height="150">Image Lightbox
			</a>
	<%	    
		    
		    if (i % br == (br - 1))
		    {
		    	rows++;
	%>
				<br>
	<%		    
			}
	
		}
		
	    
	%>
	<%
	String clname="";
	String re="";
	ResultSet ststus=AdminDAO.get_classification_name(cid);
	while(ststus.next())
	{
		clname=ststus.getString(1);
		re=ststus.getString(2);
	}
	%>
		
		</td>
			
	</tr>
	<tr>
	<td>
	<font size="5" color="red"><a >Classification Name: <%=clname%></a></font>
	<br>
	<br>
		<font size="5" color="red"><a>Classification Remark: <%=re%></a> </font>
		</td>
		</tr>
</tbody>
</table>		
<br>

<%-- 
<div id="pageNavPosition" style="cursor:hand"></div>
<script type="text/javascript">
		var pager = new Pager('<%=rows%>',1); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
</script>
--%>	
<div class="separator"></div>
</header>

</div>

</body>
</html>