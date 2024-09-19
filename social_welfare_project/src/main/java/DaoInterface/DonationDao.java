/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DaoInterface;

import java.util.List;
import models.Donation;

/**
 *
 * @author Maninder Singh
 */
public interface DonationDao {
        void addDonation(Donation donation);
    void updateDonation(Donation donation);
    void deleteDonation(Integer donationId);
    Donation getDonationById(Integer donationId);
    List<Donation> getAllDonations();
    
}
