/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom5.qlcf.model;

/**
 *
 * @author Tinh
 */
public class NhanVien {

    private int MaNV;
    private String TenNV;
    private Double LuongNV;
    private int gioLam;
    private boolean GioiTinh;
    private String CCCD;
    private String SDT;
    private String DiaChi;
    private String VaiTro;
    private String Ten_DN;
    private String MK;
    private String Hinh;
    private boolean TrangThaiLamViec;
    private String Email;

    public NhanVien() {
    }

    public NhanVien(int MaNV, String TenNV, Double LuongNV, int gioLam, boolean GioiTinh, String CCCD, String SDT, String DiaChi, String VaiTro, String Ten_DN, String MK, String Hinh, boolean TrangThaiLamViec, String Email) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.LuongNV = LuongNV;
        this.gioLam = gioLam;
        this.GioiTinh = GioiTinh;
        this.CCCD = CCCD;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.VaiTro = VaiTro;
        this.Ten_DN = Ten_DN;
        this.MK = MK;
        this.Hinh = Hinh;
        this.TrangThaiLamViec = TrangThaiLamViec;
        this.Email = Email;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public Double getLuongNV() {
        return LuongNV;
    }

    public void setLuongNV(Double LuongNV) {
        this.LuongNV = LuongNV;
    }

    public int getGioLam() {
        return gioLam;
    }

    public void setGioLam(int gioLam) {
        this.gioLam = gioLam;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(String VaiTro) {
        this.VaiTro = VaiTro;
    }

    public String getTen_DN() {
        return Ten_DN;
    }

    public void setTen_DN(String Ten_DN) {
        this.Ten_DN = Ten_DN;
    }

    public String getMK() {
        return MK;
    }

    public void setMK(String MK) {
        this.MK = MK;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public boolean isTrangThaiLamViec() {
        return TrangThaiLamViec;
    }

    public void setTrangThaiLamViec(boolean TrangThaiLamViec) {
        this.TrangThaiLamViec = TrangThaiLamViec;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    

}
