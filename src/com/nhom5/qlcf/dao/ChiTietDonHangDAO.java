/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom5.qlcf.dao;

import com.nhom5.qlcf.model.ChiTietDonHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.nhom5.qlcf.dao.Xjdbc;

/**
 *
 * @author Asus
 */
public class ChiTietDonHangDAO extends Coffee7AEDAO<ChiTietDonHang, Integer> {

    @Override
    public void insert(ChiTietDonHang chiTietDonHang) {
        String sql = "INSERT INTO Chi_Tiet_Don_Hang(Ma_don_hang,Ma_do_uong, Tong_tien, Giam_gia ) VALUES (?,?,?,?)";
        Xjdbc.update(sql, 
                chiTietDonHang.getMaDonHang(),
                chiTietDonHang.getMaDoUong(),
                chiTietDonHang.getTongTien(),
                chiTietDonHang.getGiamGia()
        );
    }

    @Override
    public void update(ChiTietDonHang chiTietDonHang) {
        String sql = "UPDATE Chi_Tiet_Don_Hang set Don_gia = ?, So_luong = ?, Giam_gia WHERE Ma_don_hang = ?";
        Xjdbc.update(sql,
                chiTietDonHang.getMaDoUong(),
                chiTietDonHang.getTongTien(),
                chiTietDonHang.getGiamGia(),
                chiTietDonHang.getMaDonHang()
        );
    }

    @Override
    public void delete(Integer MaDonHang) {
        String sql = "DELETE delete from Chi_Tiet_Don_Hang where Ma_don_hang = ?";
        Xjdbc.update(sql, MaDonHang);
    }

    @Override
    public ChiTietDonHang selectById(Integer MaDonHang) {
        String sql = "SELECT * FROM Chi_Tiet_Don_Hang WHERE Ma_don_hang=?";
        List<ChiTietDonHang> list = selectBySql(sql, MaDonHang);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<ChiTietDonHang> selectAll() {
        String sql = "SELECT * FROM Chi_Tiet_Don_Hang";
        return selectBySql(sql);
    }

    @Override
    protected List<ChiTietDonHang> selectBySql(String sql, Object... args) {
        List<ChiTietDonHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while (rs.next()) {
                    ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
                    chiTietDonHang.setMaDonHang(rs.getInt("Ma_don_hang"));
                    chiTietDonHang.setMaDoUong(rs.getInt("Ma_do_uong"));
                    chiTietDonHang.setTongTien(rs.getInt("So_luong"));
                    chiTietDonHang.setGiamGia(rs.getString("Giam_gia"));
                    list.add(chiTietDonHang);
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
