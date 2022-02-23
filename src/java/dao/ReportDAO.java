/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Patient;
import entity.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ReportDAO implements DAO<Report> {

    private final String SQL_INSERT = "INSERT INTO [dbo].[report]\n"
            + "           ([content]\n"
            + "           ,[create_date]\n"
            + "           ,[id_patient])\n"
            + "     VALUES\n"
            + "           (?,?,?)";

    Connection conn = DBcontext.getConnection();

    @Override
    public List<Report> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<Report> qq = new ArrayList<>();
            while (rs.next()) {
                Report re = new Report();
                re.setId_report(rs.getInt("id_report"));
                re.setContent(rs.getString("content"));
                re.setCreateDate(rs.getTimestamp("create_date"));
                re.setIdPatient(rs.getInt("id_patient"));
                qq.add(re);
            }
            return qq;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Report get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get List of Reports
     *
     * @return List of Reports order by descending create_date
     */
    @Override
    public List<Report> getAll() {
        String sql = "select * from report order by create_date desc";
        List<Report> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    public List<Report> getAllByPatientId(int patient_id) {
        String sql = "SELECT * FROM dbo.report\n"
                + "WHERE id_patient = " + patient_id + "\n"
                + "ORDER BY create_date DESC";
        List<Report> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    @Override
    public void create(Report t) {
        try (
            PreparedStatement prep = conn.prepareStatement(SQL_INSERT)) {
            prep.setString(1, t.getContent());
            prep.setTimestamp(2, (Timestamp) t.getCreateDate());
            prep.setInt(3, t.getIdPatient());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Report t, Hashtable<String, String> my_dict) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Report t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        ReportDAO dao = new ReportDAO();
        Report report = new Report();
        Date date = new Date(System.currentTimeMillis());
        report.setContent("Hello");
//        report.setCreateDate(date);
        report.setIdPatient(34);
        dao.create(report);
    }
}
