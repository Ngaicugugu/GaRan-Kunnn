/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.ResultSet;
import Utils.jdbchelper;
import entity.users;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thinkpad T490
 */
public class usersDAO extends chinhDAO<users, String> {

    String INSERT_SQL = "INSERT INTO users(tentk,matkhau,vaitro) VALUES(?,?,?)";
    String UPDATE_SQL = "UPDATE users SET matkhau=?, vaitro=? WHERE tentk=?";
    String DELETE_SQL = "DELETE FROM users WHERE tentk=?";
    String SELECT_ALL_SQL = "SELECT * FROM users";
    String SELECT_BY_ID_SQL = "SELECT * FROM users WHERE tentk=?";

    @Override
    public void insert(users entity) {
        jdbchelper.update(INSERT_SQL,
                entity.getTentk(), entity.getMatkhau(), entity.isVaitro());
    }

    @Override
    public void update(users entity) {
        jdbchelper.update(UPDATE_SQL,
                entity.getMatkhau(), entity.isVaitro(), entity.getTentk());
    }

    @Override
    public void delete(String key) {
        jdbchelper.update(DELETE_SQL, key);
    }

    @Override
    public List<users> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public users selectByid(String key) {
        List<users> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<users> selectBySql(String sql, Object... agrs) {
        List<users> list = new ArrayList<users>();
        try {
            ResultSet rs = jdbchelper.query(sql, agrs);
            while (rs.next()) {
                users entity = new users();
                entity.setTentk(rs.getString("tentk"));
                entity.setMatkhau(rs.getString("matkhau"));
                entity.setVaitro(rs.getBoolean("vaitro"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
