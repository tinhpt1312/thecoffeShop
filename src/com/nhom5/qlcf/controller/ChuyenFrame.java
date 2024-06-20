/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom5.qlcf.controller;


import com.nhom5.qlcf.view.BanHangJPanel1;
import com.nhom5.qlcf.view.QLDHPanel;

import com.nhom5.qlcf.view.QLDHPanel1;
import com.nhom5.qlcf.view.QLNVPanel;
import com.nhom5.qlcf.view.QLSPPanel;
import com.nhom5.qlcf.view.QuanLyPanel;
import com.nhom5.qlcf.view.ThongKePanel;

import com.nhom5.qlcf.view.ThongKePanel1;
import com.nhom5.qlcf.view.TrangChuPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tinh
 */
public class ChuyenFrame {

    private JPanel root;
    private String kindSelected = "";
    private List<DanhMuc> listItem = null;

    public ChuyenFrame(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    //Hàm show trang đầu tiên xuất hiện khi mới truy cập vào ứng dụng
    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChu";
        root.removeAll();
        root.add(new TrangChuPanel());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMuc> listItem) {
        this.listItem = listItem;
        for (DanhMuc item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "QuanLy":
                    node = new QuanLyPanel();
                    break;
                case "BanHang":
                    node = new BanHangJPanel1();
                    break;
                case "ThongKe":
                    node = new ThongKePanel1();
                    break;
                default:
                    node = new TrangChuPanel();
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            changeBackGroundColor(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(220, 190, 169));
            jlbItem.setBackground(new Color(0, 0, 0));
            jlbItem.setForeground(new Color(0, 0, 0));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(220, 190, 169));
            jlbItem.setBackground(new Color(0, 0, 0));
            jlbItem.setForeground(new Color(0, 0, 0));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(60, 49, 49));
                jlbItem.setBackground(new Color(255, 30, 0));
                jlbItem.setForeground(new Color(255, 255, 255));
            }
        }

    }

    public void setEventQL(List<DanhMuc> listItem) {
        this.listItem = listItem;
        for (DanhMuc item : listItem) {
            item.getJlb().addMouseListener(new LabelEventQL(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LabelEventQL implements MouseListener {

        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEventQL(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "SanPham":
                    node = new QLSPPanel();
                    break;
                case "NhanVien":
                    node = new QLNVPanel();
                    break;
                case "DonHang":
                    node = new QLDHPanel();
                    break;
                default:
                    node = new TrangChuPanel();
            }

            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            changeBackGroundColorQL(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(60, 49, 49));
            jlbItem.setBackground(new Color(0, 0, 0));
            jlbItem.setForeground(new Color(255, 255, 255));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(60, 49, 49));
            jlbItem.setBackground(new Color(0, 0, 0));
            jlbItem.setForeground(new Color(255, 255, 255));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(255, 255, 255));
                jlbItem.setBackground(new Color(255, 30, 0));
                jlbItem.setForeground(new Color(0, 0, 0));
            }
        }

    }

    private void changeBackGroundColor(String kind) {
        for (DanhMuc item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(220, 190, 169));
                item.getJlb().setBackground(new Color(0, 0, 0));
                item.getJlb().setForeground(new Color(0, 0, 0));
            } else {
                item.getJlb().setBackground(new Color(60, 49, 49));
                item.getJpn().setBackground(new Color(60, 49, 49));
                item.getJlb().setForeground(new Color(255, 255, 255));
            }
        }
    }

    private void changeBackGroundColorQL(String kind) {
        for (DanhMuc item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(60, 49, 49));
                item.getJlb().setBackground(new Color(0, 0, 0));
                item.getJlb().setForeground(new Color(255, 255, 255));
            } else {
                item.getJlb().setBackground(new Color(255, 255, 255));
                item.getJpn().setBackground(new Color(255, 255, 255));
                item.getJlb().setForeground(new Color(0, 0, 0));
            }
        }
    }
}
