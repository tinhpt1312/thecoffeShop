/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom5.qlcf.model;

/**
 *
 * @author Tinh
 */
public class DoUong {
    
    private int MaDoUong;
    private Double GiaTien;
    private String TenDoUong;
    private String SizeDoUong;
    private String MaLoai;
    private String MoTa;
    private String GiamGia;
    private String Hinh;

    public DoUong() {
    }

    public DoUong(int MaDoUong, Double GiaTien, String TenDoUong, String SizeDoUong, String MaLoai, String MoTa, String GiamGia, String Hinh) {
        this.MaDoUong = MaDoUong;
        this.GiaTien = GiaTien;
        this.TenDoUong = TenDoUong;
        this.SizeDoUong = SizeDoUong;
        this.MaLoai = MaLoai;
        this.MoTa = MoTa;
        this.GiamGia = GiamGia;
        this.Hinh = Hinh;
    }

    public int getMaDoUong() {
        return MaDoUong;
    }

    public void setMaDoUong(int MaDoUong) {
        this.MaDoUong = MaDoUong;
    }

    public Double getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(Double GiaTien) {
        this.GiaTien = GiaTien;
    }

    public String getTenDoUong() {
        return TenDoUong;
    }

    public void setTenDoUong(String TenDoUong) {
        this.TenDoUong = TenDoUong;
    }

    public String getSizeDoUong() {
        return SizeDoUong;
    }

    public void setSizeDoUong(String SizeDoUong) {
        this.SizeDoUong = SizeDoUong;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(String GiamGia) {
        this.GiamGia = GiamGia;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }
    
    
    
}
