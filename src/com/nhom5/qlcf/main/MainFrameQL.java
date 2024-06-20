/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nhom5.qlcf.main;

import com.nhom5.qlcf.controller.ChuyenFrame;
import com.nhom5.qlcf.controller.DanhMuc;
import com.nhom5.qlcf.ultity.Auth;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Tinh
 */
public class MainFrameQL extends javax.swing.JFrame {
    
    

    public MainFrameQL() {
        initComponents();
        this.setLocationRelativeTo(null);
        setExtendedState(MAXIMIZED_BOTH);
        ChuyenFrame control = new ChuyenFrame(jpnView);
        List<DanhMuc> item = new ArrayList<>();
        item.add(new DanhMuc("QuanLy", jpnQL, jblQL));
        item.add(new DanhMuc("BanHang", jpnBH, jblBH));
        item.add(new DanhMuc("ThongKe", jpnTK, jblTK));
        control.setEvent(item);
        jlbTenNV.setText(Auth.userNhanVien.getTenNV());
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jpnQL = new javax.swing.JPanel();
        jblQL = new javax.swing.JLabel();
        jpnBH = new javax.swing.JPanel();
        jblBH = new javax.swing.JLabel();
        jpnTK = new javax.swing.JPanel();
        jblTK = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlbTenNV = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnRoot.setBackground(new java.awt.Color(60, 49, 49));

        jpnMenu.setBackground(new java.awt.Color(60, 49, 49));

        jpnQL.setBackground(new java.awt.Color(60, 49, 49));

        jblQL.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jblQL.setForeground(new java.awt.Color(255, 255, 255));
        jblQL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblQL.setText("QUẢN LÝ");
        jblQL.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jpnQLLayout = new javax.swing.GroupLayout(jpnQL);
        jpnQL.setLayout(jpnQLLayout);
        jpnQLLayout.setHorizontalGroup(
            jpnQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jblQL, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnQLLayout.setVerticalGroup(
            jpnQLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnQLLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jblQL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnBH.setBackground(new java.awt.Color(60, 49, 49));

        jblBH.setBackground(new java.awt.Color(60, 49, 49));
        jblBH.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jblBH.setForeground(new java.awt.Color(255, 255, 255));
        jblBH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblBH.setText("BÁN HÀNG");
        jblBH.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jpnBHLayout = new javax.swing.GroupLayout(jpnBH);
        jpnBH.setLayout(jpnBHLayout);
        jpnBHLayout.setHorizontalGroup(
            jpnBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jblBH, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnBHLayout.setVerticalGroup(
            jpnBHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jblBH, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnTK.setBackground(new java.awt.Color(60, 49, 49));
        jpnTK.setPreferredSize(new java.awt.Dimension(139, 63));

        jblTK.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jblTK.setForeground(new java.awt.Color(255, 255, 255));
        jblTK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblTK.setText("THỐNG KÊ");
        jblTK.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jpnTKLayout = new javax.swing.GroupLayout(jpnTK);
        jpnTK.setLayout(jpnTKLayout);
        jpnTKLayout.setHorizontalGroup(
            jpnTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTKLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jblTK, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnTKLayout.setVerticalGroup(
            jpnTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTKLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jblTK, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ĐĂNG XUẤT");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jlbTenNV.setBackground(new java.awt.Color(255, 255, 255));
        jlbTenNV.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jlbTenNV.setForeground(new java.awt.Color(255, 255, 255));
        jlbTenNV.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlbTenNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom5/qlcf/img/user.png"))); // NOI18N

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jpnQL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jLabel5)
                .addGap(15, 15, 15))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMenuLayout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMenuLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpnQL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jpnTK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnView.setBackground(new java.awt.Color(220, 190, 169));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom5/qlcf/img/logo2.png"))); // NOI18N

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnViewLayout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(jLabel1)
                .addContainerGap(310, Short.MAX_VALUE))
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnViewLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel1)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        int a = JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn đăng xuất","Thoát",JOptionPane.OK_CANCEL_OPTION);
        if(a == JOptionPane.OK_OPTION){
            this.setVisible(false);
            new DangNhapJDialog(null,true).setVisible(true);
        }
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(MainFrameQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrameQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrameQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrameQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrameQL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jblBH;
    private javax.swing.JLabel jblQL;
    private javax.swing.JLabel jblTK;
    public javax.swing.JLabel jlbTenNV;
    private javax.swing.JPanel jpnBH;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnQL;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnTK;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
