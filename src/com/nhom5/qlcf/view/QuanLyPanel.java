/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom5.qlcf.view;

import com.nhom5.qlcf.controller.ChuyenFrame;
import com.nhom5.qlcf.controller.DanhMuc;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tinh
 */
public class QuanLyPanel extends javax.swing.JPanel {

    public QuanLyPanel() {
        initComponents();
        ChuyenFrame control = new ChuyenFrame(jpnView);
        List<DanhMuc> item = new ArrayList<>();
        item.add(new DanhMuc("SanPham",jpnSP,jlbSP));
        item.add(new DanhMuc("NhanVien",jpnNV,jlbNV));
        item.add(new DanhMuc("DonHang",jpnDH,jlbDH));
        control.setEventQL(item);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnSlideBar = new javax.swing.JPanel();
        jpnSP = new javax.swing.JPanel();
        jlbSP = new javax.swing.JLabel();
        jpnNV = new javax.swing.JPanel();
        jlbNV = new javax.swing.JLabel();
        jpnDH = new javax.swing.JPanel();
        jlbDH = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jpnDecor = new javax.swing.JPanel();
        jpnView = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(0, 758));

        jpnRoot.setPreferredSize(new java.awt.Dimension(0, 758));

        jpnSlideBar.setBackground(new java.awt.Color(220, 190, 169));

        jpnSP.setBackground(new java.awt.Color(255, 255, 255));

        jlbSP.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbSP.setForeground(new java.awt.Color(0, 0, 0));
        jlbSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbSP.setText("SẢN PHẨM");

        javax.swing.GroupLayout jpnSPLayout = new javax.swing.GroupLayout(jpnSP);
        jpnSP.setLayout(jpnSPLayout);
        jpnSPLayout.setHorizontalGroup(
            jpnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnSPLayout.setVerticalGroup(
            jpnSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbSP, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnNV.setBackground(new java.awt.Color(225, 255, 255));
        jpnNV.setPreferredSize(new java.awt.Dimension(238, 106));

        jlbNV.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbNV.setForeground(new java.awt.Color(0, 0, 0));
        jlbNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbNV.setText("NHÂN VIÊN");
        jlbNV.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlbNV.setPreferredSize(new java.awt.Dimension(129, 32));

        javax.swing.GroupLayout jpnNVLayout = new javax.swing.GroupLayout(jpnNV);
        jpnNV.setLayout(jpnNVLayout);
        jpnNVLayout.setHorizontalGroup(
            jpnNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnNVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbNV, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnNVLayout.setVerticalGroup(
            jpnNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbNV, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnDH.setBackground(new java.awt.Color(255, 255, 255));
        jpnDH.setPreferredSize(new java.awt.Dimension(238, 106));

        jlbDH.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jlbDH.setForeground(new java.awt.Color(0, 0, 0));
        jlbDH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbDH.setText("ĐƠN HÀNG");

        javax.swing.GroupLayout jpnDHLayout = new javax.swing.GroupLayout(jpnDH);
        jpnDH.setLayout(jpnDHLayout);
        jpnDHLayout.setHorizontalGroup(
            jpnDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbDH, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnDHLayout.setVerticalGroup(
            jpnDHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbDH, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom5/qlcf/img/logo1.png"))); // NOI18N

        javax.swing.GroupLayout jpnSlideBarLayout = new javax.swing.GroupLayout(jpnSlideBar);
        jpnSlideBar.setLayout(jpnSlideBarLayout);
        jpnSlideBarLayout.setHorizontalGroup(
            jpnSlideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSlideBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnSlideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpnSlideBarLayout.createSequentialGroup()
                        .addGroup(jpnSlideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpnNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnSlideBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jpnSlideBarLayout.setVerticalGroup(
            jpnSlideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSlideBarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jpnSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        jpnDecor.setBackground(new java.awt.Color(60, 49, 49));

        javax.swing.GroupLayout jpnDecorLayout = new javax.swing.GroupLayout(jpnDecor);
        jpnDecor.setLayout(jpnDecorLayout);
        jpnDecorLayout.setHorizontalGroup(
            jpnDecorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jpnDecorLayout.setVerticalGroup(
            jpnDecorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jpnView.setBackground(new java.awt.Color(220, 190, 169));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnSlideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnDecor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnDecor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnSlideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlbDH;
    private javax.swing.JLabel jlbNV;
    private javax.swing.JLabel jlbSP;
    private javax.swing.JPanel jpnDH;
    private javax.swing.JPanel jpnDecor;
    private javax.swing.JPanel jpnNV;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnSP;
    private javax.swing.JPanel jpnSlideBar;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
