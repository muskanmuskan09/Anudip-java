/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DaoInterface;

import java.util.List;
import models.NGODonation;

/**
 *
 * @author Maninder Singh
 */
public interface NGODonationDao {
    void addNGODonation(NGODonation ngoDonation);
    void updateNGODonation(NGODonation ngoDonation);
    void deleteNGODonation(Integer ngoDonationId);
    NGODonation getNGODonationById(Integer ngoDonationId);
    List<NGODonation> getAllNGODonations();
}
