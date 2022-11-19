package org.apache.jsp.Resources.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kumar.util.Utility;
import java.sql.ResultSet;
import com.kumar.DAO.AdminDAO;

public final class display_005fshuffled_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/button.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/login.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/JS/style.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/JS/pagination.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");

    
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


      out.write("\t\r\n");
      out.write("\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath());
      out.write("/EncryptImage\">\r\n");
      out.write("<div align=\"right\" style=\"position:absolute;top:0px;left:750px\">\r\n");
      out.write("\t<input type=\"submit\" name=\"submit\" value=\"Generate Random Share\" class=\"gradientbuttons\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t<input type=\"hidden\" name=\"fileName\" value=\"");
      out.print(fileName);
      out.write("\">\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"a3\" align=\"right\" style=\"position:absolute;top:40px;left:25px;width: 860px;height: 375px;\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("<p>\r\n");
      out.write("\r\n");
      out.write("\t<table id=\"results\" class=\"tab\" border=\"1\" cellpadding=\"5px\" cellspacing=\"4px\" width=\"860px\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td colspan=\"6\" align=\"center\">\r\n");
      out.write("\t\t\t<font color=\"#000000\" style=\"font-style: bold\" size=\"5\">Shuffling Details</font>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t <table>\r\n");
      out.write("\t\t\t\t         <tr>\r\n");
      out.write("\t\t\t\t                 <td rowspan=\"2\" align=\"center\">\r\n");
      out.write("\t\t\t\t                 \t\t<img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/Files/Sieving/");
      out.print(red_img);
      out.write("\" width=\"100px\" height=\"120px\">\r\n");
      out.write("\t\t\t\t                 \t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t                 \t\t<br>\r\n");
      out.write("\t\t\t\t                 \t\tOriginal\r\n");
      out.write("\t\t\t\t                 </td>\r\n");
      out.write("\t\t\t\t                 \r\n");
      out.write("\t\t\t\t                 <td>\r\n");
      out.write("\t\t\t\t                 \t   <img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/Files/Shuffle/SR1");
      out.print(fileExtension);
      out.write("\" width=\"100px\" height=\"120px\">\r\n");
      out.write("\t\t\t\t                 \t   <br>\r\n");
      out.write("\t\t\t\t                 \t   Shuffled1\r\n");
      out.write("\t\t\t\t                 \t   <br>\r\n");
      out.write("\t\t\t\t                 \t   <br>\r\n");
      out.write("\t\t\t\t                 \t   <img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/Files/Shuffle/SR2");
      out.print(fileExtension);
      out.write("\" width=\"100px\" height=\"120px\">\r\n");
      out.write("\t\t\t\t                 \t    Shuffled2\r\n");
      out.write("\t\t\t\t                 </td>\r\n");
      out.write("\t\t\t\t         </tr>\r\n");
      out.write("\t\t\t\t </table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t <table>\r\n");
      out.write("\t\t\t\t         <tr>\r\n");
      out.write("\t\t\t\t                 <td rowspan=\"2\" align=\"center\">\r\n");
      out.write("\t\t\t\t                 \t\t<img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/Files/Sieving/");
      out.print(green_img);
      out.write("\" width=\"100px\" height=\"120px\">\r\n");
      out.write("\t\t\t\t                 \t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t                 \t\t<br>\r\n");
      out.write("\t\t\t\t                 \t\tOriginal\r\n");
      out.write("\t\t\t\t                 </td>\r\n");
      out.write("\t\t\t\t                 \r\n");
      out.write("\t\t\t\t                 <td>\r\n");
      out.write("\t\t\t\t                 \t   <img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/Files/Shuffle/SG1");
      out.print(fileExtension);
      out.write("\" width=\"100px\" height=\"120px\">\r\n");
      out.write("\t\t\t\t                 \t   <br>\r\n");
      out.write("\t\t\t\t                 \t   Shuffled1\r\n");
      out.write("\t\t\t\t                 \t   <br>\r\n");
      out.write("\t\t\t\t                 \t   <br>\r\n");
      out.write("\t\t\t\t                 \t   <img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/Files/Shuffle/SG2");
      out.print(fileExtension);
      out.write("\" width=\"100px\" height=\"120px\">\r\n");
      out.write("\t\t\t\t                 \t    Shuffled2\r\n");
      out.write("\t\t\t\t                 </td>\r\n");
      out.write("\t\t\t\t         </tr>\r\n");
      out.write("\t\t\t\t </table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t <table>\r\n");
      out.write("\t\t\t\t         <tr>\r\n");
      out.write("\t\t\t\t                 <td rowspan=\"2\" align=\"center\">\r\n");
      out.write("\t\t\t\t                 \t\t<img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/Files/Sieving/");
      out.print(blue_img);
      out.write("\" width=\"100px\" height=\"120px\">\r\n");
      out.write("\t\t\t\t                 \t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t                 \t\t<br>\r\n");
      out.write("\t\t\t\t                 \t\tOriginal\r\n");
      out.write("\t\t\t\t                 </td>\r\n");
      out.write("\t\t\t\t                 \r\n");
      out.write("\t\t\t\t                 <td>\r\n");
      out.write("\t\t\t\t                 \t   <img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/Files/Shuffle/SB1");
      out.print(fileExtension);
      out.write("\" width=\"100px\" height=\"120px\">\r\n");
      out.write("\t\t\t\t                 \t   <br>\r\n");
      out.write("\t\t\t\t                 \t   Shuffled1\r\n");
      out.write("\t\t\t\t                 \t   <br>\r\n");
      out.write("\t\t\t\t                 \t   <br>\r\n");
      out.write("\t\t\t\t                 \t   <img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/Files/Shuffle/SB2");
      out.print(fileExtension);
      out.write("\" width=\"100px\" height=\"120px\">\r\n");
      out.write("\t\t\t\t                 \t   Shuffled2\r\n");
      out.write("\t\t\t\t                 </td>\r\n");
      out.write("\t\t\t\t         </tr>\r\n");
      out.write("\t\t\t\t </table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("  \t </table>\r\n");
      out.write("  \t </p>\r\n");
      out.write("   </div>\r\n");
      out.write(" </form>\r\n");
      out.write("   \r\n");
      out.write("\r\n");

	if(Utility.parse(request.getParameter("no"))==1)
	{
		
      out.write("\r\n");
      out.write("\t\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:5px;left:50px\">\t\r\n");
      out.write("\t\t\t\t<p>Image Shuffling Process Done successfully ..!</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t");

	}
	if(Utility.parse(request.getParameter("no"))==2)
	{
		
      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:5px;left:50px\">\t\r\n");
      out.write("\t\t\t\t<p>Opps,Something Went Wrong! Try Again....</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t");

	}
	

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
