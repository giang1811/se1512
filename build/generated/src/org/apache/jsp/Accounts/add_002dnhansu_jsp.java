package org.apache.jsp.Accounts;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import utils.Utils;

public final class add_002dnhansu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" media=\"screen\" href=\"");
      out.print(request.getContextPath());
      out.write("/assets/css/list/add.css\">\n");
      out.write("<div class=\"col-10 content\">\n");
      out.write("    <div class=\"content-label\">\n");
      out.write("        <span class=\"content-label__menu\">Bảng điều khiển</span>\n");
      out.write("        <span class=\"content-label__info\"><i class=\"fas fa-home\"></i> > Hệ thống > Quản lý tài khoản > Thêm nhân sự</span>\n");
      out.write("        <div class=\"spacer2\"></div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-container form-container_add\">\n");
      out.write("        <div>\n");
      out.write("            <form action=\"add-nhansu\" method=\"POST\" id=\"form-xn\" class=\"form\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"ho_ten\" class=\"form-label\">Họ tên nhân viên:</label>\n");
      out.write("                    <input id=\"ho_ten\" class=\"form-control\" name=\"ho_ten\" type=\"text\" required>\n");
      out.write("                    <span class=\"form-message\"></span>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"ten_dang_nhap\" class=\"form-label\">Tên đăng nhập:</label>\n");
      out.write("                    <input id=\"ten_dang_nhap\" class=\"form-control\" name=\"ten_dang_nhap\" type=\"text\" required>\n");
      out.write("                    <span class=\"form-message\"></span>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"so_dien_thoai\" class=\"form-label\">Số điện thoại:</label>\n");
      out.write("                    <input id=\"so_dien_thoai\" class=\"form-control\" name=\"so_dien_thoai\" type=\"text\" >\n");
      out.write("                    <span class=\"form-message\"></span>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"mat_khau\" class=\"form-label\">Mật khẩu</label>\n");
      out.write("                    <input id=\"mat_khau\" class=\"form-control\" name=\"mat_khau\" type=\"text\" required>\n");
      out.write("                    <span class=\"form-message\"></span>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"loai\" class=\"form-label\">Loại tài khoản:</label>\n");
      out.write("                    <select name=\"loai\" id=\"loai\" class=\"form-control\">\n");
      out.write("                        <option value=\"staff\" selected=\"selected\">Staff</option>\n");
      out.write("                        <option value=\"manager\">Manager</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("                <button type = \"submit\" class=\"form-submit\"><i class=\"far fa-save\"></i><span>Lưu</span></button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div><img class=\"form-img\" name =\"file\" id=\"output\" src=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.imgPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userLogin.getAvatar()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("            <input name=\"file\" type=\"file\" accept=\"image/*\" onchange=\"loadFile(event)\" id=\"getFile\" style=\"display:none\" >\n");
      out.write("            <button style=\"margin-top: 4px; display:block;width: max-content; height:30px;\" onclick=\"document.getElementById('getFile').click()\">Chọn ảnh</button>\n");
      out.write("            <script>\n");
      out.write("                var loadFile = function (event) {\n");
      out.write("                    var reader = new FileReader();\n");
      out.write("                    reader.onload = function () {\n");
      out.write("                        var output = document.getElementById('output');\n");
      out.write("                        output.src = reader.result;\n");
      out.write("                    };\n");
      out.write("                    reader.readAsDataURL(event.target.files[0]);\n");
      out.write("                };\n");
      out.write("            </script>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
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
