/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Patient;

import dao.PatientDAO;
import dao.TestResultDAO;
import entity.TestResult;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Notification;
import utils.Utils;

/**
 *
 * @author hoang
 */
public class AddTestPatient extends HttpServlet {

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        int id = Integer.parseInt(request.getParameter("id"));

        // change format time
        String time = request.getParameter("time");
        String time2 = time.replace("T", " ") + ":00";
        Date createDate = null;
        try {
            createDate = Utils.DATE_FORMATER.parse(time2);
        } catch (ParseException ex) {
            createDate = new Date();
        }

        String testName = request.getParameter("test_name");
        String result = request.getParameter("result");
        TestResultDAO testResultDAO = new TestResultDAO();
        TestResult testResult = new TestResult();
        testResult.setResult(result);
        testResult.setTestName(testName);
        PatientDAO patientDAo = new PatientDAO();
        testResult.setPatient(patientDAo.get(id));
        testResult.setCreateDate(new java.sql.Timestamp(createDate.getTime()));
        testResultDAO.create(testResult);
        Notification noti = new Notification("Success", "???? th??m k???t qu??? x??t nghi???m th??nh c??ng", "success");
        request.setAttribute("notify", noti);
        RequestDispatcher r1 = request.getRequestDispatcher("view-detail?id=" + id);
        r1.forward(request, response);
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
