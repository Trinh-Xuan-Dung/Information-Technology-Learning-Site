/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation;

/**
 *
 * @author HP
 */
public class Validator {

    public static int parseStringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            
            return 0; 
        }
    }

    public static boolean checkIdIsValid(String id) {
        if (id != null) {
            id = id.trim();

            if (id.matches("\\d+")) {
                int number = Integer.parseInt(id);
                return number > 0;
            }
        }
        return false;
    }
}