/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.nhom5.qlcf.main;

import com.nhom5.qlcf.dao.jdbc;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import java.sql.*;

public class QuenMKJDialog extends javax.swing.JDialog {

    public QuenMKJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public int returnEmail() {
        int count = 0;
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            ResultSet rs = stm.executeQuery("Select Email from Nhan_Vien where Email like '" + txtEmail.getText() + "'");
            while (rs.next()) {
                count++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }

    public String returnTK(String email) {
        String user = "";
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            ResultSet rs = stm.executeQuery("Select Ten_DN from Nhan_Vien where Email like '" + email + "'");
            while (rs.next()) {
                user = rs.getString("Ten_DN");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    public String returnMK(String email) {
        String pass = "";
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            ResultSet rs = stm.executeQuery("Select MK from Nhan_Vien where Email like '" + email + "'");
            while (rs.next()) {
                pass = rs.getString("MK");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return pass;
    }

    public void check() {
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", 587);
        final String accountName = "phamthetinhcop1312@gmail.com";
        final String accountPass = "nqokqttfzhnwqkbb";
        Session s;
        s = Session.getInstance(p,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(accountName, accountPass);
            }
        });
        String to = txtEmail.getText().trim();
        Message msg = new MimeMessage(s);
        if (to.equals("")) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mail để check lại mk");
        } else {
            if (returnEmail() == 0) {
                JOptionPane.showMessageDialog(null, "Email không có trong danh sách");
            } else {
                try {
                    msg.setFrom(new InternetAddress(accountName));
                    msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    msg.setSubject("Thông báo đổi mật khẩu");
                    msg.setText("Yêu cầu đổi mật khẩu của Mã NV: " + returnTK(to) + " và Password: " + returnMK(to) + ".Nếu bạn muốn đổi mật khẩu. Xin vui lòng liên hệ Admin của hệ thống!");
                    Transport.send(msg);
                    JOptionPane.showMessageDialog(this, "Mail was sent successfully");
                    this.setVisible(false);
                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(220, 190, 169));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Khôi phục mật khẩu");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nhập email của bạn:");

        jButton1.setText("Xác nhận");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Hủy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn thoát", "Xác nhận", JOptionPane.OK_CANCEL_OPTION);
        if (a == JOptionPane.OK_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        check();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(QuenMKJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuenMKJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuenMKJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuenMKJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuenMKJDialog dialog = new QuenMKJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
