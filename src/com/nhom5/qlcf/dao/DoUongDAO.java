/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom5.qlcf.dao;

import com.nhom5.qlcf.model.DoUong;
import com.nhom5.qlcf.dao.Xjdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class DoUongDAO extends Coffee7AEDAO<DoUong, Integer> {

    @Override
    public void insert(DoUong doUong) {
        String sql = "insert into Khach_Hang( Ma_do_uong, Gia_tien, Ten_do_uong, Size_do_uong, Ma_loai, Mo_Ta, Giam_gia,Hinh) values (?,?,?,?,?,?,?,?)";
        Xjdbc.update(sql, 
                    doUong.getMaDoUong(),
                    doUong.getGiaTien(),
                    doUong.getTenDoUong(),
                    doUong.getSizeDoUong(),
                    doUong.getMaLoai(),
                    doUong.getMoTa(),
                    doUong.getGiamGia(),
                    doUong.getHinh()
        );
    }

    @Override
    public void update(DoUong doUong) {
        String sql = "update Do_Uong SET  Gia_tien = ?  , Ten_do_uong =  ?, Size_do_uong = ?, Ma_loai = ? , Mo_Ta = ? , Giam_gia =?,Hinh = ? where Ma_do_uong = ? ";
         Xjdbc.update(sql,
                    doUong.getGiaTien(),
                    doUong.getTenDoUong(),
                    doUong.getSizeDoUong(),
                    doUong.getMaLoai(),
                    doUong.getMoTa(),
                    doUong.getGiamGia(),
                    doUong.getHinh(),
                    doUong.getMaDoUong()
         );
    }

    @Override
    public void delete(Integer MaDoUong) {
         String sql="DELETE FROM Do_Uong WHERE Ma_do_uong=?";
        Xjdbc.update(sql, MaDoUong);
    }

    @Override
    public DoUong selectById(Integer MaDoUong) {
        String sql="SELECT * FROM Do_Uong WHERE Ma_do_uong=?";
        List<DoUong> list = selectBySql(sql, MaDoUong);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<DoUong> selectAll() {
        String sql="SELECT * FROM Do_Uong";
        return selectBySql(sql);
    }

    @Override
    protected List<DoUong> selectBySql(String sql, Object... args) {
            List<DoUong> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while(rs.next()){
                    DoUong doUong=new DoUong();
                    doUong.setMaDoUong(rs.getInt("Ma_do_uong"));
                    doUong.setGiaTien(rs.getDouble("Gia_tien"));
                    doUong.setTenDoUong(rs.getString("Ten_do_uong"));
                    doUong.setSizeDoUong(rs.getString("Size_do_uong"));
                    doUong.setMaLoai(rs.getString("Ma_loai"));
                    doUong.setMoTa(rs.getString("Mo_ta"));
                    doUong.setGiamGia(rs.getString("Giam_gia"));
                    doUong.setHinh(rs.getString("Hinh"));
                    list.add(doUong);
                }
            }
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    public void seLectByTen(String TenDoUong, String SizeDoUong){
        String sql = "select * from Do_Uong where Ten_do_uong = N'?' and Size_do_uong = N'?'";
        Xjdbc.update(sql, TenDoUong,SizeDoUong);
    }
    public List<DoUong> selectTenDouong(){
        String sql="SELECT Ma_do_uong, Ten_do_uong FROM Do_Uong group by Ten_do_uong,Ma_do_uong";
        return selectBySql(sql);
    }
    
}
    

