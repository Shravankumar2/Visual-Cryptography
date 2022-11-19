<%@page import="com.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>OpenCV Project</title>

        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style1.css" />
        <link href="<%=request.getContextPath() %>/css/fontstyle.css" rel='stylesheet' type='text/css' />
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/menu.css" />
   
    </head>
    <body>
        <div class="container">
            
           <h1>Visual Cryptography for Bio-metric privacy<span></span></h1>

<div class="header">
               
                <span class="right">
                    <a href="#" target="_blank">Welcome....!</a>
                    <a href="#"><strong></strong></a>
                </span>
                <div class="clr"></div>
            </div>
            <nav>
    <div class='nav-container'>
      <div>
        <input id='slider1' name='slider1' type='checkbox'>
        <label class='slide has-child' for='slider1'>
          <span class='element'>Profile</span>
          <span class='name'>User Profile</span>
        </label>
        <div class='child-menu'>
           <a href="<%=request.getContextPath() %>/res/jsp/user/profile.jsp?no=0" target="f">View Profile</a>         
        </div>
      </div>
      <div>
        <a class='slide' href="<%=request.getContextPath() %>/res/jsp/user/imageMatch.jsp?no=0" target="f">
          <span class='element'>Match Image</span>
          <span class='name'>Feature Image</span>
        </a>
      </div>
      <div>
        <input id='slider2' name='slider2' type='checkbox'>
        <label class='slide has-child' for='slider2'>
          <span class='element'>Image Search</span>
          <span class='name'>Search Images</span>
        </label>
        <div class='child-menu'>
          <a href="<%=request.getContextPath() %>/res/jsp/user/imageSearch.jsp?no=0" target="f">Search Images</a>
          
        </div>
      </div>
      <div>   
        <a class='slide' href="<%=request.getContextPath()%>/res/jsp/user/uchangepass.jsp?no=0" target="f">
          <span class='element'>Change Password</span>
          <span class='name'>Change Password</span>
        </a>
      </div>
      <div>
        <a class='slide' href="<%=request.getContextPath()%>/index1.jsp">
          <span class='element'>Logout</span>
          <span class='name'>Logout</span>
        </a>
      </div>
    </div>
  </nav>
  </div>
  <div class='social-container'>
    <span>
      <a class='social-roll github' href='#'></a>
    </span>
    <span>
      <a class='social-roll twitter' href='#'></a>
    </span>
    <span>
      <a class='social-roll linkedin' href='#'></a>
    </span>
    <span>
      <a class='social-roll rss' href='#'></a>
    </span>
  </div>
            
            
            
            
                     
            
           <div style="position: absolute;top: 160px;left: 230px;"><iframe width="750px;" height="520px;" name="f"  frameborder="0" scrolling="auto"></iframe></div>
            
        
        
        
        
    </body>
</html>
            