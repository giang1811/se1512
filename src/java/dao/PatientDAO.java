/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Patient;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import utils.Utils;


public class PatientDAO implements DAO<Patient> {
    Connection conn = DBcontext.getConnection();
   
    AreaDAO khuCachLyDAO = new AreaDAO();

    @Override
    public List<Patient> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<Patient> qq = new ArrayList<>();
            while (rs.next()) {
                Patient p = new Patient();
                p.setPatientId(rs.getInt("patient_id"));
                p.setPatientName(rs.getString("full_name"));
                p.setAge(rs.getInt("age"));
                p.setGender(rs.getString("gender"));
                p.setAddree(rs.getString("address"));
                p.setPassPort(rs.getString("partpost"));
                p.setPhoneNumber(rs.getInt("phone"));
                p.setRegion(rs.getString("region"));
                p.setSuspicionLevel(rs.getString("suspicion_level"));
                p.setTimeIn(rs.getTimestamp("time_in"));
                p.setTimeOut(rs.getTimestamp("time_out"));
                int idPhong = rs.getInt("room_id");
                p.setPhong(null);
                int idKhuCachLy = rs.getInt("area_id");
                p.setKhuCachLy(khuCachLyDAO.get(idKhuCachLy));
                qq.add(p);
            }
            return qq;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Patient get(int id) {
        String sql = "SELECT * from patient where patient_id = " + id;
        List<Patient> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    public Patient getByAccountId(int id) {
        String sql = "SELECT * from patient where account_id = " + id;
        List<Patient> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }
    @Override
    public List<Patient> getAll() {
        return null;
    }

    @Override
    public void update(Patient t, Hashtable<String, String> my_dict) {
        if (!my_dict.isEmpty()) {
            String sql_update = "Update patient set ";
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
                sql_update += change + " where patient_id = " + t.getPatientId();
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql_update);
            } catch (SQLException x) {
                x.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Patient t) {
       
    }

   
    @Override
    public void create(Patient t) {
        

    }

    public List<Patient> SearchByKey(String key, int offset, int noOfRecords) {
        
        return null;
    }

}
