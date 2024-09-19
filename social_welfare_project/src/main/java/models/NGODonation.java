/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.persistence.*;

@Entity
@Table(name = "NGODonation")
public class NGODonation {
    public NGODonation(){
    
    }

    @Override
    public String toString() {
        return "NGODonation{" + "ngoDonationId=" + ngoDonationId + ", ngo=" + ngo + ", donation=" + donation + '}';
    }

    public NGODonation(Integer ngoDonationId, NGO ngo, Donation donation) {
        this.ngoDonationId = ngoDonationId;
        this.ngo = ngo;
        this.donation = donation;
    }

    public Integer getNgoDonationId() {
        return ngoDonationId;
    }

    public void setNgoDonationId(Integer ngoDonationId) {
        this.ngoDonationId = ngoDonationId;
    }

    public NGO getNgo() {
        return ngo;
    }

    public void setNgo(NGO ngo) {
        this.ngo = ngo;
    }

    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ngo_donation_id")
    private Integer ngoDonationId;

    @ManyToOne
    @JoinColumn(name = "ngo_id")
    private NGO ngo;

    @ManyToOne
    @JoinColumn(name = "donation_id")
    private Donation donation;

    // Getters and setters
}

