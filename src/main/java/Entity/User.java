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
public class User {
    private String firstName;
    private String email;
    private String phone;
    private String lastName;
    private String address;
    private String image;
    private LocalDate dOb;
    private Account aid;

    public User() {
    }

    public User(String firstName, String email, String phone, String lastName, String address, String image, LocalDate dOb, Account aid) {
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.lastName = lastName;
        this.address = address;
        this.image = image;
        this.dOb = dOb;
        this.aid = aid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getdOb() {
        return dOb;
    }

    public void setdOb(LocalDate dOb) {
        this.dOb = dOb;
    }

    public Account getAid() {
        return aid;
    }

    public void setAid(Account aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "User{" + "firstName=" + firstName + ", email=" + email + ", phone=" + phone + ", lastName=" + lastName + ", address=" + address + ", image=" + image + ", dOb=" + dOb + ", aid=" + aid + '}';
    }

   
    
    
}
