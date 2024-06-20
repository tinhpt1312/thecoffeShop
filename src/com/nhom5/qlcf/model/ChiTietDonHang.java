/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom5.qlcf.model;

/**
 *
 * @author Asus
 */
public class ChiTietDonHang {
    private int MaDonHang;
    private int MaDoUong;
    private double TongTien;
    private String GiamGia;

    public ChiTietDonHang() {
    }

    public ChiTietDonHang(int MaDonHang, int MaDoUong, double TongTien, String GiamGia) {
        this.MaDonHang = MaDonHang;
        this.MaDoUong = MaDoUong;
        this.TongTien = TongTien;
        this.GiamGia = GiamGia;
    }

    public int getMaDonHang() {
        return MaDonHang;
    }

    public void setMaDonHang(int MaDonHang) {
        this.MaDonHang = MaDonHang;
    }

    public int getMaDoUong() {
        return MaDoUong;
    }

    public void setMaDoUong(int MaDoUong) {
        this.MaDoUong = MaDoUong;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public String getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(String GiamGia) {
        this.GiamGia = GiamGia;
    }

   
}
