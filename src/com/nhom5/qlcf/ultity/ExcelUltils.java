/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom5.qlcf.ultity;

import com.nhom5.qlcf.dao.ThongKeDAO;
import com.nhom5.qlcf.model.DonHang;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Asus
 */
public class ExcelUltils {

    public static Workbook printBangDoanhThuToExcel(javax.swing.JTable tblDoanhThu,
            javax.swing.JComboBox<String> cboxDoanhThuNam, javax.swing.JComboBox<String> cboxDoanhThuThang, ThongKeDAO thongKeDAO) throws FileNotFoundException, IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Academic Transcript");

//        DonHang donHang = (DonHang) cboxDoanhThu.getSelectedItem();
        int nam = (Integer) cboxDoanhThuNam.getSelectedItem();
        int thang = (Integer) cboxDoanhThuThang.getSelectedItem();
        List<Object[]> list = thongKeDAO.getDoanhThu(nam, thang);

        int rownum = 0;
        Cell cell;
        Row row;
        // 
        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);

        //MaNH
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Tên loại");
        cell.setCellStyle(style);

        //Họ Tên
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Doanh Thu");
        cell.setCellStyle(style);

        //Điểm 
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Thấp nhất");
        cell.setCellStyle(style);

        //Xếp loại
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Cao nhất");
        cell.setCellStyle(style);

        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Trung bình");
        cell.setCellStyle(style);

        

        //DATA 
        for (int i = 0; i < list.size(); i++) {
            rownum++;
            row = sheet.createRow(rownum);

            //ID Student
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue((String) tblDoanhThu.getValueAt(i, 0));

            //FULL NAME
            cell = row.createCell(1, CellType.NUMERIC);
            cell.setCellValue((Double) tblDoanhThu.getValueAt(i, 1));

            //POINT
            cell = row.createCell(2, CellType.NUMERIC);
            cell.setCellValue((Double) tblDoanhThu.getValueAt(i, 2));

            //CLASSIFICATION
            cell = row.createCell(3, CellType.NUMERIC);
            cell.setCellValue((Double) tblDoanhThu.getValueAt(i, 3));

            cell = row.createCell(4, CellType.NUMERIC);
            cell.setCellValue((Double) tblDoanhThu.getValueAt(i, 4));

            

        }
        return workbook;

    }

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }
}
