/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;
import entity.Nurse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class AccountDAO implements DAO<Account> {

    private final String SQL_INSERT = "INSERT INTO [dbo].[account]\n"
            + "           ([id_type]\n"
            + "           ,[username]\n"
            + "           ,[password]\n"
            + "           ,[avatar])\n"
            + "     VALUES\n"
            + "           (?,?,?,?)";

    Connection conn = DBcontext.getConnection();
    TypeDAO loaiTaiKhoanDAO = new TypeDAO();
    PatientDAO nguoiCachLyDAO = new PatientDAO();
    AreaDAO khuCachLyDAO = new AreaDAO();

    @Override
    public List<Account> parse(String sql) {
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<Account> qq = new ArrayList<>();
            while (rs.next()) {
                Account p = new Account();
                p.setAccountId(rs.getInt("account_id"));
                p.setUserName(rs.getString("username"));
                p.setPassword(rs.getString("password"));
                int idLoaiTaiKhoan = rs.getInt("id_type");
                p.setAvatar(rs.getString("avatar"));
                p.setType(loaiTaiKhoanDAO.get(idLoaiTaiKhoan));
                qq.add(p);
            }
            return qq;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Account get(int id) {
        return null;
    }

    @Override
    public List<Account> getAll() {

        return null;
    }

    public Account find(String tenDN, String pass) {
        String sql = "select * from account where username = '" + tenDN + "' and password = '" + pass + "';";
        List<Account> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    public Account find(String tenDN) {
        String sql = "select * from account where username = '" + tenDN + "';";
        List<Account> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    public Account findByMaBN(int maBN) {
        String sql = "select * from account where patient_id = " + maBN;
        List<Account> qq = new ArrayList<>();
        qq = parse(sql);
        return (qq.isEmpty() ? null : qq.get(0));
    }

    public Nurse getNurseByAccoutId(int account_id) {
        String sql = "SELECT * FROM dbo.nurse\n"
                + "WHERE id_account = " + account_id;
        try {
            Statement sttm = conn.createStatement();
            ResultSet rs = sttm.executeQuery(sql);
            Nurse nurse = new Nurse();
            while (rs.next()) {
                nurse.setId_nurse(rs.getInt("id_nurse"));
                nurse.setName_nurse(rs.getString("name_nurse"));
                nurse.setPhone(rs.getInt("phone"));
                nurse.setFullName(rs.getString("fullname"));
                nurse.setId_account(account_id);
                nurse.setAddress(rs.getString("address"));
                nurse.setId_area(rs.getInt("id_area"));
            }
            return nurse;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(Account t) {
        try (
            PreparedStatement prep = conn.prepareStatement(SQL_INSERT)) {
            prep.setInt(1, t.getType().getIdLoaiTaiKhoan());
            prep.setString(2, t.getUserName());
            prep.setString(3, t.getPassword());
            prep.setString(4, t.getAvatar());
            prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Account t, Hashtable<String, String> my_dict) {

    }

    @Override
    public void delete(Account t) {

    }
    
    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        Nurse n = dao.getNurseByAccoutId(33);
        System.out.println(n.toString());
    }
}
