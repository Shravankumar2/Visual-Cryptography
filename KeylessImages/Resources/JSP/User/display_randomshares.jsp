<%@page import="com.kumar.util.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.kumar.DAO.AdminDAO"%><html>
<head>
	<link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/pagination.js"></script>

</head>
<body onload="startTimer()">
<%
    
    int no=Utility.parse(request.getParameter("no"));
	String fileName="",red_img="",green_img="",blue_img="",red_img1="",red_img2="",green_img1="",
	green_img2="",blue_img1="",blue_img2="",fileExtension="";
	fileName = request.getAttribute("fileName").toString();
	
	if(fileName!="")
    fileExtension=fileName.substring(fileName.lastIndexOf(".")+1,fileName.lastIndexOf(""));//jpg
   	fileExtension = "."+fileExtension;// .jpg
	
   	red_img = "red_"+fileName;
	green_img = "green_"+fileName;
	blue_img = "blue_"+fileName;
	
	red_img1 = "red_div1_"+fileName;
	red_img2 = "red_div2_"+fileName;
	green_img1 = "green_div1_"+fileName;
	green_img2 = "green_div2_"+fileName;
	blue_img1 = "blue_div1_"+fileName;
	blue_img2 = "blue_div2_"+fileName;

%>	

<form action="<%=request.getContextPath()%>/SaveRandomShares">
<div align="right" style="position:absolute;top:0px;left:510px">
    <input type="submit" name="submit" value="Cancel" class="gradientbuttons"/>&nbsp;
	<input type="submit" name="submit" value="Save Random Share1" class="gradientbuttons"/>&nbsp;
	<input type="submit" name="submit" value="Save Random Share2" class="gradientbuttons"/>
	<input type="hidden" name="fileName" value="<%=fileName%>">
	
</div>

<div id="a3" align="right" style="position:absolute;top:40px;left:25px;width: 860px;height: 375px;">
			
<p>

	<table id="results" class="tab" border="1" cellpadding="5px" cellspacing="4px" width="860px">
		
		<tr>
			<td colspan="6" align="center">
			<font color="#000000" style="font-style: bold" size="5">Image Encryption Details</font>
			</td>
									
		</tr>
		
		<tr align="center">
			
			<td>
				 <table>
				         <tr>
				                 
				                 <td rowspan="3" align="center">
				                 		<img alt="" src="<%=request.getContextPath()%>/Files/Image/<%=fileName%>" width="100px" height="100px">
				                 		<br>
				                 		IMAGE
				                 </td>
				                 
				                 
				                 <td rowspan="3" align="center">
				                 		<img src="<%=request.getContextPath() %>/Resources/Images/arrow.jpg" width="25px" height="20px"></img>
				                 </td>
				                 
				                 
				                 <td rowspan="2" align="center">
				                 		<img alt="" src="<%=request.getContextPath()%>/Files/Sieving/<%=red_img%>" width="100px" height="100px">
				                 		<br>
				                 		<img alt="" src="<%=request.getContextPath()%>/Files/Sieving/<%=green_img%>" width="100px" height="100px">
				                 		<br>
				                 		<img alt="" src="<%=request.getContextPath()%>/Files/Sieving/<%=blue_img%>" width="100px" height="100px">
				                 		<br>
				                 		SIEVING
				                 </td>
				                 
				                 
				                 <td rowspan="3" align="center">
				                 		<img src="<%=request.getContextPath() %>/Resources/Images/arrow.jpg" width="25px" height="20px"></img>
				                 </td>
				                 
				                 
				                 <td  align="center">
				                 		<img alt="" src="<%=request.getContextPath()%>/Files/Division/<%=red_img1%>" width="100px" height="49px">
				                 		<br>
				                 		<img alt="" src="<%=request.getContextPath()%>/Files/Division/<%=red_img2%>" width="100px" height="49px">
				                 		<br>
				                 		<img alt="" src="<%=request.getContextPath()%>/Files/Division/<%=green_img1%>" width="100px" height="49px">
				                 		<br>
				                 		<img alt="" src="<%=request.getContextPath()%>/Files/Division/<%=green_img2%>" width="100px" height="49px">
				                 		<br>
				                 		<img alt="" src="<%=request.getContextPath()%>/Files/Division/<%=blue_img1%>" width="100px" height="49px">
				                 		<br>
				                 		<img alt="" src="<%=request.getContextPath()%>/Files/Division/<%=blue_img2%>" width="100px" height="49px">
				                 		<br>
				                 		DIVISION
				                 </td>
				                 
				                 
				                 <td rowspan="3" align="center">
				                 		<img src="<%=request.getContextPath() %>/Resources/Images/arrow.jpg" width="25px" height="20px"></img>
				                 </td>
				                 
				                 
				                 <td  align="center">
				                 		<img alt="" src="<%=request.getContextPath()%>/Files/Shuffle/SR1<%=fileExtension%>" width="100px" height="49px">
				                 		<br>
				                 		<img alt="" src="<%=request.getContextPath()%>/Files/Shuffle/SR2<%=fileExtension%>" width="100px" height="49px">
				                 		<br>
				                 		<img alt="" src="<%=request.getContextPath()%>/Files/Shuffle/SG1<%=fileExtension%>" width="100px" height="49px">
				                 		<br>
				                 		<img alt="" src="<%=request.getContextPath()%>/Files/Shuffle/SG2<%=fileExtension%>" width="100px" height="49px">
				                 		<br>
				                 		<img alt="" src="<%=request.getContextPath()%>/Files/Shuffle/SB1<%=fileExtension%>" width="100px" height="49px">
				                 		<br>
				                 		<img alt="" src="<%=request.getContextPath()%>/Files/Shuffle/SB2<%=fileExtension%>" width="100px" height="49px">
				                 		<br>
				                 		SHUFFLE
				                 </td>
				                 
				                 
				                 <td rowspan="3" align="center">
				                 		<img src="<%=request.getContextPath() %>/Resources/Images/arrow.jpg" width="25px" height="20px"></img>
				                 </td>
				                 
				                 
				                 
				                 <td rowspan="2" align="center">
				                 		<img alt="" src="<%=request.getContextPath()%>/Files/RandomShare/Share1_<%=fileName%>" width="130px" height="130px">
				                 		<br>
				                 		SHARE1
				                 		<br>
				                 		<br>
				                 		<img alt="" src="<%=request.getContextPath()%>/Files/RandomShare/Share2_<%=fileName%>" width="130px" height="130px">
				                 		<br>
				                 		SHARE2
				                 		<br>
				                 		COMBINING
				                 </td>
				                 
				                
				         </tr>
				 </table>
			</td>
			
					
		</tr>

  	 </table>
  	 </p>
   </div>
 </form>
   

<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
		%>
			<div class="success" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Random Share Generation Process Done Successfully .....</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no"))==2)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Opps,Something Went Wrong! Try Again....</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no"))==3)
	{
		%>
			<div class="success" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Random Share1 Saved Successfully .....</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no"))==4)
	{
		%>
			<div class="success" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Random Share2 Saved Successfully .....</p>
			</div>
		<%
	}
	
%>
</body>
</html>


