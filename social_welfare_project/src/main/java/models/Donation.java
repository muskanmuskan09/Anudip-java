/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Donation")
public class Donation {

    @Override
    public String toString() {
        return "Donation{" + "donationId=" + donationId + ", amount=" + amount + ", date=" + date + ", donationType=" + donationType + ", itemDescription=" + itemDescription + ", user=" + user + '}';
    }

    public Integer getDonationId() {
        return donationId;
    }

    public void setDonationId(Integer donationId) {
        this.donationId = donationId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Donation(Integer donationId, BigDecimal amount, Date date, String donationType, String itemDescription, User user) {
        this.donationId = donationId;
        this.amount = amount;
        this.date = date;
        this.donationType = donationType;
        this.itemDescription = itemDescription;
        this.user = user;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donation_id")
    private Integer donationId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

//    @Enumerated(EnumType.STRING)
    @Column(name = "donation_type")
    private String donationType;

    @Column(name = "item_description")
    private String itemDescription;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
   
    public Donation(){

}
}

