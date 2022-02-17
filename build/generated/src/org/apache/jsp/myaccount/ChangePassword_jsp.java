package org.apache.jsp.myaccount;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ChangePassword_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/assets/css/accountDetail.css\" rel=\"stylesheet\">\n");
      out.write("<link href=\"");
      out.print(request.getContextPath());
      out.write("/assets/css/changePass.css\" rel=\"stylesheet\">\n");
      out.write("<div class=\"user-container\">\n");
      out.write("    <div class=\"menu\">\n");
      out.write("        <ul>\n");
      out.write("            <li><div><img class=\"menu-img\" src=\"");
      out.print(request.getContextPath());
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${initParam.imgPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userLogin.getAvatar()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></div>\n");
      out.write("                <div style=\"margin-left: 24px;\"><h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userLogin.getTenDangNhap()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h3>\n");
      out.write("                    <a href=\"\"><i class=\"fas fa-pen\"></i>Sửa hồ sơ</a>\n");
      out.write("                </div>\n");
      out.write("            <li class=\"spacer\"></li>\n");
      out.write("\n");
      out.write("            <li class=\"menu-li\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/myaccount/accountDetail.jsp\" class=\"menu-item\"><i class=\"far fa-user-circle\"></i> Tài khoản của tôi</a></li>\n");
      out.write("            <li class=\"menu-li\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/myaccount/accountDetail.jsp\" class=\"menu-item depend\"> Hồ sơ</a></li>\n");
      out.write("            <li class=\"menu-li\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/myaccount/ChangePassword.jsp\" class=\"menu-item depend\"> Đổi mật khẩu</a></li>\n");
      out.write("            <li class=\"menu-li\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/myaccount/checkAccount.jsp\" class=\"menu-item active\"><i class=\"fas fa-user-check\"></i> Xác minh thuộc khu cách ly</a></li>\n");
      out.write("            <li class=\"menu-li\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/Don/view-list\" class=\"menu-item\"><i class=\"far fa-check-circle\"></i> Đơn của tôi</a></li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"menu-detail\">\n");
      out.write("        <h3 class=\"heading\">Đổi mật khẩu</h3>\n");
      out.write("        <p class=\"desc\">Để bảo mật tài khoản, vui lòng không chia sẻ mật khẩu cho người khác</p>\n");
      out.write("        <div class=\"spacer\"></div>\n");
      out.write("        <div class=\"menu-list\">\n");
      out.write("            <form action=\"ChangePassword\" method=\"POST\" id=\"form-change-pass\" class=\"form-change-pass\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"current_pass\" class=\"form-label\">Mật khẩu hiện tại</label>\n");
      out.write("                    <input id=\"current_pass\" class=\"form-control\" name=\"current_pass\" type=\"password\" >\n");
      out.write("                    <span class=\"form-message\"></span>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"new_pass\" class=\"form-label\">Mật khẩu mới</label>\n");
      out.write("                    <input id=\"new_pass\" class=\"form-control\" name=\"new_pass\" type=\"password\" >\n");
      out.write("                    <span class=\"form-message\"></span>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"new2_pass\" class=\"form-label\">Xác nhận mật khẩu</label>\n");
      out.write("                    <input id=\"new2_pass\" class=\"form-control\" name=\"new2_pass\" type=\"password\" >\n");
      out.write("                    <span class=\"form-message\"></span>\n");
      out.write("                </div>\n");
      out.write("                <button class=\"form-submit\" type=\"submit\">Xác nhận</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("                    \n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/assets/js/validator.js\"></script>\n");
      out.write("<script>\n");
      out.write("    Validator({\n");
      out.write("        form: \"#form-change-pass\",\n");
      out.write("        errorSelector: '.form-message',\n");
      out.write("        rules: [\n");
      out.write("            Validator.minLength(\"#current_pass\", 6),\n");
      out.write("            Validator.minLength(\"#new_pass\", 6),\n");
      out.write("            Validator.minLength(\"#new2_pass\", 6),\n");
      out.write("        ]\n");
      out.write("    });\n");
      out.write("</script>");
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
