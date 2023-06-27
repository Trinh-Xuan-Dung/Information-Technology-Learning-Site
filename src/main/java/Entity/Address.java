/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author HP
 */
public class Address {

    private int id;
    private String alley;
    private String houseNumber;
    private int residentialGroupsId;

    public Address() {
    }

    public Address(int id, String alley, String houseNumber) {
        this.id = id;
        this.alley = alley;
        this.houseNumber = houseNumber;
    }

    public Address(int id, String alley, String houseNumber, int residentialGroupsId) {
        this.id = id;
        this.alley = alley;
        this.houseNumber = houseNumber;
        this.residentialGroupsId = residentialGroupsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlley() {
        return alley;
    }

    public void setAlley(String alley) {
        this.alley = alley;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getResidentialGroupsId() {
        return residentialGroupsId;
    }

    public void setResidentialGroupsId(int residentialGroupsId) {
        this.residentialGroupsId = residentialGroupsId;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", alley=" + alley + ", houseNumber=" + houseNumber + ", residentialGroupsId=" + residentialGroupsId + '}';
    }
 
    

}
