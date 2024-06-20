/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nhom5.qlcf.view;

import com.nhom5.qlcf.model.DoUong;
import com.nhom5.qlcf.dao.DoUongDAO;
import com.nhom5.qlcf.dao.DonHangDAO;
import com.nhom5.qlcf.dao.Xjdbc;
import com.nhom5.qlcf.dao.jdbc;
import com.nhom5.qlcf.main.HoaDonJDialog;
import com.nhom5.qlcf.model.NhanVien;
import com.nhom5.qlcf.ultity.Auth;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.chrono.MinguoEra;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Asus
 */
public class BanHangJPanel extends javax.swing.JPanel {

    String[] head = {"Tên món", "Size", "Số lượng", "Thành tiền", "Ghi chú"};
    DefaultTableModel tableModel = new DefaultTableModel(head, 0) {
        @Override
        public boolean isCellEditable(int i, int i1) {
            return false;
        }
    };
    int index = -1;
    public BanHangJPanel() {
        initComponents();
        showSanPham();
        thanhCuon();
        fillCboxPTTT();
        fillCboxGiamGia();
        tableModel = (DefaultTableModel) tableChonSanPham.getModel();
        tableModel.setRowCount(0);
        lbNV.setText(Auth.userNhanVien.getTenNV());
    }
    int row = 1;
    DoUong doUong = new DoUong();
    DoUongDAO doUongDAO = new DoUongDAO();
    List<DoUong> listTenDoUong = new ArrayList<>();

    void showSanPham() {
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "Select Ten_do_uong,Hinh from Do_Uong group by Ten_do_uong,Hinh";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                DoUong doUong = new DoUong();
                doUong.setTenDoUong(rs.getString("Ten_do_uong"));
                doUong.setHinh(rs.getString("Hinh"));
                listTenDoUong.add(doUong);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        for (DoUong doUong : listTenDoUong) {
            String TenDoUong = doUong.getTenDoUong();
            String HinhAnhDoUong = doUong.getHinh();
            String path = "D:\\tinhpt26461\\Duan1\\QuanLyCoffe\\src\\com\\nhom5\\qlcf\\img\\" + HinhAnhDoUong;
            ImageIcon imgicon = new ImageIcon(path);
            Image img = imgicon.getImage();
            JLabel label = new JLabel(TenDoUong);
            label.setSize(100, 100);
            label.setFont(new Font("Segoe UI", Font.BOLD, 14));
            int width = label.getWidth();
            int height = label.getHeight();
            label.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    lbTenDoUong.setText(label.getText());
                    row = 1;
                    txtSoLuong.setText(String.valueOf(row));
                    cboxSizeDoUong.removeAllItems();
                    fillCboxSizeDoUong(label.getText());

                }
            });
            PanelSanPham.add(label);
        }

    }
    
    String hinhThuc = "";

    void fillCboxPTTT() {
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sql = "Select Ten_hinh_thuc from Phuong_thuc_thanh_toan";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                cboxHinhThucThanhToan.addItem(rs.getString("Ten_hinh_thuc"));
//                hinhThuc = cboxHinhThucThanhToan.getSelectedItem().toString();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void fillCboxGiamGia() {
        try (Connection con = jdbc.openConnection(); Statement stm = con.createStatement();) {
            String sqlDoUong = "Select Giam_gia from Do_Uong group by Giam_gia order by Giam_gia DESC";
            ResultSet rsDoUong = stm.executeQuery(sqlDoUong);
            while (rsDoUong.next()) {
                cboxGiamGia.addItem(rsDoUong.getString("Giam_gia"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void fillCboxSizeDoUong(String TenDoUong) {
        try (Connection con = jdbc.openConnection(); PreparedStatement ps = con.prepareStatement("SELECT Size_do_uong FROM Do_Uong WHERE Ten_do_uong = ? ");) {
            ps.setString(1, TenDoUong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DoUong doUong = new DoUong();
                doUong.setSizeDoUong(rs.getString("Size_do_uong"));
                cboxSizeDoUong.addItem(doUong.getSizeDoUong());

            }
            cboxSizeDoUong.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        // Khi kích thước được chọn, cập nhật giá tiền
                        fillTextGiaTien(cboxSizeDoUong.getSelectedItem().toString(), lbTenDoUong.getText());
                    }
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void fillTextGiaTien(String SizeDoUong, String TenDoUong) {
        try (Connection con = jdbc.openConnection(); PreparedStatement ps = con.prepareStatement("SELECT Gia_tien FROM Do_Uong WHERE Ten_do_uong =  ? and Size_do_uong = ? ");) {
            ps.setString(1, TenDoUong);
            ps.setString(2, SizeDoUong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DoUong doUong = new DoUong();
                doUong.setGiaTien(rs.getDouble("Gia_tien"));
                lbGiaTien.setText(String.valueOf(doUong.getGiaTien()));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void thanhCuon() {
        JScrollPane scrollPane = new JScrollPane(PanelSanPham);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
    }

    void fillTable() {
        Double MaGiam_gia;
        if (cboxGiamGia.getSelectedItem().toString().equals("Không")) {
            MaGiam_gia = 0.0;
        } else {
            MaGiam_gia = Double.valueOf(cboxGiamGia.getSelectedItem().toString().replace("%", "")) / 100.0;
        }
        String Giam_gia = String.valueOf((Double.valueOf(txtSoLuong.getText()) * Double.valueOf(lbGiaTien.getText())) * MaGiam_gia);
        String DonGia = String.valueOf((Double.valueOf(txtSoLuong.getText()) * Double.valueOf(lbGiaTien.getText())) - Double.valueOf(Giam_gia));
        tableModel = (DefaultTableModel) tableChonSanPham.getModel();
        Object[] row = new Object[]{
            lbTenDoUong.getText(),
            cboxSizeDoUong.getSelectedItem().toString(),
            txtSoLuong.getText(),
            DonGia,
            txtGhiChu.getText()
        };
        tableModel.addRow(row);
        tableChonSanPham.setModel(tableModel);

    }

    void clearForm() {
        lbTenDoUong.setText("Tên đồ uống");
        lbGiaTien.setText("Giá tiền");
        txtSoLuong.setText(String.valueOf(row = 1));
        cboxSizeDoUong.removeAllItems();
        txtGhiChu.setText("");
    }

    void TongTien() {

        tableModel = (DefaultTableModel) tableChonSanPham.getModel();
        Object tien = null;
        int column = 3; // Chọn cột thứ 1 (chỉ số cột tính từ 0)
        Double TongTien = 0.0;
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            tien = tableModel.getValueAt(row, column);
            TongTien += Double.valueOf((String) tien);

        }
        lbTongTien.setText(String.valueOf(TongTien));

    }

    void TruTien() {
        DefaultTableModel tableModel = (DefaultTableModel) tableChonSanPham.getModel();
        Object tien = null;
        int column = 3; // Chọn cột thứ 1 (chỉ số cột tính từ 0)
        Double TongTien = 0.0;
        for (int row = 0; row < tableModel.getRowCount(); row++) {
            tien = tableModel.getValueAt(row, column);
            TongTien = Double.valueOf((String) tien) - TongTien;

        }
        lbTongTien.setText(String.valueOf(TongTien));
    }

    void TangSoLuong() {
        row = row;
        row++;
        txtSoLuong.setText(String.valueOf(row));
    }

    void GiamSoLuong() {
        row = row;
        row--;
        if (row <= 0) {
            row = 1;
        }
        txtSoLuong.setText(String.valueOf(row));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableChonSanPham = new javax.swing.JTable();
        PanelSanPham = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbNV = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lbTongTien = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbTenDoUong = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        btnTangSoLuong = new javax.swing.JButton();
        btnGiamSoLuong = new javax.swing.JButton();
        cboxSizeDoUong = new javax.swing.JComboBox<>();
        cboxGiamGia = new javax.swing.JComboBox<>();
        cboxHinhThucThanhToan = new javax.swing.JComboBox<>();
        lbGiaTien = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();

        setBackground(new java.awt.Color(220, 190, 169));

        tableChonSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên đồ uống", "Size", "Số lượng", "Đơn giá", "Ghi chú"
            }
        ));
        tableChonSanPham.setAutoscrolls(false);
        tableChonSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableChonSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableChonSanPham);

        PanelSanPham.setBackground(new java.awt.Color(220, 190, 169));
        PanelSanPham.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelSanPham.setLayout(new java.awt.GridLayout(8, 2, 10, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nhân viên thanh toán:");

        lbNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbNV.setForeground(new java.awt.Color(0, 0, 0));
        lbNV.setText("Phạm Thế Tình");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Hình thức thanh toán:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Tổng tiền:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Ghi chú");

        txtGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("In hóa đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbTongTien.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbTongTien.setForeground(new java.awt.Color(0, 0, 0));
        lbTongTien.setText("Tổng tiền");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tên đồ uống:");

        lbTenDoUong.setBackground(new java.awt.Color(250, 1, 1));
        lbTenDoUong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbTenDoUong.setForeground(new java.awt.Color(0, 0, 0));
        lbTenDoUong.setText("Tên đồ uống");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Size đồ uống:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Số lượng:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Giảm giá: ");

        txtSoLuong.setText("1");
        txtSoLuong.setPreferredSize(new java.awt.Dimension(105, 25));
        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        btnTangSoLuong.setText("+");
        btnTangSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTangSoLuongActionPerformed(evt);
            }
        });

        btnGiamSoLuong.setText("-");
        btnGiamSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiamSoLuongActionPerformed(evt);
            }
        });

        cboxSizeDoUong.setBackground(new java.awt.Color(255, 255, 255));
        cboxSizeDoUong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboxSizeDoUong.setForeground(new java.awt.Color(0, 0, 0));

        cboxGiamGia.setBackground(new java.awt.Color(255, 255, 255));
        cboxGiamGia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboxGiamGia.setForeground(new java.awt.Color(0, 0, 0));

        cboxHinhThucThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        cboxHinhThucThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboxHinhThucThanhToan.setForeground(new java.awt.Color(0, 0, 0));
        cboxHinhThucThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxHinhThucThanhToanActionPerformed(evt);
            }
        });

        lbGiaTien.setBackground(new java.awt.Color(250, 1, 1));
        lbGiaTien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbGiaTien.setForeground(new java.awt.Color(0, 0, 0));
        lbGiaTien.setText("Giá tiền");

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(PanelSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(cboxHinhThucThanhToan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lbNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTenDoUong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cboxSizeDoUong, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnTangSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnGiamSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 126, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(cboxGiamGia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17))
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGhiChu)
                            .addComponent(lbTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThem)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNV))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTenDoUong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxSizeDoUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbGiaTien))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTangSoLuong)
                            .addComponent(btnGiamSoLuong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cboxHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(btnThem)))
                    .addComponent(PanelSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 952, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        try {
            fillTable();
            clearForm();
            TongTien();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đồ uống");
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void cboxHinhThucThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxHinhThucThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxHinhThucThanhToanActionPerformed

    private void btnGiamSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiamSoLuongActionPerformed
        // TODO add your handling code here:
        GiamSoLuong();
    }//GEN-LAST:event_btnGiamSoLuongActionPerformed

    private void btnTangSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTangSoLuongActionPerformed
        // TODO add your handling code here:
        TangSoLuong();
    }//GEN-LAST:event_btnTangSoLuongActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        HoaDonJDialog hoadon = new HoaDonJDialog(null, true);
        hoadon.setTien(lbTongTien.getText());
        hoadon.setTableModel(tableModel);
        hoadon.setThanhToan(cboxHinhThucThanhToan.getSelectedItem().toString());
        hoadon.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableChonSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableChonSanPhamMouseClicked
        if (evt.getClickCount() == 1) {
            this.index = tableChonSanPham.rowAtPoint(evt.getPoint());
            index = tableChonSanPham.getSelectedRow();
            if (index != -1) {
                tableModel.removeRow(index);
                TruTien();
            }
        }
    }//GEN-LAST:event_tableChonSanPhamMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelSanPham;
    private javax.swing.JButton btnGiamSoLuong;
    private javax.swing.JButton btnTangSoLuong;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cboxGiamGia;
    private javax.swing.JComboBox<String> cboxHinhThucThanhToan;
    private javax.swing.JComboBox<String> cboxSizeDoUong;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbGiaTien;
    private javax.swing.JLabel lbNV;
    private javax.swing.JLabel lbTenDoUong;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JTable tableChonSanPham;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
