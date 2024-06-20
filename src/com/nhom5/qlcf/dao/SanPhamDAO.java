/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom5.qlcf.dao;

import com.nhom5.qlcf.model.DoUong;
import java.util.List;

/**
 *
 * @author Tinh
 */
public class SanPhamDAO extends Coffee7AEDAO<DoUong, Integer> {

    @Override
    public void insert(DoUong douong) {
        String sql = "INSERT INTO Do_Uong(Ma_do_uong, Gia_tien, Ten_do_uong, Size_do_uong, Ma_loai, Mo_ta, Giam_gia, Hinh) VALUES (?,?,?,?,?,?,?,?)";
        Xjdbc.update(sql,
                douong.getMaDoUong(),
                douong.getGiaTien(),
                douong.getTenDoUong(),
                douong.getSizeDoUong(),
                douong.getMaLoai(),
                douong.getMoTa(),
                douong.getGiamGia(),
                douong.getHinh()
        );
    }

    @Override
    public void update(DoUong douong) {
        String sql = "UPDATE Do_Uong SET Gia_tien = ?, Ten_do_uong = ?, Size_do_uong = ?, Ma_loai = ?, Mo_ta = ?, Giam_gia = ?, Hinh = ? where Ma_do_uong = ?";
        Xjdbc.update(sql,
                douong.getGiaTien(),
                douong.getTenDoUong(),
                douong.getSizeDoUong(),
                douong.getMaLoai(),
                douong.getMoTa(),
                douong.getGiamGia(),
                douong.getHinh(),
                douong.getMaDoUong()
        );
    }

    @Override
    public void delete(Integer douong) {
    }

    @Override
    public DoUong selectById(Integer id) {
        return null;
    }

    @Override
    public List<DoUong> selectAll() {
        return null;
    }

    @Override
    protected List<DoUong> selectBySql(String sql, Object... args) {
        return null;
    }

}
