/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom5.qlcf.view;

import com.nhom5.qlcf.dao.jdbc;
import com.nhom5.qlcf.model.DoUong;
import com.nhom5.qlcf.model.NhanVien;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Tinh
 */
public class QLSPPanel extends javax.swing.JPanel {

    int index = -1;
    String head[] = {"Mã đồ uống", "Tên đồ uống", "Size", "Mã loại", "Giá tiền", "Mô tả", "Giảm giá", "Hinh"};
    DefaultTableModel model = new DefaultTableModel(head, 0);
    List<DoUong> list = new ArrayList<>();

    public QLSPPanel() {
        initComponents();
        fillTable();
    }

    public void fillTable() {
        list.clear();
        model.setRowCount(0);
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "Select * from Do_Uong";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                DoUong du = new DoUong();
                du.setMaDoUong(rs.getInt("Ma_do_uong"));
                du.setTenDoUong(rs.getString("Ten_do_uong"));
                du.setSizeDoUong(rs.getString("Size_do_uong"));
                du.setMaLoai(rs.getString("Ma_loai"));
                du.setGiaTien(rs.getDouble("Gia_tien"));
                du.setMoTa(rs.getString("Mo_Ta"));
                du.setGiamGia(rs.getString("Giam_gia"));
                du.setHinh(rs.getString("Hinh"));
                list.add(du);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        for (DoUong du : list) {
            Vector row = new Vector();
            row.add(du.getMaDoUong());
            row.add(du.getTenDoUong());
            row.add(du.getSizeDoUong());
            row.add(du.getMaLoai());
            row.add(du.getGiaTien());
            row.add(du.getMoTa());
            row.add(du.getGiamGia());
            row.add(du.getHinh());
            model.addRow(row);
        }
        tbl1.setModel(model);
    }

    public void timSP() {
        try (Connection con = jdbc.openConnection();Statement stm = con.createStatement();) {
            String sql = "Select * from Do_Uong where Ten_do_uong like N'%"+ txtSearch.getText() +"%'";
            ResultSet rs = stm.executeQuery(sql);
            list.clear();
            while (rs.next()) {
                DoUong du = new DoUong();
                du.setMaDoUong(rs.getInt("Ma_do_uong"));
                du.setTenDoUong(rs.getString("Ten_do_uong"));
                du.setSizeDoUong(rs.getString("Size_do_uong"));
                du.setMaLoai(rs.getString("Ma_loai"));
                du.setGiaTien(rs.getDouble("Gia_tien"));
                du.setMoTa(rs.getString("Mo_Ta"));
                du.setGiamGia(rs.getString("Giam_gia"));
                du.setHinh(rs.getString("Hinh"));
                list.add(du);
            }
            model.setRowCount(0);
            for (DoUong du : list) {
                Vector row = new Vector();
                row.add(du.getMaDoUong());
                row.add(du.getTenDoUong());
                row.add(du.getSizeDoUong());
                row.add(du.getMaLoai());
                row.add(du.getGiaTien());
                row.add(du.getMoTa());
                row.add(du.getGiamGia());
                row.add(du.getHinh());
                model.addRow(row);
            }
            tbl1.setModel(model);
            txtSearch.setText("");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public void xoaSP(){
        int[] selectedRows = tbl1.getSelectedRows();
        if (selectedRows.length > 0) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                int selectedIndex = selectedRows[i];
                int modelIndex = tbl1.convertRowIndexToModel(selectedIndex);
                DoUong du = list.get(modelIndex);
                try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
                    String deleteSQL = "DELETE FROM Do_Uong WHERE Ma_do_uong = " + du.getMaDoUong();
                    stm.executeUpdate(deleteSQL);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                model.removeRow(modelIndex);
                list.remove(du);
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                fillTable();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không có hàng nào được chọn để xóa.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(0, 758));

        jpnRoot.setBackground(new java.awt.Color(220, 190, 169));
        jpnRoot.setPreferredSize(new java.awt.Dimension(783, 0));

        jLabel3.setBackground(new java.awt.Color(220, 190, 169));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("DANH SÁCH");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Tên sản phẩm:");

        jButton2.setText("Tìm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã đồ uống", "Tên đồ uống", "Size", "Mã loại", "GIá tiền", "Mô tả", "Giảm giá", "Hình"
            }
        ));
        jScrollPane1.setViewportView(tbl1);

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

        jLabel4.setBackground(new java.awt.Color(220, 190, 169));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("TRA CỨU SẢN PHẨM");

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnRootLayout.createSequentialGroup()
                        .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnRootLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnRootLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jButton2))
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1331, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, 1437, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        timSP();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new com.nhom5.qlcf.main.ThemSPJDialog(null,false).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        xoaSP();
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
    public javax.swing.JTable tbl1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
