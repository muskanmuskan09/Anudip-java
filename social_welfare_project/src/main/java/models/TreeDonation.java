/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.persistence.*;

@Entity
@Table(name = "TreeDonation")
public class TreeDonation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tree_donation_id")
    private Integer treeDonationId;

    @Column(name = "tree_type")
    private String treeType;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "planting_location")
    private String plantingLocation;

    @ManyToOne
    @JoinColumn(name = "donation_id")
    private Donation donation;
    
    public TreeDonation(){
    }

    public TreeDonation(Integer treeDonationId, String treeType, Integer quantity, String plantingLocation, Donation donation) {
        this.treeDonationId = treeDonationId;
        this.treeType = treeType;
        this.quantity = quantity;
        this.plantingLocation = plantingLocation;
        this.donation = donation;
    }

    public Integer getTreeDonationId() {
        return treeDonationId;
    }

    public void setTreeDonationId(Integer treeDonationId) {
        this.treeDonationId = treeDonationId;
    }

    public String getTreeType() {
        return treeType;
    }

    public void setTreeType(String treeType) {
        this.treeType = treeType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPlantingLocation() {
        return plantingLocation;
    }

    public void setPlantingLocation(String plantingLocation) {
        this.plantingLocation = plantingLocation;
    }

    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }

    @Override
    public String toString() {
        return "TreeDonation{" + "treeDonationId=" + treeDonationId + ", treeType=" + treeType + ", quantity=" + quantity + ", plantingLocation=" + plantingLocation + ", donation=" + donation + '}';
    }


}

