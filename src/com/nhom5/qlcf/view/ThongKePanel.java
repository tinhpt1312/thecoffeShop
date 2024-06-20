/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom5.qlcf.view;

import com.nhom5.qlcf.dao.ThongKeDAO;
import com.nhom5.qlcf.dao.DonHangDAO;
import com.nhom5.qlcf.ultity.ExcelUltils;
import com.nhom5.qlcf.model.DonHang;
import com.nhom5.qlcf.ultity.MsgBox;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Workbook;

public class ThongKePanel extends javax.swing.JPanel {

    /**
     * Creates new form ThongKePanel
     */
    public ThongKePanel() {
        initComponents();
//        fillComboboxNam();
//        fillComboboxThang();
//        fillTableDoanhThu();
        fillTableNhanVien();
    }

    DefaultTableModel tableModel;
    DefaultComboBoxModel comboBoxModel;
    ThongKeDAO thongKeDAO = new ThongKeDAO();
    DonHangDAO donHangDAO = new DonHangDAO();

//    void fillComboboxNam() {
//        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) cboxThongKeTheoNam.getModel();
//        comboBoxModel.removeAllElements();
//        List<Integer> list = donHangDAO.selectYears();
//        for (Integer nam : list) {
//            comboBoxModel.addElement(nam);
//        }
//    }
//
//    void fillComboboxThang() {
//        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) cboxThongKeTheoThang.getModel();
//        comboBoxModel.removeAllElements();
//        List<Integer> list = donHangDAO.selectMonths();
//        for (Integer thang : list) {
//            comboBoxModel.addElement(thang);
//        }
//    }
    
    void fillTableNhanVien(){
        try {
            DefaultTableModel model = (DefaultTableModel) tableLuongNhanVien.getModel();
            model.setRowCount(0);
            List<Object[]> list = thongKeDAO.getLuongNhanVien();
            for (Object[] row : list) {
                model.addRow(row);
            }
           
        } catch (Exception e) {
            
        }
    }
    void TimkiemLuongNhanVien(){
        try {
            DefaultTableModel model = (DefaultTableModel) tableLuongNhanVien.getModel();
            model.setRowCount(0);
            List<Object[]> list = thongKeDAO.TimNhanVienTheoTen(txtTimKiemNhanVien.getText());
            for (Object[] row : list) {
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void fillTableDoanhThu() {
        try {
            DefaultTableModel model = (DefaultTableModel) tblDoanhThuSanPham.getModel();
            model.setRowCount(0);
            String ThoiGian1 = txtThoiGian1.getText();
            String ThoiGian2 = txtThoiGian2.getText();
            List<Object[]> list = thongKeDAO.getDoanhThu(ThoiGian1, ThoiGian2);
            for (Object[] row : list) {
                model.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    private void chooseDirectoryToSave(Workbook workbook) {
        JFileChooser choose = new JFileChooser();
        int x = choose.showSaveDialog(null);
        if (x == JFileChooser.APPROVE_OPTION) {
            try {
                String file = choose.getSelectedFile().getAbsolutePath().toString();
                FileOutputStream outFile = new FileOutputStream(file);
                workbook.write(outFile);
                workbook.close();
                outFile.close();
                MsgBox.alert(this, "Xuất tệp Excel thành công!");
            } catch (IOException ex) {
                Logger.getLogger(ThongKePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiemNhanVien = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLuongNhanVien = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDoanhThuSanPham = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtThoiGian1 = new javax.swing.JTextField();
        txtThoiGian2 = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();

        jpnRoot.setBackground(new java.awt.Color(220, 190, 169));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(220, 190, 169));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(150, 0, 0));
        jLabel1.setText("Tên Nhân Viên:");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Lọc");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tableLuongNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Chức vụ", "Giờ làm", "Lương", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(tableLuongNhanVien);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addComponent(txtTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1770, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTimKiemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                .addGap(115, 115, 115))
        );

        jTabbedPane1.addTab("Lương nhân viên", jPanel1);

        jPanel2.setBackground(new java.awt.Color(220, 190, 169));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(150, 0, 0));
        jLabel2.setText("Từ: ");

        tblDoanhThuSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên đồ uống", "Doanh Thu", "Thấp nhất", "Cao nhất", "Trung bình"
            }
        ));
        jScrollPane2.setViewportView(tblDoanhThuSanPham);

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton6.setText("Xuất file Excel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(150, 0, 0));
        jLabel3.setText("Đến:");

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThoiGian1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtThoiGian2, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTim))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1044, 1044, 1044)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1664, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(232, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(txtThoiGian2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTim)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(txtThoiGian1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jTabbedPane1.addTab("Doanh thu", jPanel2);

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
//        try {
//
//            Workbook workBook = ExcelUltils.printBangDoanhThuToExcel(tblDoanhThuSanPham, cboxThongKeTheoNam, cboxThongKeTheoThang, thongKeDAO);
//            this.chooseDirectoryToSave(workBook);
//            Logger.getLogger(ThongKePanel.class.getName()).log(Level.INFO,
//                    "Xuất file doanh thu của quán cà phê thành công!");
//        } catch (IOException ex) {
//            Logger.getLogger(ThongKePanel.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TimkiemLuongNhanVien();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        fillTableDoanhThu();
    }//GEN-LAST:event_btnTimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTim;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JTable tableLuongNhanVien;
    private javax.swing.JTable tblDoanhThuSanPham;
    private javax.swing.JTextField txtThoiGian1;
    private javax.swing.JTextField txtThoiGian2;
    private javax.swing.JTextField txtTimKiemNhanVien;
    // End of variables declaration//GEN-END:variables
}
