/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom5.qlcf.dao;

import com.nhom5.qlcf.model.DonHang;
import com.nhom5.qlcf.model.NhanVien;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author nphun
 */
public class DonHangDAO extends Coffee7AEDAO<DonHang, Integer> {

    @Override
    public void insert(DonHang DonHang) {

        String sql = "insert into Don_Hang(Ma_don_hang, Ngay_dat_hang, Ma_hinh_thuc, Ghi_chu, Ma_khach_hang, Ma_nhan_vien)\n"
                + "values(?,?,?,?,?,?);";
        Xjdbc.update(sql,
                DonHang.getMaDonHang(),
                DonHang.getNgayDatHang(),
                DonHang.getMaHinhThuc(),
                DonHang.getGhiChu(),
                DonHang.getMaKhachHang(),
                DonHang.getMaNhanVien());
    }

    @Override
    public void update(DonHang DonHang) {
        String sql = "update Don_Hang set Ngay_dat_hang =? , Ma_hinh_thuc = ?, \n"
                + "Ghi_chu = ?, Ma_khach_hang = ?, Ma_nhan_vien =  ? where Ma_don_hang = ?";
        Xjdbc.update(sql,
                DonHang.getNgayDatHang(),
                DonHang.getMaHinhThuc(),
                DonHang.getGhiChu(),
                DonHang.getMaKhachHang(),
                DonHang.getMaNhanVien(),
                DonHang.getMaDonHang());
    }

    @Override
    public void delete(Integer DonHang) {
        String sql = "DELETE  from Don_hang where Ma_don_hang = ?";
        Xjdbc.update(sql, DonHang);
    }

    public List<DonHang> selectAll() {
        String sql = "SELECT * FROM DonHang";
        return selectBySql(sql);
    }

    public List<DonHang> selectShow() {
        String sql = "EXEC [dbo].[donHang.DonHang]";
        return selectBySql(sql);
    }

    public DonHang selectById(Integer So_ban) {
        String sql = "SELECT * FROM Don_hang WHERE Ma_don_hang=?";
        List<DonHang> list = selectBySql(sql, So_ban);
        return list.size() > 0 ? list.get(0) : null;
    }

    protected List<DonHang> selectBySql(String sql, Object... args) {
        List<DonHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while (rs.next()) {
                    DonHang DonHang = new DonHang();
                    DonHang.setMaDonHang(rs.getInt("Ma_don_hang"));
                    DonHang.setNgayDatHang(rs.getDate("Ngay_dat_hang"));
                    DonHang.setMaDoUong(rs.getInt("Ma_do_uong"));
                    DonHang.setTongTien(rs.getFloat("Tong_tien"));
                    DonHang.setMaHinhThuc(rs.getString("Ma_hinh_thuc"));
                    DonHang.setGhiChu(rs.getString("Ghi_chu"));
                    DonHang.setMaKhachHang(rs.getInt("Ma_khach_hang"));
                    DonHang.setMaNhanVien(rs.getInt("Ma_nhan_vien"));
                    list.add(DonHang);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Integer> selectYears() {
        String sql = "SELECT DISTINCT year(Ngay_dat_hang) Year FROM Don_Hang ORDER BY Year DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = Xjdbc.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Integer> selectMonths() {
        String sql = "SELECT DISTINCT month(Ngay_dat_hang) Year FROM Don_Hang ORDER BY Year DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = Xjdbc.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = Xjdbc.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<Object[]> getDonHang(Integer MaDonHang) {
        String sql = "EXEC [dbo].[donHang.DonHang] @@Ma_don_hang = ?;";
        String[] cols = {"MaDonHang", "NgayDatHang", "TenDoUong", "SizeDoUong", "TenLoai", "TenKhachHang", "TenNhanVien"};
        return this.getListOfArray(sql, cols, MaDonHang);
    }
}
