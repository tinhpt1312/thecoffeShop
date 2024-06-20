/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.nhom5.qlcf.main;


import com.nhom5.qlcf.dao.NhanVienDAO;
import com.nhom5.qlcf.model.NhanVien;
import com.nhom5.qlcf.ultity.Auth;
import com.nhom5.qlcf.ultity.MsgBox;
import com.nhom5.qlcf.ultity.SHA256;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class DangNhapJDialog extends javax.swing.JDialog {

    NhanVienDAO dao = new NhanVienDAO();

    public DangNhapJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("ĐĂNG NHẬP");
        setLocationRelativeTo(null);
        txtUsername.setText("tinhpt");
        txtPassword.setText("1312");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(248, 229, 229));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(248, 229, 229));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tài khoản :");

        txtUsername.setBackground(new java.awt.Color(248, 229, 229));
        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(0, 0, 0));
        txtUsername.setBorder(null);
        txtUsername.setMargin(new java.awt.Insets(2, 6, 2, 15));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Mật khẩu : ");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Đăng nhập");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Thoát");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Quên mật khẩu ?");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        txtPassword.setBackground(new java.awt.Color(248, 229, 229));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setBorder(null);
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator1)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(94, 94, 94)
                            .addComponent(jButton1)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel5)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(200, 190, 169));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nhom5/qlcf/img/logo1.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("6 anh em Siêu Nhân");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void checkLogin() {
        String manv = txtUsername.getText();
        String matKhau = new String(txtPassword.getPassword());
        String matKhauMaHoa = SHA256.sha256(matKhau);
        NhanVien nhanVien = dao.selectByDN(manv);
        if (nhanVien == null) {
            MsgBox.alert(this, "Sai tên đăng nhập hoặc mật khẩu!");
        } else if (!matKhauMaHoa.equals(nhanVien.getMK())) {
            MsgBox.alert(this, "Sai tên đăng nhập hoặc mật khẩu!");
        } else {
            MsgBox.alert(this, "Đăng nhập thành công");
            Auth.userNhanVien = nhanVien;
            this.dispose();
            MainFrameQL main = new MainFrameQL();
            main.setVisible(true);
        }
    }

    void ketThuc() {
        if (MsgBox.confirm(this, "Bạn muốn kết thúc ứng dụng?")) {
            System.exit(0);
        }
    }

    public boolean validateForm() {
        if (txtUsername.getText().isEmpty()) {
            txtUsername.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Username không được để trống!");
            txtUsername.requestFocus();
            return false;
        } else {
            Pattern pMaNV = Pattern.compile("^[a-z]+$");
            Matcher mMaNV = pMaNV.matcher(txtUsername.getText());
            if (!mMaNV.matches()) {
                JOptionPane.showMessageDialog(this, "Username nhập sai định dạng");
                txtUsername.requestFocus();
                txtUsername.setBackground(Color.pink);
                return false;
            } else {
                txtUsername.setBackground(new Color(248, 229, 229));
            }
        }

        if (txtPassword.getText().isEmpty()) {
            txtPassword.setBackground(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Password không được để trống!");
            txtPassword.requestFocus();
            return false;
        } else {
            txtPassword.setBackground(new Color(248, 229, 229));
        }
        return true;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn thoát", "Thoát", JOptionPane.OK_CANCEL_OPTION);
        if (a == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (validateForm()) {
            checkLogin();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            checkLogin();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        new QuenMKJDialog(null, true).setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

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
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhapJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChaoJDialog(null, true).setVisible(true);
                DangNhapJDialog dialog = new DangNhapJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
