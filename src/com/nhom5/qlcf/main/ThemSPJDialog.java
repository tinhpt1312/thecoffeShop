/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.nhom5.qlcf.main;

import com.nhom5.qlcf.dao.SanPhamDAO;
import com.nhom5.qlcf.dao.jdbc;
import com.nhom5.qlcf.model.DoUong;
import com.nhom5.qlcf.ultity.MsgBox;
import com.nhom5.qlcf.view.QLSPPanel;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class ThemSPJDialog extends javax.swing.JDialog {

    String strImg = null;
    SanPhamDAO sanpham = new SanPhamDAO();
    QLSPPanel qlsp = new QLSPPanel();

    public ThemSPJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        loadData();
        setMaSP();

    }
    int maNV;

    public void setMaSP() {
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "SELECT TOP 1 Ma_do_uong FROM Do_Uong ORDER BY Ma_do_uong DESC";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                int a = rs.getInt("Ma_do_uong");
                maNV = a + 1;
                txtMaDU.setText(String.valueOf(maNV));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void loadData() {
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select Ma_loai from Loai_Do_Uong ";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("Ma_loai");
                cboMaLoai.addItem(name);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean checkSP() {
        if (txtMaDU.getText().equals("")) {
            lbMaDU.setText("Không được để trống!");
            return false;
        } else {
            lbMaDU.setText("");
        }
        if (txtTenDU.getText().equals("")) {
            lbTenDU.setText("Không được để trống!");
            return false;
        } else {
            lbTenDU.setText("");
        }
        if (txtGiaTien.getText().equals("")) {
            lbGiaTien.setText("Không được để trống!");
            return false;
        } else {
            lbGiaTien.setText("");
        }
        if (txtSize.getText().equals("")) {
            lbSize.setText("Không được để trống!");
            return false;
        } else {
            lbSize.setText("");
        }
        return true;
    }

    public void themSP() {
        if (checkSP()) {
            DoUong douong = getForm();
            try {
                sanpham.insert(douong);
                MsgBox.alert(this, "Thêm mới thành công!");
                qlsp.fillTable();
                this.dispose();
            } catch (Exception e) {
                MsgBox.alert(this, "Thêm mới thất bại!");
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateSP() {
        DoUong douong = getForm();
        try {
            sanpham.update(douong);
            MsgBox.alert(this, "Cập nhật thành công!");
            qlsp.fillTable();
            this.dispose();
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại!");
            System.out.println(e);
        }
    }

    public String selectTen(int madu) {
        String ten = "";
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select ten_do_uong from do_uong where ma_do_uong like '" + madu + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ten = rs.getString("ten_do_uong");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ten;
    }

    public Double selectGia(int madu) {
        Double gia = null;
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select gia_tien from do_uong where ma_do_uong like '" + madu + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                gia = rs.getDouble("gia_tien");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return gia;
    }

    public String selectSize(int madu) {
        String size = "";
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select Size_do_uong from do_uong where ma_do_uong like '" + madu + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                size = rs.getString("Size_do_uong");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return size;
    }

    public String selectMota(int madu) {
        String mota = "";
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select mo_ta from do_uong where ma_do_uong like '" + madu + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                mota = rs.getString("mo_ta");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return mota;
    }

    public String selectHinh(int madu) {
        String hinh = "";
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "select hinh from do_uong where ma_do_uong like '" + madu + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                hinh = rs.getString("hinh");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "D:\\tinhpt26461\\Duan1\\QuanLyCoffe\\src\\com\\nhom5\\qlcf\\img\\" + hinh;
    }

    DoUong getForm() {
        DoUong douong = new DoUong();
        douong.setMaDoUong(Integer.valueOf(txtMaDU.getText()));
        douong.setGiaTien(Double.valueOf(txtGiaTien.getText()));
        douong.setTenDoUong(txtTenDU.getText());
        douong.setSizeDoUong(txtSize.getText());
        douong.setMaLoai(cboMaLoai.getSelectedItem().toString());
        douong.setMoTa(txtMoTa.getText());
        douong.setGiamGia("Không");
        douong.setHinh(strImg);
        return douong;
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
        txtMaDU = new javax.swing.JTextField();
        txtTenDU = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGiaTien = new javax.swing.JTextField();
        lbImg = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cboMaLoai = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        lbMaDU = new javax.swing.JLabel();
        lbTenDU = new javax.swing.JLabel();
        lbGiaTien = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSize = new javax.swing.JTextField();
        lbSize = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(220, 135, 112));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Mã đồ uống: (*)");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tên đồ uống: (*)");

        txtMaDU.setBackground(new java.awt.Color(196, 196, 196));
        txtMaDU.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtMaDU.setForeground(new java.awt.Color(0, 0, 0));
        txtMaDU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaDUKeyPressed(evt);
            }
        });

        txtTenDU.setBackground(new java.awt.Color(196, 196, 196));
        txtTenDU.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTenDU.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Giá tiền: (*)");

        txtGiaTien.setBackground(new java.awt.Color(196, 196, 196));
        txtGiaTien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtGiaTien.setForeground(new java.awt.Color(0, 0, 0));

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

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Mã loại: (*)");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Mô tả: (*)");

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

        cboMaLoai.setBackground(new java.awt.Color(196, 196, 196));
        cboMaLoai.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cboMaLoai.setForeground(new java.awt.Color(0, 0, 0));

        txtMoTa.setBackground(new java.awt.Color(196, 196, 196));
        txtMoTa.setColumns(20);
        txtMoTa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtMoTa.setForeground(new java.awt.Color(0, 0, 0));
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        lbMaDU.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbMaDU.setForeground(new java.awt.Color(153, 0, 0));

        lbTenDU.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lbTenDU.setForeground(new java.awt.Color(153, 0, 0));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Size: (*)");

        txtSize.setBackground(new java.awt.Color(196, 196, 196));
        txtSize.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtSize.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cboMaLoai, javax.swing.GroupLayout.Alignment.LEADING, 0, 199, Short.MAX_VALUE)
                            .addComponent(txtGiaTien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenDU, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaDU, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSize, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbMaDU, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(lbTenDU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbGiaTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(lbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaDU, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(lbMaDU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTenDU, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbTenDU, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGiaTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(106, 106, 106))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thêm món mới");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 572, Short.MAX_VALUE)
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
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int a = Integer.parseInt(txtMaDU.getText());
        if (a < maNV) {
            updateSP();
        } else {
            themSP();
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

    private void txtMaDUKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaDUKeyPressed
        int a = Integer.parseInt(txtMaDU.getText());
        if (a >= maNV) {
            MsgBox.alert(this, "Sản phẩm chưa được thêm");
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                txtTenDU.setText(selectTen(Integer.parseInt(txtMaDU.getText())));
                txtGiaTien.setText(String.valueOf(selectGia(Integer.parseInt(txtMaDU.getText()))));
                txtSize.setText(selectSize(Integer.parseInt(txtMaDU.getText())));
                txtMoTa.setText(selectMota(Integer.parseInt(txtMaDU.getText())));
                lbImg.setText("");
                lbImg.setIcon(new ImageIcon(selectHinh(Integer.parseInt(txtMaDU.getText()))));
            }
        }

    }//GEN-LAST:event_txtMaDUKeyPressed

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
            java.util.logging.Logger.getLogger(ThemSPJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemSPJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemSPJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemSPJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThemSPJDialog dialog = new ThemSPJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cboMaLoai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbGiaTien;
    private javax.swing.JLabel lbImg;
    private javax.swing.JLabel lbMaDU;
    private javax.swing.JLabel lbSize;
    private javax.swing.JLabel lbTenDU;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtMaDU;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtTenDU;
    // End of variables declaration//GEN-END:variables
}
