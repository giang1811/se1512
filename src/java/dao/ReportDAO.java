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
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ReportDAO implements DAO<Report>{

     private final String SQL_INSERT = "INSERT INTO [dbo].[report]\n" +
"           ([content]\n" +
"           ,[create_date]\n" +
"           ,[id_patient])\n" +
"     VALUES\n" +
"           (?,?,?)";
    
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
                re.setCreateDate(rs.getDate("create_date"));
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
        String sql = "select * from report where id_report = " + id;
        List<Report> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    @Override
    public List<Report> getAll() {
        String sql = "select * from report order by create_date desc";
        List<Report> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    public List<Report> getAllById(int patientId) {
        String sql = "select * from report where id_patient = " + patientId + " order by create_date desc";
        List<Report> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }
    
    @Override
    public void create(Report t) {
        try (
            PreparedStatement prep = conn.prepareStatement(SQL_INSERT)) {
            prep.setString(1, t.getContent());
            prep.setDate(2, t.getCreateDate());
            prep.setInt(3, t.getIdPatient());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Report t, Hashtable<String, String> my_dict) {
        if (!my_dict.isEmpty()) {
            String sql_update = "Update report set ";
            try (
                    PreparedStatement prep = conn.prepareStatement(sql_update);) {
                String change = "";
                for (String key : my_dict.keySet()) {
                    String value = my_dict.get(key);
                    try {
                        int values = Integer.parseInt(value);
                        change += key + " = " + values + ",";
                    } catch (Exception e) {
                        change += key + " = '" + value + "',";
                    }
                }
                change = change.substring(0, change.length() - 1);
                sql_update += change + " where id_report = " + t.getId_report();
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql_update);
            } catch (SQLException x) {
                x.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Report t) {
         try {
            String sql = "delete from report where id_report = " + t.getId_report();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }
}