/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Users;

/**
 *
 * @author HP
 */
public interface UserDAO {
    public int AddNewUser(Users user);
    public Users getUserExsit(String userName);
        
}
