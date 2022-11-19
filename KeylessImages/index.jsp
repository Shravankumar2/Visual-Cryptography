<html> 
<%! 
public int convert(String str) 
{ 
	int conv=0; 
	if(str==null) 
	{ 
		str="0"; 
	} 
	else if((str.trim()).equals("null")) 
	{ 
		str="0"; 
	} 
	else if(str.equals("")) 
	{ 
		str="0"; 
	} 
	try
	{ 
		conv=Integer.parseInt(str); 
	} 
	catch(Exception e) 
	{ 
	} 
	return conv; 
} 
%>
<head>

<title>Index</title>

<%-- Changing the logo of our choice in browser windos(To left corner along with title)
	 By default tomcat server icon will be there 
--%>

<link rel="icon" type="image/ico" href="<%=request.getContextPath() %>/Resources/Images/logo1.GIF"/>

<link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />


<script type = "text/javascript">
// Our own function for message hiding (in Admin Login We used startTimer() from js by including style.js)
function hideMessage()
{
	document.getElementById("message").style.display="none"; 
}
function startTimer() 
{
	var tim = window.setTimeout("hideMessage()", 2000);  // 5000 milliseconds = 5 seconds
}
</script>


<style>

#login
{
	margin:1em auto;
	background:#FFFFFF;
	border:10px solid #EEEEEE;
	width:985px;
	height:220px;
	
	-moz-border-radius:10px;
	-webkit-border-radius:10px;
	border-radius:10px;
	
	-moz-box-shadow:0 0 300px #777777;
	-webkit-box-shadow:0 0 300px #777777;
	box-shadow:0 0 300px #777777;
	
	text-align:center;
	position:absolute;
	left:1px
}

#login a, #login a:visited{color:#0283b2;}
#login a:hover{color:#111;}

#login h1
{
	
	color:#5BACC4;
	text-shadow:#0015dab 0 2px 0;
	font-size:14px;
	padding:5px 7px;
	margin:0 0 .2em 0;
	border-bottom:1px solid #007dab;
	text-align: center;
}

#login h2
{
	
	color:#5BACC4;
	text-shadow:#0015dab 0 2px 0;
	font-size:14px;
	padding:5px 7px;
	margin:0 0 .2em 0;
	border-bottom:1px solid #007dab;
	text-align: right;
	
}

#login .field
{
	border:10px solid #A2A7A2;
	color:white;
	width:300px;
	font-size:12px;
	line-height:1.5em;
	padding:4px;
	-moz-box-shadow:inset 0 0 5px #ccc;
	-webkit-box-shadow:inset 0 0 5px #ccc;
	box-shadow:inset 0 0 50px #000000;
}	

#login div.submit label{float:none;display:inline;font-size:11px;}
	
#login button
{
	border:0;
	padding:0 30px;
	height:30px;
	line-height:30px;
	text-align:center;
	font-size:12px;
	color:#fff;
	text-shadow:#007dab 0 1px 0;
	background:#424242;
	-moz-border-radius:50px;
	-webkit-border-radius:50px;
	border-radius:50px;
	cursor:pointer;
}

#kumar
{
	position:absolute;
	top: 150px;
	left:520px;
	background:#FFFFCC;
	color:#222222;
	text-align:center;
	width:500px
}

</style>

<script language="javascript">

	function check()
	{
		if(document.f1.username.value.length==0 && document.f1.password.value.length==0)
		{
			window.location.href = 'index.jsp?no=1';
			return false
		}
		if(document.f1.username.value.length==0)
		{
			window.location.href = 'index.jsp?no=2';
			return false
		}
		if(document.f1.password.value.length==0)
		{
			window.location.href = 'index.jsp?no=3';
			return false
		}
	}
	
</script>

</head>

<%
	int no=convert(request.getParameter("no"));
	if(no==1)
	{
		    
%>       
    		<div class="error" id="message" style="position:absolute;top:75px;left:400px">	
    			<p> Enter Username and Password !</p>
    		</div>	
    	 
<%
	}
	if(no==2)
	{
%>
		<div class="error" id="message" style="position:absolute;top:75px;left:400px">	
    			<p> Please,Enter Your Username.!</p>
    	</div>	
<%
	}
	if(no==3)
	{
%>
		<div class="error" id="message" style="position:absolute;top:75px;left:400px">	
    			<p> Please,Enter Your Password.!</p>
    	</div>	
<%
	}
%>
<%
	if(no==4)
	{
%>
		<div class="error" id="message" style="position:absolute;top:75px;left:400px">	
    			<p> Sorry,Invalid Username/Password!</p>
    	</div>	
<%
	}
%>
<%
	if(no==5)
	{
%>
		<div class="success" id="message" style="position:absolute;top:75px;left:400px">	
			<p>Logged out successfully...!</p>
		</div>
<%
	}
%>

<body onload = "startTimer()">


<img src="<%=request.getContextPath() %>/Resources/Images/header2.jpg" ></img><br><br><br>

	<form name="f1" id="login" method="post" action="<%=request.getContextPath()%>/UserLogin"> 
	    
    	<div class="form_container">
    	    <h1> 
	    		<font color="black" size="6"><strong>User Login</strong></font>
	    		
	    		 <%-- <a href="<%=request.getContextPath() %>/index1.jsp"><font color="blue" style="position: absolute;text-align: right;margin-left: 325px;">[Are You Admin?]</font></a> --%>
	        </h1>
	       
    		<b>USERNAME</b>
    		<input type="text" name="username" id="login_username" class="field required"  /><br><br>
    		<b>PASSWORD</b>
    		<input type="password" name="password" id="login_password" class="field required"  /><br><br>
    		
        	<button class="submit" type="submit" onclick="return check();">Login</button><br>   
    	
    	</div>			
	    	
    	
  	
		
    	
</form>


<div style="position:absolute;top:265px;left:30px">
<%-- <img src="<%=request.getContextPath() %>/Resources/Images/img_enc.JPG" height="350" width="950"></img> --%>
</div>
<!--  

<div style="position:absolute;top:625px;left:11px;font-size:30px;color:red;">
    <marquee direction="left" width="985px"  dir="rtl" ><strong>A Keyless Approach to Image Encryption</strong> </marquee>
	
</div>
-->
</body>
</html>