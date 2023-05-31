/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Subject;
import java.util.List;

/**
 *
 * @author HP
 */
public interface SubjectDAO {
    List<Subject> getAllSubject();
    int getKeytoInsertCOurse(String name);
}
