package org.apache.jsp.res.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dao.AdminDAO;
import java.sql.ResultSet;

public final class editProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");

String uid=session.getAttribute("uid").toString();
ResultSet rs=AdminDAO.profile(uid);


      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath());
      out.write("/UpdateProfile\" method=\"post\">\r\n");
      out.write("<center>\r\n");
      out.write("<h1>EDIT PROFILE</h1>\r\n");

while(rs.next())
{
	
      out.write("\r\n");
      out.write("<table border=\"1\">\r\n");
      out.write("<tr><td><label>Phone No :</label></td>\r\n");
      out.write("<td><input type=\"text\" name=\"uid\" value=\"");
      out.print(uid);
      out.write("\"readonly=\"readonly\"></td></tr>\r\n");
      out.write("\r\n");
      out.write("<tr><td><label>Name :</label></td>\r\n");
      out.write("<td><input type=\"text\" name=\"uname\" value=\"");
      out.print(rs.getString(6));
      out.write("\" required=\"yes\"></td></tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr><td><label>Address :</label></td>\r\n");
      out.write("<td><input type=\"text\" name=\"addr\" value=\"");
      out.print(rs.getString(3));
      out.write("\" required=\"yes\"></td></tr>\r\n");
      out.write("\r\n");
      out.write("<tr><td><label>Email ID :</label></td>\r\n");
      out.write("<td><input type=\"text\" name=\"umail\" value=\"");
      out.print(rs.getString(5));
      out.write("\" required=\"yes\" pattern=\"\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*\"></td></tr>\r\n");
      out.write("\r\n");
      out.write("<tr><td><label>Phone NO :</label></td>\r\n");
      out.write("<td><input type=\"text\" name=\"uphone\" value=\"");
      out.print(rs.getString(4));
      out.write("\" required=\"yes\" pattern=\"[7-9]{1}[0-9]{9}\"></td></tr>\r\n");
      out.write("</table>\r\n");
 
}

      out.write("<br>\r\n");
      out.write("<input type=\"hidden\"name=\"no\"value=\"5\">\r\n");
      out.write("<input type=\"submit\" value=\"Update Profile\" style=\"color: green\">\r\n");
      out.write("</center>\r\n");
      out.write("</form>\r\n");
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
