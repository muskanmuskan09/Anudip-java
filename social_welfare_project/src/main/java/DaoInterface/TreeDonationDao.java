/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DaoInterface;

import java.util.List;
import models.TreeDonation;

/**
 *
 * @author Maninder Singh
 */
public interface TreeDonationDao {
     void addTreeDonation(TreeDonation treeDonation);
    void updateTreeDonation(TreeDonation treeDonation);
    void deleteTreeDonation(Integer treeDonationId);
    TreeDonation getTreeDonationById(Integer treeDonationId);
    List<TreeDonation> getAllTreeDonations();
    
}
