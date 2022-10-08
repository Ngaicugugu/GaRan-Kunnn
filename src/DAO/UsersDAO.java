/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.JdbcHelper;
import Model.users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thinkpad T490
 */
public class UsersDAO {
    public void insert(users entity) {
        String sql = "INSERT INTO USERS (taikhoan, matkhau , vaitro) VALUES (?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                entity.getTaikhoan(),
                entity.getMatkhau(),
                entity.isVaitro());
    }

    public void update(users entity) {
        String sql = "UPDATE USERS SET matkhau=?, vaitro=? WHERE taikhoan=?";
        JdbcHelper.executeUpdate(sql,
                entity.getMatkhau(),
                entity.isVaitro(),
                entity.getTaikhoan());
    }

    public void delete(String MaNV) {
        String sql = "DELETE FROM NhanVien WHERE maNhanVien=?";
        JdbcHelper.executeUpdate(sql, MaNV);
    }

    public List<users> select() {
        String sql = "SELECT * FROM USERS";
        return select(sql);
    }

    public users findById(String taikhoan) {
        String sql = "SELECT * FROM NhanVien WHERE maNhanVien=?";
        List<users> list = select(sql, taikhoan);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<users> select(String sql, Object... args) {
        List<users> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    users entity = readFromResultSet(rs);
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private users readFromResultSet(ResultSet rs) throws SQLException {
        users entity = new users();
        entity.setTaikhoan(rs.getString("taikhoan"));
        entity.setMatkhau(rs.getString("matkhau"));
        entity.setVaitro(rs.getBoolean("vaitro"));
        return entity;
    }
}
