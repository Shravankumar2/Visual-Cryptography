
<head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/message.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/contact.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/login.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/Resources/CSS/button.css" type="text/css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/pagination.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
</head>

<%
	int no=Utility.parse(request.getParameter("no"));
    //String fileExtension = (String) session.getAttribute("file_ext");
%>

<body onload="startTimer()">

<%
	if(no == 0)
	{
%> 

<form id="login" action="<%=request.getContextPath() %>/DecryptImage" enctype="multipart/form-data" method="post">
		
			<div class="tab" style="position:absolute;top:50px;left:210px;width:400px;">
			     
			     <table id="login">
			     	<tr>
			     			<td colspan="3" align="center">Browse Image Files For Decryption</td>
			     	</tr>
			     	
			     	<tr>
			     			<td colspan="3" align="center"><hr></td>
			     	</tr>
			     	
			     	<tr>
			     		<td>Random Share1</td>
			     		<td>:</td>
			     		<td>
			     			<input class="field" type="file" name="file1" style="width:250px"></input>
			     		</td>
			     	</tr>
			     	
			     	<tr>
			     		<td>Random Share2</td>
			     		<td>:</td>
			     		<td>
			     			<input class="field" type="file" name="file2" style="width:250px"></input>
			     		</td>
			     	</tr>
			     	
			     </table>
			     
				<input class="gradientbuttons" type="submit" value="Decrypt Image" style="position:absolute;top:-45px;left:375px;"/>
			</div>
			
</form>

<%
	}
	else if(no == 1)
	{
		
%>

<%
	}
%>
</body>

<%@page import="com.kumar.util.Utility"%></html>