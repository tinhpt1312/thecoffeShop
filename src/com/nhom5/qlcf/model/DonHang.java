/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom5.qlcf.model;

import java.util.Date;

/**
 *
 * @author Tinh
 */
public class DonHang {

    private int MaDonHang;
    private Date NgayDatHang;
    private String TenDoUong;
    private int MaDoUong;
    private float TongTien;
    private String MaHinhThuc;
    private String GhiChu;
    private int MaKhachHang;
    private int MaNhanVien;

    public DonHang() {
    }

    public DonHang(int MaDonHang, Date NgayDatHang, String TenDoUong, int MaDoUong, float TongTien, String MaHinhThuc, String GhiChu, int MaKhachHang, int MaNhanVien) {
        this.MaDonHang = MaDonHang;
        this.NgayDatHang = NgayDatHang;
        this.TenDoUong = TenDoUong;
        this.MaDoUong = MaDoUong;
        this.TongTien = TongTien;
        this.MaHinhThuc = MaHinhThuc;
        this.GhiChu = GhiChu;
        this.MaKhachHang = MaKhachHang;
        this.MaNhanVien = MaNhanVien;
    }

    public int getMaDonHang() {
        return MaDonHang;
    }

    public void setMaDonHang(int MaDonHang) {
        this.MaDonHang = MaDonHang;
    }

    public Date getNgayDatHang() {
        return NgayDatHang;
    }

    public void setNgayDatHang(Date NgayDatHang) {
        this.NgayDatHang = NgayDatHang;
    }

    public String getTenDoUong() {
        return TenDoUong;
    }

    public void setTenDoUong(String TenDoUong) {
        this.TenDoUong = TenDoUong;
    }

    public int getMaDoUong() {
        return MaDoUong;
    }

    public void setMaDoUong(int MaDoUong) {
        this.MaDoUong = MaDoUong;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public String getMaHinhThuc() {
        return MaHinhThuc;
    }

    public void setMaHinhThuc(String MaHinhThuc) {
        this.MaHinhThuc = MaHinhThuc;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    
}
