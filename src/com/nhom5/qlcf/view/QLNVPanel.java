/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom5.qlcf.view;

import com.nhom5.qlcf.dao.jdbc;
import com.nhom5.qlcf.main.ThemNVJDialog;
import com.nhom5.qlcf.model.NhanVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tinh
 */
public class QLNVPanel extends javax.swing.JPanel {

    int index = -1;
    String head[] = {"Mã nhân viên", "Họ tên", "Lương", "Email", "Giới tính", "CCCD", "Số điện thoại", "Địa chỉ", "Hình", "Trạng thái làm việc"};
    DefaultTableModel model = new DefaultTableModel(head, 0) {
        @Override
        public boolean isCellEditable(int i, int i1) {
            return false;
        }
    };
    List<NhanVien> list = new ArrayList<>();

    public QLNVPanel() {
        initComponents();
        fillTable();
    }

    public void goiHam() {
        fillTable();
    }

    public void fillTable() {
        list.clear();
        model.setRowCount(0);
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "Select * from Nhan_vien";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getInt("Ma_nhan_vien"));
                nv.setTenNV(rs.getString("Ten"));
                nv.setLuongNV(rs.getDouble("Luong"));
                nv.setEmail(rs.getString("Email"));
                nv.setGioiTinh(rs.getBoolean("Gioi_tinh"));
                nv.setCCCD(rs.getString("CCCD"));
                nv.setSDT(rs.getString("So_Dien_Thoai"));
                nv.setDiaChi(rs.getString("Dia_chi"));
                nv.setHinh(rs.getString("Hinh"));
                nv.setTrangThaiLamViec(rs.getBoolean("Trang_thai_lam_viec"));
                list.add(nv);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        for (NhanVien nv : list) {
            Vector row = new Vector();
            row.add(nv.getMaNV());
            row.add(nv.getTenNV());
            row.add(nv.getLuongNV());
            row.add(nv.getEmail());
            if (nv.isGioiTinh() == true) {
                row.add("Nam");
            } else {
                row.add("Nữ");
            }
            row.add(nv.getCCCD());
            row.add(nv.getSDT());
            row.add(nv.getDiaChi());
            row.add(nv.getHinh());
            if (nv.isTrangThaiLamViec() == true) {
                row.add("Đang làm việc");
            } else {
                row.add("Đã nghỉ việc");
            }
            model.addRow(row);
        }
        tbl1.setModel(model);
    }

    public void timNV() {
        list.clear();
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "Select * from Nhan_Vien where Ten like N'%" + txtSearch.getText() + "%'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getInt("Ma_nhan_vien"));
                nv.setTenNV(rs.getString("Ten"));
                nv.setLuongNV(rs.getDouble("Luong"));
                nv.setEmail(rs.getString("Email"));
                nv.setGioiTinh(rs.getBoolean("Gioi_tinh"));
                nv.setCCCD(rs.getString("CCCD"));
                nv.setSDT(rs.getString("So_Dien_Thoai"));
                nv.setDiaChi(rs.getString("Dia_chi"));
                nv.setHinh(rs.getString("Hinh"));
                nv.setTrangThaiLamViec(rs.getBoolean("Trang_thai_lam_viec"));
                list.add(nv);
            }
            model.setRowCount(0);
            for (NhanVien nv : list) {
                Vector row = new Vector();
                row.add(nv.getMaNV());
                row.add(nv.getTenNV());
                row.add(nv.getLuongNV());
                row.add(nv.getEmail());
                if (nv.isGioiTinh() == true) {
                    row.add("Nam");
                } else {
                    row.add("Nữ");
                }
                row.add(nv.getCCCD());
                row.add(nv.getSDT());
                row.add(nv.getDiaChi());
                row.add("Đang cập nhật");
                //row.add(nv.getHinh());
                row.add("Đang làm việc");
                model.addRow(row);
            }
            tbl1.setModel(model);
            txtSearch.setText("");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void xoaNhanVien() {
        int[] selectedRows = tbl1.getSelectedRows();
        if (selectedRows.length > 0) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                int selectedIndex = selectedRows[i];
                int modelIndex = tbl1.convertRowIndexToModel(selectedIndex);
                NhanVien nv = list.get(modelIndex);

                try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
                    String deleteSQL = "DELETE FROM Nhan_Vien WHERE Ma_nhan_vien = " + nv.getMaNV();
                    stm.executeUpdate(deleteSQL);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                model.removeRow(modelIndex);
                list.remove(nv);
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không có hàng nào được chọn để xóa.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jpnRoot.setBackground(new java.awt.Color(220, 190, 169));
        jpnRoot.setPreferredSize(new java.awt.Dimension(783, 0));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Xóa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Thêm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl1);

        jLabel3.setBackground(new java.awt.Color(220, 190, 169));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("DANH SÁCH");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Tên NV:");

        jButton2.setText("Tìm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(220, 190, 169));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("TRA CỨU NHÂN VIÊN");

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnRootLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(862, 862, 862))
                    .addGroup(jpnRootLayout.createSequentialGroup()
                        .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnRootLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1329, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(459, Short.MAX_VALUE))))
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnRootLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(jButton2))
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, 1888, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (txtSearch.getText().equals("")) {
            fillTable();
        } else {
            timNV();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new ThemNVJDialog(null, false).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        xoaNhanVien();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
