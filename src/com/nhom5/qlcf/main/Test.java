/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom5.qlcf.ultity;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Asus
 */
public class Test {
    public static void main(String[] args) {
        String originalString = "nguyenvana";
        String hashedString = sha256(originalString);
        System.out.println("Original: " + originalString);
        System.out.println("SHA-256 Hash: " + hashedString);
    }

    public static String sha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            // Chuyển byte array sang định dạng hex
            StringBuilder hexString = new StringBuilder(2 * encodedhash.length);
            for (byte b : encodedhash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
