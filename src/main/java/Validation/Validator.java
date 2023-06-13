/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation;

import Entity.Subject;
import java.util.ArrayList;
import java.util.List;

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

    public List<Subject> getListtoAddnew(List<Subject> oldList, List<Subject> newList) {
        List<Subject> removedList = new ArrayList<>();
        for (Subject subject : oldList) {
            if (!newList.contains(subject)) {
                removedList.add(subject);
            }
        }
        return removedList;
    }

    public List<Subject> getListtoRemove(List<Subject> oldList, List<Subject> newList) {
        List<Subject> addedList = new ArrayList<>();
        for (Subject subject : newList) {
            if (!oldList.contains(subject)) {
                addedList.add(subject);
            }
        }
        return addedList;
        
    }
    
}
