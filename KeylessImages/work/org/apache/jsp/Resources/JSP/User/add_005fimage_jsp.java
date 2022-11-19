package org.apache.jsp.Resources.JSP.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kumar.util.Utility;

public final class add_005fimage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/style1.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
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
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\r\n");
      out.write("\tfunction check()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tif(document.f1.file.value.length==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Please Select a File\");\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("\r\n");
      out.write("<div id=\"a2\" style=\"position:absolute;top:30px;left:150px\" class=\"c\">\r\n");
      out.write("\t<form name=\"f1\" action=\"");
      out.print(request.getContextPath());
      out.write("/Resources/JSP/User/select_file.jsp\">\r\n");
      out.write("\t<table id=\"login\" align=\"center\">\r\n");
      out.write("\t    \r\n");
      out.write("\t    <h1 align=\"center\"><font color=\"#000000\" style=\"font-style: bold\" size=\"5\">Add Image For Encryption</font></h1>\r\n");
      out.write("\t    \r\n");
      out.write("\t\t<hr size=\"10\" color=\"#5E74D8\"></hr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"3\" align=\"center\"><hr></hr></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"200px\">Subject :</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"75px\">:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"200px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"field\" name=\"subject\" required=\"yes\">\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"7\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"button\" type=\"submit\"  value=\"Select File\" onclick=\"return check();\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
 
	if(Utility.parse(request.getParameter("no"))==1)
	{
		
      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:5px;left:50px\">\t\r\n");
      out.write("\t\t\t\t<p>Sorry,This File is already Exists,Select Other File!</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t");

	}
	
	if(Utility.parse(request.getParameter("no"))==2)
	{
		
      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:5px;left:50px\">\t\r\n");
      out.write("\t\t\t\t<p>Opps,Something Went Wrong Try Again...!</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t");

	}
	
	
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
