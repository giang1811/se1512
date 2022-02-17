/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Area;
import entity.Patient;
import entity.Room;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import utils.Utils;

public class PatientDAO implements DAO<Patient> {
    
    private final String SQL_INSERT = "INSERT INTO dbo.patient\n"
            + "(\n"
            + "    full_name,\n"
            + "    age,\n"
            + "    gender,\n"
            + "    address,\n"
            + "    partpost,\n"
            + "    phone,\n"
            + "    region,\n"
            + "    suspicion_level,\n"
            + "    time_in,\n"
            + "    time_out,\n"
            + "    room_id,\n"
            + "    area_id,\n"
            + "    account_id\n"
            + ")\n"
            + "VALUES\n"
            + "(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    Connection conn = DBcontext.getConnection();
    
    AreaDAO areaDAO = new AreaDAO();
    RoomDAO roomDAO = new RoomDAO();
    
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
                p.setAddress(rs.getString("address"));
                p.setPassport(rs.getString("partpost"));
                p.setPhoneNumber(rs.getInt("phone"));
                p.setRegion(rs.getString("region"));
                p.setSuspicionLevel(rs.getString("suspicion_level"));
                p.setTimeIn(rs.getTimestamp("time_in"));
                p.setTimeOut(rs.getTimestamp("time_out"));
                int room_id = rs.getInt("room_id");
                p.setRoom(roomDAO.get(room_id));
                int area_id = rs.getInt("area_id");
                p.setArea(areaDAO.get(area_id));
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

    /**
     * Get Patient by account_id
     *
     * @param id
     * @return Patient
     */
    public Patient getPatientByAccountId(int id) {
        String sql = "SELECT * from patient where account_id = " + id;
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
        String sql = "SELECT * from patient";
        List<Patient> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
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
        try {
            String sql = "DELETE FROM dbo.patient WHERE patient_id = " + t.getPatientId();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }

    /**
     * Get Number of Patient stay in Area
     *
     * @param offset initial Row
     * @param noOfRecords number of Patient
     * @param areaId area_id
     * @return List of Patient
     */
    public List<Patient> getList(int offset, int noOfRecords, int areaId) {
        String sql = "WITH Rows AS\n"
                + "(\n"
                + "    SELECT\n"
                + "              ROW_NUMBER() OVER (ORDER BY patient_id) [Row]\n"
                + "            , *\n"
                + "        FROM\n"
                + "              dbo.patient\n"
                + ")\n"
                + "SELECT TOP " + noOfRecords + "\n"
                + "          *\n"
                + "     FROM\n"
                + "         Rows\n"
                + "    WHERE Row > " + offset + " AND Rows.area_id = " + areaId;
        //System.out.println("sql " + sql);
        List<Patient> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    /**
     * Get Number of Record in Area
     *
     * @param areaId
     * @return number of record
     */
    public int getNoOfRecord(int areaId) {
        try {
            String sql = "SELECT COUNT(*) AS NoOfRecords FROM dbo.patient WHERE area_id = " + areaId;
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            rs.next();
            return rs.getInt("NoOfRecords");
        } catch (Exception e) {
            return 0;
        }
    }

    /*
    String fullName = request.getParameter("fullname");
    String suspicionLevel = request.getParameter("suspicionLevel");
    String age = request.getParameter("age");
    int age_int = Integer.parseInt(age);
    String gender = request.getParameter("gender");
    String passport = request.getParameter("passport");
    String region = request.getParameter("region");
    String address = request.getParameter("address");
    String phone = request.getParameter("phone");
    int phone_int = Integer.parseInt(phone);
    String roomName = request.getParameter("roomName");
     */
    
    @Override
    public void create(Patient p) {
        try (
            PreparedStatement prep = conn.prepareStatement(SQL_INSERT)) {
            prep.setString(1, p.getPatientName());
            prep.setInt(2, p.getAge());
            prep.setString(3, p.getGender());
            prep.setString(4, p.getAddress());
            prep.setString(5, p.getPassport());
            prep.setInt(6, p.getPhoneNumber());
            prep.setString(7, p.getRegion());
            prep.setString(8, p.getSuspicionLevel());
            prep.setTimestamp(9, (java.sql.Timestamp) p.getTimeIn());
            prep.setTimestamp(10, null);
            prep.setInt(11, p.getRoom().getRoomId());
            prep.setInt(12, p.getArea().getAreaId());
            prep.setInt(13, 30); // valid account id
            prep.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public List<Patient> SearchByKey(String key, int offset, int noOfRecords) {
        
        String sql = "SELECT * from patient where full_name like '%" + key + "%'";
        List<Patient> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }
    
    public static void main(String[] args) throws ParseException {
        PatientDAO dao = new PatientDAO();
        Patient p = dao.get(7);
        dao.delete(p);
    }
}
