/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom5.qlcf.dao;


import com.nhom5.qlcf.model.BanAn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class BanAnDAO extends Coffee7AEDAO<BanAn, Integer> {

    public void insert(BanAn BanAn) {
        String sql = "INSERT INTO Ban (So_Ban, So_luong_nguoi, Ma_nhan_vien) VALUES (?, ?, ?)";
        Xjdbc.update(sql,
                BanAn.getSo_ban(),
                BanAn.getSo_Luong_Nguoi(),
                BanAn.getMa_Nhan_Vien());
    }

    public void update(BanAn BanAn) {
        String sql = "UPDATE Ban set So_Luong_Nguoi = ?, Ma_Nhan_Vien = ? WHERE So_ban = ?";
        Xjdbc.update(sql,
                BanAn.getSo_Luong_Nguoi(),
                BanAn.getMa_Nhan_Vien(),
                BanAn.getSo_ban());
    }  

    public void delete(Integer SoBan) {
        String sql = "DELETE delete from Ban where So_ban = ?";
        Xjdbc.update(sql, SoBan);
    }

    public List<BanAn> selectAll() {
        String sql = "SELECT * FROM Ban";
        return selectBySql(sql);
    }

    public BanAn selectById(Integer SoBan) {
        String sql = "SELECT * FROM Ban WHERE So_ban=?";
        List<BanAn> list = selectBySql(sql, SoBan);
        return list.size() > 0 ? list.get(0) : null;
    }

    protected List<BanAn> selectBySql(String sql, Object... args) {
        List<BanAn> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while (rs.next()) {
                    BanAn BanAn = new BanAn();
                    BanAn.setSo_ban(rs.getInt("So_ban"));
                    BanAn.setSo_Luong_Nguoi(rs.getInt("So_luong_nguoi"));
                    BanAn.setMa_Nhan_Vien(rs.getInt("Ma_nhan_vien"));
                    list.add(BanAn);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
}
