/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom5.qlcf.model;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tinh
 */
public class TableData {
    public DefaultTableModel tableModel;
    
    public TableData(Object[][] data, Object[] columns) {
        tableModel = new DefaultTableModel(data, columns);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public Object getValueAt(int row, int column) {
        return tableModel.getValueAt(row, column);
    }
}
