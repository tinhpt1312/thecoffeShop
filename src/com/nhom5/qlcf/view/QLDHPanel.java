/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom5.qlcf.view;

import com.nhom5.qlcf.dao.jdbc;
import com.nhom5.qlcf.dao.ThongKeDAO;
import com.nhom5.qlcf.model.DoUong;
import com.nhom5.qlcf.model.DonHang;
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
public class QLDHPanel extends javax.swing.JPanel {

    String head[] = {"Mã đơn hàng", "Ngày đặt hàng", "Hình thức", "Ghi chú", "Mã khách hàng", "Mã nhân viên"};
    String headChiTietDonHang[] = {"Tên đồ uống","Size đồ uống","Tên loại","Tên khách hàng","Tên nhân viên","Số lượng","Giá tiền","Tổng tiền" };
    DefaultTableModel model = new DefaultTableModel(head, 0){
        @Override
        public boolean isCellEditable(int i, int i1){
            return false;
        }
    };
    DefaultTableModel modelChiTiet = new DefaultTableModel(headChiTietDonHang, 0);
    List<DonHang> list = new ArrayList<>();
    ThongKeDAO thongKeDAO = new ThongKeDAO();
    public QLDHPanel() {
        initComponents();
        fillTable();
        tableChiTietDonHang.setModel(modelChiTiet);
    }
    
    public void fillTable() {
        list.clear();
        model.setRowCount(0);
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "Select * from Don_Hang";
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
            row.add(dh.getMaHinhThuc());
            row.add(dh.getGhiChu());
            row.add(dh.getMaKhachHang());
            row.add(dh.getMaNhanVien());
            model.addRow(row);
        }
        tbl1.setModel(model);
    }
    void fillTableChiTietDonHang(int MaDonHang){
//        modelChiTiet = (DefaultTableModel) tableChiTietDonHang.getModel();
        modelChiTiet.setRowCount(0);
        lbChiTietMaDonHang.setText(String.valueOf(MaDonHang));
        try {
            DefaultTableModel model = (DefaultTableModel) tableChiTietDonHang.getModel();
            model.setRowCount(0);
            List<Object[]> list = thongKeDAO.showChiTietDonHang(MaDonHang);
            for (Object[] row : list) {
                modelChiTiet.addRow(row);
            }
            TongChiTietDonHang();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    void TongChiTietDonHang(){
         Object tien = null;
        int column = 7; // Chọn cột thứ 8 (chỉ số cột tính từ 0)
        Double TongTien = 0.0;
        for (int row = 0; row < tableChiTietDonHang.getRowCount(); row++) {
            tien = tableChiTietDonHang.getValueAt(row, column);
            TongTien += Double.valueOf((String) tien);

        }
        LbTongChiTietDonHang.setText(String.valueOf(TongTien)+"00 VND");
    }
    public void timDH() {
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "Select * from Don_Hang where Ma_don_hang = " + txtSearch.getText() ;
            ResultSet rs = stm.executeQuery(sql);
            list.clear();
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
            model.setRowCount(0);
            for (DonHang dh : list) {
                Vector row = new Vector();
                row.add(dh.getMaDonHang());
                row.add(dh.getNgayDatHang());
                row.add(dh.getMaHinhThuc());
                row.add(dh.getGhiChu());
                row.add(dh.getMaKhachHang());
                row.add(dh.getMaNhanVien());
                model.addRow(row);
            }
            fillTableChiTietDonHang(Integer.valueOf(txtSearch.getText()));
        txtSearch.setText("");
            tbl1.setModel(model);
        } catch (Exception e) {
            System.out.println(e);
            fillTable();
            modelChiTiet.setRowCount(0);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tableChiTietDonHang = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LbTongChiTietDonHang = new javax.swing.JLabel();
        lbChiTietMaDonHang = new javax.swing.JLabel();

        jpnRoot.setBackground(new java.awt.Color(220, 190, 169));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("TRA CỨU ĐƠN HÀNG");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tìm mã đơn hàng");

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
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl1);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("DANH SÁCH ĐƠN HÀNG");

        tableChiTietDonHang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableChiTietDonHang);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("CHI TIẾT ĐƠN HÀNG: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("TỔNG: ");

        LbTongChiTietDonHang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LbTongChiTietDonHang.setForeground(new java.awt.Color(0, 0, 0));
        LbTongChiTietDonHang.setText("XXXX");

        lbChiTietMaDonHang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbChiTietMaDonHang.setForeground(new java.awt.Color(153, 0, 0));
        lbChiTietMaDonHang.setText("Mã đơn hàng");

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnRootLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButton1))
                    .addComponent(jLabel1)
                    .addGroup(jpnRootLayout.createSequentialGroup()
                        .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnRootLayout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnRootLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbChiTietMaDonHang))
                                    .addGroup(jpnRootLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(37, 37, 37)
                                        .addComponent(LbTongChiTietDonHang))))
                            .addGroup(jpnRootLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(27, 27, 27)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(lbChiTietMaDonHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(LbTongChiTietDonHang))
                .addContainerGap(169, Short.MAX_VALUE))
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

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() ==2 ){
            int index = tbl1.getSelectedRow();
            int val = (int) tbl1.getValueAt(index, 0);
            fillTableChiTietDonHang(val);
        }
    }//GEN-LAST:event_tbl1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbTongChiTietDonHang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JLabel lbChiTietMaDonHang;
    private javax.swing.JTable tableChiTietDonHang;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
