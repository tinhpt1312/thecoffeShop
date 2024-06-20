/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.nhom5.qlcf.main;

import com.nhom5.qlcf.dao.NhanVienDAO;
import com.nhom5.qlcf.dao.jdbc;
import com.nhom5.qlcf.model.NhanVien;
import com.nhom5.qlcf.ultity.MsgBox;
import com.nhom5.qlcf.view.QLNVPanel;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class ThemNVJDialog extends javax.swing.JDialog {

    List<NhanVien> nv = new ArrayList<>();
    String strImg = null;
    NhanVienDAO nhanVienDAO = new NhanVienDAO();
    QLNVPanel qlnv = new QLNVPanel();

    public ThemNVJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        rdoNam.setSelected(true);
        rdoNV.setSelected(true);
        txtLuong.setText("50000");
        setMaNV();
    }

    int maNV;

    public void setMaNV() {
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "SELECT TOP 1 * FROM Nhan_Vien ORDER BY Ma_nhan_vien DESC";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                int a = rs.getInt("Ma_nhan_vien");
                maNV = a + 1;
                txtMaNV.setText(String.valueOf(maNV));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateNV() {
        NhanVien nhanVien = getForm();
        try {
            nhanVienDAO.update(nhanVien);
            MsgBox.alert(this, "Cập nhật thành công!");
            qlnv.fillTable();
            this.dispose();
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại!");
            System.out.println(e.getMessage());
        }
    }

    public boolean checkNV() {
        if (txtMaNV.getText().equals("")) {
            lbMaNV.setText("Không được để trống!");
            return false;
        } else {
            lbMaNV.setText("");
        }
        if (txtTenNV.getText().equals("")) {
            lbTenNV.setText("Không được để trống!");
            return false;
        } else {
            lbTenNV.setText("");
        }
        if (txtCCCD.getText().equals("")) {
            lbCCCD.setText("Không được để trống!");
            return false;
        } else {
            lbCCCD.setText("");
        }
        if (txtSDT.getText().equals("")) {
            lbSDT.setText("Không được để trống!");
            return false;
        } else {
            lbSDT.setText("");
        }
        if (txtEmail.getText().equals("")) {
            lbEmail.setText("Không được để trống!");
            return false;
        } else {
            lbEmail.setText("");
        }
        if (txtDiaChi.getText().equals("")) {
            lbDiaChi.setText("Không được để trống!");
            return false;
        } else {
            lbDiaChi.setText("");
        }
        if (txtTK.getText().equals("")) {
            lbTK.setText("Không được để trống!");
            return false;
        } else {
            lbTK.setText("");
        }
        if (txtMK.getText().equals("")) {
            lbMK.setText("Không được để trống!");
            return false;
        } else {
            lbMK.setText("");
        }
        return true;
    }

    NhanVien getForm() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNV(Integer.valueOf(txtMaNV.getText()));
        nhanVien.setTenNV(txtTenNV.getText());
        nhanVien.setLuongNV(Double.valueOf(txtLuong.getText()));
        nhanVien.setGioLam(0);
        nhanVien.setGioiTinh(rdoNam.isSelected() ? true : false);
        nhanVien.setCCCD(txtCCCD.getText());
        nhanVien.setSDT(txtSDT.getText());
        nhanVien.setDiaChi(txtDiaChi.getText());
        nhanVien.setVaiTro(rdoNV.isSelected() ? "NhanVien" : "QuanLy");
        nhanVien.setTen_DN(txtTK.getText());
        nhanVien.setMK(txtMK.getText());
        nhanVien.setHinh(strImg);
        nhanVien.setTrangThaiLamViec(true);
        nhanVien.setEmail(txtEmail.getText());
        return nhanVien;
    }
    
    String selectTen(int manv){
        String ten = "";
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select ten from Nhan_vien where ma_nhan_vien like '" + manv + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ten = rs.getString("ten");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ten;
    }
    
    String selectCCCD(int manv){
        String ten = "";
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select CCCD from Nhan_vien where ma_nhan_vien like '" + manv + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ten = rs.getString("CCCD");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ten;
    }
    
    String selectSDT(int manv){
        String ten = "";
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select So_dien_thoai from Nhan_vien where ma_nhan_vien like '" + manv + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ten = rs.getString("So_dien_thoai");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ten;
    }
    
    String selectMail(int manv){
        String ten = "";
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select Email from Nhan_vien where ma_nhan_vien like '" + manv + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ten = rs.getString("Email");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ten;
    }
    
    String selectDiaChi(int manv){
        String ten = "";
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select dia_chi from Nhan_vien where ma_nhan_vien like '" + manv + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ten = rs.getString("dia_chi");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ten;
    }
    
    String selectTK(int manv){
        String ten = "";
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select ten_dn from Nhan_vien where ma_nhan_vien like '" + manv + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ten = rs.getString("ten_dn");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ten;
    }
    
    String selectMK(int manv){
        String ten = "";
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select MK from Nhan_vien where ma_nhan_vien like '" + manv + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ten = rs.getString("MK");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ten;
    }
    
    String selectHinh(int manv){
        String ten = "";
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select Hinh from Nhan_vien where ma_nhan_vien like '" + manv + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ten = rs.getString("Hinh");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "D:\\tinhpt26461\\Duan1\\QuanLyCoffe\\src\\com\\nhom5\\qlcf\\img\\" + ten;
    }

    public void themNV() {
        if (checkNV()) {
            NhanVien nhanVien = getForm();
            try {
                nhanVienDAO.insert(nhanVien);
                MsgBox.alert(this, "Thêm mới thành công!");
                qlnv.fillTable();
                this.dispose();
            } catch (Exception e) {
                MsgBox.alert(this, "Thêm mới thất bại!");
                System.out.println(e.getMessage());
            }
        }
    }
    
    boolean selectNam(int manv){
        boolean ten = true;
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select Gioi_tinh from Nhan_vien where ma_nhan_vien like '" + manv + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ten = rs.getBoolean("Gioi_tinh");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ten;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        lbImg = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtLuong = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rdoQL = new javax.swing.JRadioButton();
        rdoNV = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTK = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMK = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lbMaNV = new javax.swing.JLabel();
        lbTenNV = new javax.swing.JLabel();
        lbCCCD = new javax.swing.JLabel();
        lbSDT = new javax.swing.JLabel();
        lbDiaChi = new javax.swing.JLabel();
        lbTK = new javax.swing.JLabel();
        lbMK = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(220, 135, 112));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Mã nhân viên: (*)");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tên nhân viên: (*)");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Giới tính: (*)");

        txtMaNV.setBackground(new java.awt.Color(196, 196, 196));
        txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtMaNV.setForeground(new java.awt.Color(0, 0, 0));
        txtMaNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaNVKeyPressed(evt);
            }
        });

        txtTenNV.setBackground(new java.awt.Color(196, 196, 196));
        txtTenNV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTenNV.setForeground(new java.awt.Color(0, 0, 0));

        buttonGroup1.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdoNam.setForeground(new java.awt.Color(0, 0, 0));
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdoNu.setForeground(new java.awt.Color(0, 0, 0));
        rdoNu.setText("Nữ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Căn cước công dân: (*)");

        txtCCCD.setBackground(new java.awt.Color(196, 196, 196));
        txtCCCD.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtCCCD.setForeground(new java.awt.Color(0, 0, 0));

        lbImg.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbImg.setForeground(new java.awt.Color(0, 0, 0));
        lbImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImg.setText("Ảnh");
        lbImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbImgMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Số điện thoại: (*)");

        txtSDT.setBackground(new java.awt.Color(196, 196, 196));
        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtSDT.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Lương: (*)");

        txtLuong.setEditable(false);
        txtLuong.setBackground(new java.awt.Color(196, 196, 196));
        txtLuong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtLuong.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Vai trò: (*)");

        buttonGroup2.add(rdoQL);
        rdoQL.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdoQL.setForeground(new java.awt.Color(0, 0, 0));
        rdoQL.setText("Quản lý");
        rdoQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoQLActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoNV);
        rdoNV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rdoNV.setForeground(new java.awt.Color(0, 0, 0));
        rdoNV.setText("Nhân viên");
        rdoNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNVActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Địa chỉ: (*)");

        txtDiaChi.setBackground(new java.awt.Color(196, 196, 196));
        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtDiaChi.setForeground(new java.awt.Color(0, 0, 0));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Tài khoản: (*)");

        txtTK.setBackground(new java.awt.Color(196, 196, 196));
        txtTK.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTK.setForeground(new java.awt.Color(0, 0, 0));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Mật khẩu: (*)");

        txtMK.setBackground(new java.awt.Color(196, 196, 196));
        txtMK.setForeground(new java.awt.Color(0, 0, 0));
        txtMK.setMinimumSize(new java.awt.Dimension(64, 28));
        txtMK.setPreferredSize(new java.awt.Dimension(64, 28));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Lưu");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Hủy");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbMaNV.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbMaNV.setForeground(new java.awt.Color(153, 51, 0));

        lbTenNV.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbTenNV.setForeground(new java.awt.Color(153, 51, 0));

        lbCCCD.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbCCCD.setForeground(new java.awt.Color(153, 51, 0));

        lbSDT.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbSDT.setForeground(new java.awt.Color(153, 51, 0));

        lbDiaChi.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbDiaChi.setForeground(new java.awt.Color(153, 51, 0));

        lbTK.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbTK.setForeground(new java.awt.Color(153, 51, 0));

        lbMK.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbMK.setForeground(new java.awt.Color(153, 51, 0));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Email: (*)");

        txtEmail.setBackground(new java.awt.Color(196, 196, 196));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));

        lbEmail.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(153, 51, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(56, 56, 56)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel13))
                            .addComponent(jLabel9)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12))
                        .addGap(48, 48, 48)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtCCCD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                        .addComponent(txtTenNV, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(rdoNam)
                            .addGap(60, 60, 60)
                            .addComponent(rdoNu))
                        .addComponent(txtTK)
                        .addComponent(txtDiaChi)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(rdoQL)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                            .addComponent(rdoNV)
                            .addGap(27, 27, 27))
                        .addComponent(txtLuong)
                        .addComponent(txtSDT)
                        .addComponent(txtEmail))
                    .addComponent(txtMK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbCCCD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(lbSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lbDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbMK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdoQL))
                            .addComponent(rdoNV))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLuong))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(lbTK, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbMK, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thêm nhân viên");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 583, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rdoQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoQLActionPerformed
        txtLuong.setText("100000");
    }//GEN-LAST:event_rdoQLActionPerformed

    private void rdoNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNVActionPerformed
        txtLuong.setText("50000");
    }//GEN-LAST:event_rdoNVActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int a = Integer.parseInt(txtMaNV.getText());
        if (a < maNV) {
            updateNV();
        } else {
            themNV();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lbImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImgMouseClicked
        try {
            JFileChooser jfc = new JFileChooser("D:\\tinhpt26461\\Duan1\\QuanLyCoffe\\src\\com\\nhom5\\qlcf\\img");
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            strImg = file.getName();
            Image img = ImageIO.read(file);
            lbImg.setText("");
            int rong = lbImg.getWidth();
            int cao = lbImg.getHeight();
            lbImg.setIcon(new ImageIcon(img.getScaledInstance(rong, cao, 0)));
        } catch (IOException ex) {
            System.out.println("Error: " + ex.toString());
        }
    }//GEN-LAST:event_lbImgMouseClicked

    private void txtMaNVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaNVKeyPressed
        int a = Integer.parseInt(txtMaNV.getText());
        if (a >= maNV) {
            MsgBox.alert(this, "Sản phẩm chưa được thêm");
        }else{
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                txtTenNV.setText(selectTen(Integer.parseInt(txtMaNV.getText())));
                txtCCCD.setText(selectCCCD(Integer.parseInt(txtMaNV.getText())));
                txtSDT.setText(selectSDT(Integer.parseInt(txtMaNV.getText())));
                txtEmail.setText(selectMail(Integer.parseInt(txtMaNV.getText())));
                txtDiaChi.setText(selectDiaChi(Integer.parseInt(txtMaNV.getText())));
                txtTK.setText(selectTK(Integer.parseInt(txtMaNV.getText())));
                txtMK.setText(selectMK(Integer.parseInt(txtMaNV.getText())));
                if(selectNam(Integer.parseInt(txtMaNV.getText())) == true){
                    rdoNam.setSelected(true);
                }else{
                    rdoNu.setSelected(true);
                }
                lbImg.setText("");
                lbImg.setIcon(new ImageIcon(selectHinh(Integer.parseInt(txtMaNV.getText()))));
            }
        }
    }//GEN-LAST:event_txtMaNVKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThemNVJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemNVJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemNVJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemNVJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThemNVJDialog dialog = new ThemNVJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbCCCD;
    private javax.swing.JLabel lbDiaChi;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbImg;
    private javax.swing.JLabel lbMK;
    private javax.swing.JLabel lbMaNV;
    private javax.swing.JLabel lbSDT;
    private javax.swing.JLabel lbTK;
    private javax.swing.JLabel lbTenNV;
    private javax.swing.JRadioButton rdoNV;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoQL;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JPasswordField txtMK;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTK;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
