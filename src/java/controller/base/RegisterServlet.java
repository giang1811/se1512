
package controller.base;

import dao.AreaDAO;
import dao.PatientDAO;
import dao.AccountDAO;
import entity.TypeAccount;
import entity.Patient;
import entity.Account;
import java.io.IOException;
import java.util.Hashtable;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Configs;
import utils.Notification;
import static utils.Utils.md5;


public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession ss = request.getSession();
        String tenDN = request.getParameter("ten_dang_nhap");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullname");
        String passwordBcr =  md5(password);
        
        String maBenhNhan = request.getParameter("mabenhnhan");
      
        int maBN = Integer.parseInt(maBenhNhan);
      
        
        AccountDAO taiKhoanDAO = new AccountDAO();
        Account user = taiKhoanDAO.find(tenDN);
        
        if (user != null) {
            Notification noti = new Notification("Warning", "Tài khoản đã bị trùng.<br/> Vui lòng chọn tên tài khoản khác.", "error");
            request.setAttribute("notify", noti);
            RequestDispatcher rt = request.getRequestDispatcher("register.jsp");
            rt.forward(request, response);
        } else {
            PatientDAO ngDAO = new PatientDAO();
            AreaDAO khuCachLyDAO = new AreaDAO();
            Patient nguoiCachLy = ngDAO.get(maBN);
           
            if(nguoiCachLy!=null){
                    Account newUser = new Account();
                    newUser.setUserName(tenDN);
                    newUser.setPassword(passwordBcr);
                    newUser.setType(new TypeAccount(3));
                    newUser.setPatient(nguoiCachLy);
                    newUser.setAvatar(Configs.IMG_PATH_AVATAR_DEFAULT);
                    taiKhoanDAO.create(newUser);
                    // set Session Login
                    Account user2 = taiKhoanDAO.find(tenDN, passwordBcr);
                    user2.setPatient(nguoiCachLy);
                    Hashtable<String, String> my_dict = new Hashtable<>();
                    my_dict.put("account_id", user2.getAccountId()+"");
                    ngDAO.update(nguoiCachLy, my_dict);
                    ss.setAttribute("userLogin", user2);
                    Notification noti = new Notification("Success", "Xin chúc mừng bạn đã đăng ký thành công", "success");
                    request.setAttribute("notify", noti);
                    RequestDispatcher rt = request.getRequestDispatcher("home.jsp");
                    rt.forward(request, response);
           
           }else{
                 Notification noti = new Notification("Warning", "Bệnh nhân không tồn tại.<br/> Vui lòng nhập lại mã .", "error");
                 request.setAttribute("notify", noti);
                 RequestDispatcher rt = request.getRequestDispatcher("register.jsp");
                 rt.forward(request, response);
            }
            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
