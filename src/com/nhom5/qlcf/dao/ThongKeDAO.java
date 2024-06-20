/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom5.qlcf.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class ThongKeDAO {
    private List<Object[]> getListOfArray(String sql, String[] cols, Object...args){
        try {
            List<Object[]> list=new ArrayList<>();
            ResultSet rs = Xjdbc.query(sql, args);
            while(rs.next()){
                Object[] vals = new Object[cols.length];
                for(int i=0; i<cols.length; i++){
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
   
    public List<Object[]> getDoanhThu(Object thoiGianNay, Object thoiGianKhac){
        String sql = "EXEC [dbo].[sp_DoanhThu] @StartDate = ?, @EndDate= ?;";
        String[] cols = {"TenLoai", "DoanhThu", "ThapNhat",  "CaoNhat", "TrungBinh"};
        return this.getListOfArray(sql, cols, thoiGianNay,thoiGianKhac);
    }
    
    public List<Object[]> getLuongNhanVien(){
        String sql = "exec [dbo].[ThongKeLuongNhanVien]";
        String[] cols = {"MaNhanVien", "TenNhanVien", "ChucVu",  "GioLam", "Luong","ThanhTien"};
        return this.getListOfArray(sql, cols);
    }
    public List<Object[]> TimNhanVienTheoTen(String TenNhanVien){
        String sql = "EXEC [dbo].[TimNhanVien] @TenNhanVien = ?";
        String[] cols = {"MaNhanVien", "TenNhanVien", "ChucVu", "GioLam", "Luong","ThanhTien"};
        return this.getListOfArray(sql, cols,TenNhanVien);
    }
    
    public List<Object[]> showChiTietDonHang(int MaDonHang){
        String sql = "EXEC [dbo].[sp_ChiTietDonHangTheoMa] @MaDonHang = ?";
        String[] cols = {"TenDoUong", "SizeDoUong", "TenLoai", "TenKhachHang", "TenNhanVien","SoLuong","GiaTien","TongTien"};
        return this.getListOfArray(sql, cols,MaDonHang);
    }
    
    

}
