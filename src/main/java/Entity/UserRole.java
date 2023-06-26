/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author HP
 */
public class UserRole {
   
    private int userId;
    private int roleId;
    private Users user;
    private Role role;

    public UserRole() {
    }

    public UserRole(int userId, int roleId, Users user, Role role) {
        this.userId = userId;
        this.roleId = roleId;
        this.user = user;
        this.role = role;
    }

    public UserRole(int userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRole{" + "userId=" + userId + ", roleId=" + roleId + ", user=" + user + ", role=" + role + '}';
    }
    
    
    
    
}
