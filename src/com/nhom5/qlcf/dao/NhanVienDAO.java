package com.nhom5.qlcf.dao;


import com.nhom5.qlcf.model.NhanVien;
import com.nhom5.qlcf.ultity.SHA256;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends Coffee7AEDAO<NhanVien, Integer> {

    @Override
    public void insert(NhanVien nhanVien) {
        String sql = "INSERT INTO Nhan_Vien(Ma_nhan_vien, Ten, Luong, Gio_lam, Gioi_tinh, CCCD, So_dien_thoai, Dia_chi, Vai_tro, Ten_DN, MK, Hinh, Trang_thai_lam_viec,Email) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Xjdbc.update(sql,
                nhanVien.getMaNV(),
                nhanVien.getTenNV(),
                nhanVien.getLuongNV(),
                nhanVien.getGioLam(),
                nhanVien.isGioiTinh(),
                nhanVien.getCCCD(),
                nhanVien.getSDT(),
                nhanVien.getDiaChi(),
                nhanVien.getVaiTro(),
                nhanVien.getTen_DN(),
                SHA256.sha256((String)nhanVien.getMK()),
                nhanVien.getHinh(),
                nhanVien.isTrangThaiLamViec(),
                nhanVien.getEmail()
        );
    }

    @Override
    public void update(NhanVien nhanVien) {
        String sql = "UPDATE Nhan_Vien SET Ten = ?, Gioi_tinh = ?, CCCD = ?, So_dien_thoai = ?, Dia_chi = ?, Vai_tro = ?, Ten_DN = ?, MK = ?, Hinh = ?, Trang_thai_lam_viec = ? WHERE Ma_nhan_vien = ?";
        Xjdbc.update(sql,
                nhanVien.getTenNV(),
                nhanVien.isGioiTinh(),
                nhanVien.getCCCD(),
                nhanVien.getSDT(),
                nhanVien.getDiaChi(),
                nhanVien.getVaiTro(),
                nhanVien.getTen_DN(),
                SHA256.sha256((String)nhanVien.getMK()),
                nhanVien.getHinh(),
                nhanVien.isTrangThaiLamViec(),
                nhanVien.getMaNV()
        );
    }

    @Override
    public void delete(Integer MaNhanVien) {
        String sql = "DELETE FROM Nhan_Vien WHERE Ma_nhan_vien=?";
        Xjdbc.update(sql, MaNhanVien);
    }

    @Override
    public NhanVien selectById(Integer MaNhanVien) {
        String sql = "SELECT * FROM Nhan_Vien WHERE Ma_nhan_vien=?";
        List<NhanVien> list = selectBySql(sql, MaNhanVien);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<NhanVien> selectAll() {
        String sql = "SELECT * FROM Nhan_Vien";
        return selectBySql(sql);
    }
    
    public NhanVien selectByDN(String TenDangNhap) {
        String sql = "SELECT * FROM Nhan_Vien WHERE Ten_DN=?";
        List<NhanVien> list = selectBySql(sql, TenDangNhap);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = Xjdbc.query(sql, args);
                while (rs.next()) {
                    NhanVien nhanVien = new NhanVien();
                    nhanVien.setMaNV(rs.getInt("Ma_nhan_vien"));
                    nhanVien.setTenNV(rs.getString("Ten"));
                    nhanVien.setLuongNV(rs.getDouble("Luong"));
                    nhanVien.setGioLam(rs.getInt("Gio_lam"));
                    nhanVien.setGioiTinh(rs.getBoolean("Gioi_tinh"));
                    nhanVien.setCCCD(rs.getString("CCCD"));
                    nhanVien.setSDT(rs.getString("So_dien_thoai"));
                    nhanVien.setDiaChi(rs.getString("Dia_chi"));
                    nhanVien.setVaiTro(rs.getString("Vai_tro"));
                    nhanVien.setTen_DN(rs.getString("Ten_DN"));
                    nhanVien.setMK(rs.getString("MK"));
                    nhanVien.setHinh(rs.getString("Hinh"));
                    nhanVien.setTrangThaiLamViec(rs.getBoolean("Trang_thai_lam_viec"));
                    list.add(nhanVien);
                }
            } finally {
                if (rs != null) {
                    rs.getStatement().getConnection().close();
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
}
