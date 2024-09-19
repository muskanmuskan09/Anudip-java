/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.persistence.*;

@Entity
@Table(name = "NGO")
public class NGO {
    public NGO(){
    
    }

    @Override
    public String toString() {
        return "NGO{" + "ngoId=" + ngoId + ", name=" + name + ", contactPerson=" + contactPerson + ", contactNumber=" + contactNumber + ", email=" + email + ", address=" + address + ", websiteUrl=" + websiteUrl + '}';
    }

    public Integer getNgoId() {
        return ngoId;
    }

    public void setNgoId(Integer ngoId) {
        this.ngoId = ngoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public NGO(Integer ngoId, String name, String contactPerson, String contactNumber, String email, String address, String websiteUrl) {
        this.ngoId = ngoId;
        this.name = name;
        this.contactPerson = contactPerson;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
        this.websiteUrl = websiteUrl;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ngo_id")
    private Integer ngoId;

    @Column(name = "name")
    private String name;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "website_url")
    private String websiteUrl;

    // Getters and setters
}

