/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImplementation;

import DaoInterface.TreeDonationDao;
import EmUtil.EmUtil;

import models.TreeDonation;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import exception.TreeDonationNotFoundException;

public class TreeDonationDaoImpl implements TreeDonationDao{
    
    @Override
    public void addTreeDonation(TreeDonation treeDonation) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(treeDonation);  // Save the TreeDonation entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error adding Tree Donation: " + e.getMessage());
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public void updateTreeDonation(TreeDonation treeDonation) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(treeDonation);  // Update the existing TreeDonation entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error updating Tree Donation: " + e.getMessage());
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public void deleteTreeDonation(Integer treeDonationId) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            TreeDonation treeDonation = em.find(TreeDonation.class, treeDonationId);  // Find TreeDonation by ID
            if (treeDonation == null) {
                throw new TreeDonationNotFoundException("Tree Donation with ID " + treeDonationId + " not found.");
            }
            em.remove(treeDonation);  // Delete the TreeDonation entity
            transaction.commit();
        } catch (TreeDonationNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error deleting Tree Donation: " + e.getMessage());
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public TreeDonation getTreeDonationById(Integer treeDonationId) {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            TreeDonation treeDonation = em.find(TreeDonation.class, treeDonationId);  // Find TreeDonation by ID
            if (treeDonation == null) {
                throw new TreeDonationNotFoundException("Tree Donation with ID " + treeDonationId + " not found.");
            }
            return treeDonation;
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public List<TreeDonation> getAllTreeDonations() {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            // Query to retrieve all TreeDonations
            TypedQuery<TreeDonation> query = em.createQuery("SELECT td FROM TreeDonation td", TreeDonation.class);
            return query.getResultList();
        } finally {
            em.close();  // Close the EntityManager
        }
    }
}
