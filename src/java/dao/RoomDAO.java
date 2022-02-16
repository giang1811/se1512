/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CHUNG
 */
public class RoomDAO implements DAO<Room> {

    private final String SQL_INSERT = "INSERT INTO dbo.room\n"
            + "(\n"
            + "    room_name,\n"
            + "    bad_number,\n"
            + "    note,\n"
            + "    area_id\n"
            + ")\n"
            + "VALUES\n"
            + "(?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE dbo.room SET room_name = ?, bad_number = ?, note = ?\n"
            + "WHERE room_id = ";

    private String SQL_COUNT_INCLUDE = "SELECT sum(so_giuong) as soluong FROM datn.phong ";
    Connection conn = DBcontext.getConnection();
    AreaDAO areaDAO = new AreaDAO();

    @Override
    public List<Room> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<Room> qq = new ArrayList<>();
            while (rs.next()) {
                Room p = new Room();
                p.setRoomId(rs.getInt("room_id"));
                p.setRoomName(rs.getString("room_name"));
                p.setBadNumber(rs.getString("bad_number"));
                p.setNote(rs.getString("note"));
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
    public Room get(int id) {
        String sql = "select * from Room where room_id = " + id;
        List<Room> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    @Override
    public List<Room> getAll() {
        String sql = "select * from room";
        List<Room> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    public List<Room> getAllInArea(int area_id) {
        String sql = "select * from Room where area_id = " + area_id;
        List<Room> qq = new ArrayList<>();
        qq = parse(sql);
        return qq;
    }

    public String getRoomNameByRoomId(int roomId) {
        String sql = "select room_name from Room where room_id = " + roomId;
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            if (rs.next()) {
                String result = rs.getString("room_name");
                return result;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    @Override
    public void create(Room t) {
//        try (
//                PreparedStatement prep = conn.prepareStatement(SQL_INSERT)) {
//            prep.setString(1, t.getTenPhong());
//            prep.setString(2, t.getSoGiuong());
//            prep.setString(3, t.getGhiChu());
//            prep.setInt(4, t.getKhuCachLy().getIdKhuCachLy());
//            prep.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void delete(Room t) {
        try {
//            String sql = "delete from phong where id_phong = " + t.getIdPhong();
            System.out.println();
            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(sql);
        } catch (SQLException x) {
            x.printStackTrace();
        }
    }

    @Override
    public void update(Room t, Hashtable<String, String> my_dict) {
        String sql_update = "Update phong set ";
        if (!my_dict.isEmpty()) {
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
//                sql_update += change + " where id_phong = " + t.getIdPhong();
                Statement stmt = conn.createStatement();

                stmt.executeUpdate(sql_update);
            } catch (SQLException x) {
                x.printStackTrace();
            }
        }

    }

//    public List<Phong> getList(int offset, int noOfRecords, int idKhuCachLy) {
//        String sql = "select SQL_CALC_FOUND_ROWS * from phong where id_khu_cach_ly =" + idKhuCachLy + " limit " + offset + ", " + noOfRecords;
//        List<Phong> qq = new ArrayList<>();
//        qq = parse(sql);
//        return qq;
//    }
    public int getNoOfRecord(int area_id) throws SQLException {
        String sql = "select count(*) as soluong from phong where id_khu_cach_ly = " + area_id;
        Statement sttm = conn.createStatement();
        ResultSet rs = sttm.executeQuery(sql);
        rs.next();

        return rs.getInt("soluong");
    }

    public int getCountInclude(int idKhu) {
        if (idKhu != 0) {
            SQL_COUNT_INCLUDE += " where id_khu_cach_ly = " + idKhu;
        }
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(SQL_COUNT_INCLUDE);
            rs.next();
            return rs.getInt("soluong");
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        RoomDAO dao = new RoomDAO();
        List<Room> list = dao.getAll();
        for (Room room : list) {
            System.out.println(room);
        }
    }

}
