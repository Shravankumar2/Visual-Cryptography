<%@page import="com.util.Utility"%>
<html>
<head>
    
    <title>Search Image</title>
    
	<link href="<%=request.getContextPath() %>/res/CSS/style1.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" /> 
	<link rel="stylesheet" href="<%=request.getContextPath() %>/res/CSS/form.css" type="text/css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/style.js"></script>
	<script src="<%=request.getContextPath() %>/res/JS/jquery-1.6.4.min.js" type="text/javascript"></script>




</head>
<body onload="startTimer()">
<div class="container" id="label" style="position:absolute;top:7px;left:150px;width:550px;height:440px;">

<%!
	int no = 0,no1=0;
	String fileName = "";
%>

<%	
	no = Utility.parse(request.getParameter("no"));
	no1 = Utility.parse(request.getParameter("no1"));
	if(no==1)
	{
%>
		<div class="success" id="message">	
			<p>Image Searching Process Done Successfully.....</p>
		</div>				
<%
	}
	if(no==2)
	{
%>
			<div class="error" id="message">	
				<p>Opp's,Something Went Wrong!!!!!</p>
			</div>			
<%
	}
	
	if(no==0 & no1==2)
	{
%>
		<div class="error" id="message">	
				<p>Opp's,Something Went Wrong!!!!!</p>
		</div>	
<%
	}
%>
   


<%
	if( no == 0)
	{
%>
<div class="TabMenu" style="position: relative;left:0px;text-align: center;">
	<span>
		<img src="<%=request.getContextPath() %>/res/images/search.png" height="50" width="50" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</span>
	
</div>	


<center>
<h2 style="color: #000000">First Image<h2></center>
<div class="ContentFrame">
	<div class="AllTabs">
		<div class="TabContent" style="position: relative;width: 550px;">
		 <table align="center" id="login">
		   <form action="<%=request.getContextPath()%>/ImageMatching" enctype="multipart/form-data" method="post">
		  		<tr>
	  				<td colspan="3" align="center">
	  					<p><h2 style="color: #000000">For Feature Match</h2>
	  				</td>
		  		</tr>
		  		
		  		<tr>
		  				<td style="color: #000000">
		  						Browse Image File : 
		  				</td>
		  				
		  				<td width="10px"></td>
		  				
		  				<td>
		  						<input class="field" name="myfile" type="file" required="yes"/>
		  				</td>
		  		</tr>
		  		
		  		<tr height="35px"></tr>
		  		
		  		<tr>
		  				<td id="label" colspan="3" align="center">
		  					 <input class="button" type="submit" value="Upload Image"/>
		  				</td>
		  				
		  		</tr>
		  	</form>	
		 </table>
		  
		</div>
		
	</div>
</div>

		
<%
	}// Ends  if(no == 0)
	else if(no == 11)
	{
		fileName = (String)request.getAttribute("image_name");
		System.out.println("===user side===="+fileName);
		
%>
<div class="TabMenu" style="position: relative;left:0px;text-align: center;">
	<span>
		<img src="<%=request.getContextPath() %>/res/images/search.png" height="50" width="50" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</span>
	
</div>	

<hr size="1" color="#351616"></hr>
<center>
<h2 style="color: #000000">Second Image<h2></center>
	<div class="ContentFrame">
	<div class="AllTabs">
		<div class="TabContent" style="position: relative;width: 550px;">
		 <table align="center" id="login">
		   <form action="<%=request.getContextPath()%>/ImageMatching2" enctype="multipart/form-data" method="post">
		  		<tr>
	  				<td colspan="3" align="center">
	  					<p><h2 style="color: #000000">For Feature Match</h2>
	  				</td>
		  		</tr>
		  		
		  		<tr>
		  				<td style="color: #000000">
		  						Browse Image File : 
		  				</td>
		  				
		  				<td width="10px"></td>
		  				
		  				<td>
		  						<input class="field" name="myfile" type="file" required="yes"/>
		  				</td>
		  		</tr>
		  		
		  		<tr height="35px"></tr>
		  		
		  		<tr>
		  				<td id="label" colspan="3" align="center">
		  					 <input class="button" type="submit" value="Upload Image"/>
		  				</td>
		  				
		  		</tr>
		  	</form>	
		 </table>
		  
		</div>
		
	</div>
</div>

<%		
		
	}
	else if(no == 22)
	{
		
		
		
%>
	
<tbody>
<tr>
	<td>
	<!-- Start VisualLightBox.com BODY section id=1 -->
	<div id="vlightbox1">
			
	
			
				<img src="<%=request.getContextPath() %>/Temp2/matching.jpg" alt="Matching Points" width="250" height="250">
			
	
		
		</td>
			
	</tr>
	
</tbody>
</table>
<%		
		
	}
	if(no==22)
	{
%>
		<div class="success" id="message" style="position: absolute;top: 40px;left:100px;">	
			<p>Image Matching Done Successfully.....</p>
		</div>				
<%
	}
%>

</div>	

</body>
</html>