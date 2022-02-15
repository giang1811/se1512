/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.nguoiCachLy;

import dao.PatientDAO;
import dao.RoomDAO;
import entity.Area;
import entity.Patient;
import entity.Room;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.Notification;
import utils.Utils;

/**
 *
 * @author CHUNG
 */
public class addNgCachLy extends HttpServlet {

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
//        String ho_ten = request.getParameter("ho_ten");
//        String phan_loai = request.getParameter("phan_loai");
//        String tuoi = request.getParameter("tuoi");
//        int tuoi_int = Integer.parseInt(tuoi);
//        String gioi_tinh = request.getParameter("gioi_tinh");
//        String ma_can_cuoc = request.getParameter("ma_can_cuoc");
//        String quoc_tich = request.getParameter("quoc_tich");
//        String dia_chi = request.getParameter("dia_chi");
//        String sdt = request.getParameter("so_dien_thoai");
//        int sdt_int = Integer.parseInt(sdt);
//        String so_phong = request.getParameter("phong");
//        RoomDAO phongDAO = new RoomDAO();
//        Room phong = phongDAO.get(Integer.parseInt(so_phong));
//        String tg_vao = Utils.getToday();
//        Date Tg_vao = null;
//        try {
//            Tg_vao = Utils.DATE_FORMATER.parse(tg_vao);
//        } catch (ParseException ex) {
//            Tg_vao = new Date();
//        }
//        HttpSession ss = request.getSession();
//        Area khu = (Area) ss.getAttribute("khuCachLy");
//
//        // Tao doi tuong NguoiCachLy
//        Patient nguoi = new Patient();
//        nguoi.setPatientName(ho_ten);
//        nguoi.setSuspicionLevel(phan_loai);
//        nguoi.setPassPort(ma_can_cuoc);
//        nguoi.setAddree(dia_chi);
//        nguoi.setGender(gioi_tinh);
//        nguoi.setRoom(phong);
//        nguoi.setRegion(quoc_tich);
//        nguoi.setPhoneNumber(sdt_int);
//        nguoi.setAge(tuoi_int);
//        nguoi.setTimeIn(new java.sql.Timestamp(Tg_vao.getTime()));
//        nguoi.setArea(khu);
//
//        PatientDAO dao = new PatientDAO();
//        dao.create(nguoi);
//        Notification noti = new Notification("Success", "Thêm người cách ly thành công", "success");
//        request.setAttribute("notify", noti);
//        RequestDispatcher r1 = request.getRequestDispatcher("view-list");
//        r1.forward(request, response);
        PrintWriter out = response.getWriter();
        out.print("Hello");
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
