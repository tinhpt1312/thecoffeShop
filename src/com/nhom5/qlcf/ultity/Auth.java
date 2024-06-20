/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom5.qlcf.ultity;


import com.nhom5.qlcf.model.NhanVien;

/**
 *
 * @author Asus
 */
public class Auth {
    /**
     * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
     */
    public static NhanVien userNhanVien = null;
    /**
     * Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
     */
    public static void clear() {
        Auth.userNhanVien = null;
    }
    /**
     * Kiểm tra xem đăng nhập hay chưa
     */
    public static boolean isLogin() {
        return Auth.userNhanVien != null;
    }
     /**
     * Kiểm tra xem có phải là trưởng phòng hay không
     */
    public static boolean isManager() {
        return Auth.isLogin() ;
    }
}
