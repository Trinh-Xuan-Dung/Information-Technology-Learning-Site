/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 *
 * @author HP
 */
public class PasswordLogic {

    public String encodePassByBase64(String pass) {

        try {
            // Encode the password using Base64 encoding
            byte[] encodedBytes = Base64.getEncoder().encode(pass.getBytes("UTF-8"));
            return new String(encodedBytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String DecodePassBase64(String code) {
        try {
            // Decode the Base64-encoded password
            byte[] decodedBytes = Base64.getDecoder().decode(code.getBytes("UTF-8"));
            return new String(decodedBytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

    }
}
