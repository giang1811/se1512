package org.apache.jsp.Accounts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/css/list/list.css\">\n");
      out.write("<div class=\"col-10 content\">\n");
      out.write("    <div class=\"content-label\">\n");
      out.write("        <span class=\"content-label__menu\">Bảng điều khiển</span>\n");
      out.write("        <span class=\"content-label__info\"><i class=\"fas fa-home\"></i> > Hệ thống > Quản lý tài khoản </span>\n");
      out.write("        <div class=\"spacer2\"></div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"btn-add\">\n");
      out.write("        <a href=\"");
      out.print(request.getContextPath());
      out.write("/Accounts/add-nhansu.jsp\"><i class=\"fas fa-plus-circle\"></i>\n");
      out.write("            <span>Thêm nhân viên</span>\n");
      out.write("        </a>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"table-list\">\n");
      out.write("        <table class=\"table-list__user\">\n");
      out.write("            <tr>\n");
      out.write("                <th width=\"10%\">Mã</th>\n");
      out.write("                <th width=\"30%\">Họ tên</th>\n");
      out.write("                <th width=\"20%\">Số điện thoại</th>\n");
      out.write("                <th width=\"20%\">Loại tài khoản</th>\n");
      out.write("                <th width=\"20%\">Hệ thống</th>\n");
      out.write("            </tr>\n");
      out.write("            <c:forEach var=\"account\" items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${accountList}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.getIdTaiKhoan()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                    <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.getTenNguoiDung()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                    <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.getSoDienThoai()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                    <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.getLoaiTaiKhoan().getTenLoaiTaiKhoan()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                    <td class=\"td-action\">\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath());
      out.write("/Accounts/view-detail?id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.getIdTaiKhoan()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><i class=\"far fa-calendar-alt\"></i></a>\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath());
      out.write("/Accounts/delete?id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${account.getIdTaiKhoan()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" style=\"background-color: red\"><i class=\"fas fa-trash-alt\"></i></a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </c:forEach>\n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"content-pad\">\n");
      out.write("        <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentPage * 10 > noOfRecords}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("            <div class=\"content-pad__label\">Showing ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(currentPage-1)*10+1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" to ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${noOfRecords}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" of ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${noOfRecords}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" entries</div>\n");
      out.write("        </c:if>\n");
      out.write("        <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentPage * 10 <= noOfRecords}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("            <div class=\"content-pad__label\">Showing ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(currentPage-1)*10+1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" to ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentPage * 10}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" of ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${noOfRecords}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" entries</div>\n");
      out.write("        </c:if>\n");
      out.write("\n");
      out.write("        <div class=\"content-pad__info\">\n");
      out.write("            <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentPage != 1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                <a href=\"");
      out.print(request.getContextPath());
      out.write("/Accounts/view-list?page=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentPage - 1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"> < </a>\n");
      out.write("            </c:if>\n");
      out.write("\n");
      out.write("            <c:forEach begin=\"1\" end=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${noOfPages}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var=\"i\">\n");
      out.write("                <c:choose>\n");
      out.write("                    <c:when test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentPage eq i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                        <a href=\"\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\n");
      out.write("                    </c:when>\n");
      out.write("                    <c:otherwise>\n");
      out.write("                        <a href=\"");
      out.print(request.getContextPath());
      out.write("/Accounts/view-list?page=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${i}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </a>\n");
      out.write("                    </c:otherwise>\n");
      out.write("                </c:choose>\n");
      out.write("            </c:forEach>\n");
      out.write("            <c:if test = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentPage lt noOfPages}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                <a href=\"");
      out.print(request.getContextPath());
      out.write("/Account/view-list?page=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentPage+1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"> > </a>\n");
      out.write("            </c:if>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
