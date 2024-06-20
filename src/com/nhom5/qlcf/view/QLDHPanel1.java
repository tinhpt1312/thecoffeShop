/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom5.qlcf.view;

import com.nhom5.qlcf.dao.jdbc;
import com.nhom5.qlcf.model.DoUong;
import com.nhom5.qlcf.model.DonHang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tinh
 */
public class QLDHPanel1 extends javax.swing.JPanel {

    int index = -1;
    String head[] = {"Mã đơn hàng", "Ngày đặt hàng", "Tên đồ uống", "Tổng tiền", "Hình thức", "Ghi chú", "Mã khách hàng", "Nhân viên"};
    DefaultTableModel model = new DefaultTableModel(head, 0);
    List<DonHang> list = new ArrayList<>();

    public QLDHPanel1() {
        initComponents();
        fillTable();
    }

    public void fillTable() {
        list.clear();
        model.setRowCount(0);
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "Select * from Don_hang";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                DonHang dh = new DonHang();
                dh.setMaDonHang(rs.getInt("Ma_don_hang"));
                dh.setNgayDatHang(rs.getDate("Ngay_dat_hang"));
                dh.setMaHinhThuc(rs.getString("Ma_hinh_thuc"));
                dh.setGhiChu(rs.getString("Ghi_chu"));
                dh.setMaKhachHang(rs.getInt("Ma_khach_hang"));
                dh.setMaNhanVien(rs.getInt("Ma_nhan_vien"));
                list.add(dh);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        for (DonHang dh : list) {
            Vector row = new Vector();
            row.add(dh.getMaDonHang());
            row.add(dh.getNgayDatHang());
            row.add(dh.getTenDoUong());
            row.add(dh.getTongTien());
            row.add(dh.getMaHinhThuc());
            row.add(dh.getGhiChu());
            row.add(dh.getMaKhachHang());
            row.add(dh.getMaNhanVien());
            model.addRow(row);
        }
        tbl1.setModel(model);
    }

    public void timDH() {
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "Select * from Don_Hang where Ma_don_hang like N'%" + txtSearch.getText() + "%'";
            ResultSet rs = stm.executeQuery(sql);
            list.clear();
            while (rs.next()) {
                DonHang dh = new DonHang();
                dh.setMaDonHang(rs.getInt("Ma_don_hang"));
                dh.setNgayDatHang(rs.getDate("Ngay_dat_hang"));
                dh.setTenDoUong(rs.getString("Ten_do_uong"));
                dh.setTongTien((float) rs.getDouble("Tong_tien"));
                dh.setMaHinhThuc(rs.getString("Ma_hinh_thuc"));
                dh.setGhiChu(rs.getString("Ghi_chu"));
                dh.setMaKhachHang(rs.getInt("Ma_khach_hang"));
                dh.setMaNhanVien(rs.getInt("Ma_nhan_vien"));
                list.add(dh);
            }
            model.setRowCount(0);
            for (DonHang dh : list) {
                Vector row = new Vector();
                row.add(dh.getMaDonHang());
                row.add(dh.getNgayDatHang());
                row.add(dh.getTenDoUong());
                row.add(dh.getTongTien());
                row.add(dh.getMaHinhThuc());
                row.add(dh.getGhiChu());
                row.add(dh.getMaKhachHang());
                row.add(dh.getMaNhanVien());
                model.addRow(row);
            }
            tbl1.setModel(model);
            txtSearch.setText("");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jpnRoot.setBackground(new java.awt.Color(220, 190, 169));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("TRA CỨU ĐƠN HÀNG");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tên đơn hàng:");

        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("DANH SÁCH ĐƠN HÀNG");

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Xóa");

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnRootLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButton1))
                    .addGroup(jpnRootLayout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnRootLayout.createSequentialGroup()
                                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(700, 700, 700))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnRootLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(400, Short.MAX_VALUE))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        timDH();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
