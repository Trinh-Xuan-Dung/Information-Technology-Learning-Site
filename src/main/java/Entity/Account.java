/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class Account {
    private int accountId ;
    private String username;
    private String password;
    private int Role ;
    private LocalDate dateCreate;

    public Account() {
    }

    public Account(int accountId, String username, String password, int Role, LocalDate dateCreate) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.Role = Role;
        this.dateCreate = dateCreate;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int Role) {
        this.Role = Role;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public String toString() {
        return "Account{" + "accountId=" + accountId + ", username=" + username + ", password=" + password + ", Role=" + Role + ", dateCreate=" + dateCreate + '}';
    }
    
    
}
