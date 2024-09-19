/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImplementation;

import DaoInterface.NGODonationDao;
import EmUtil.EmUtil;
import models.NGODonation;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import exception.NGODonationNotFoundException;

public class NGODonationDaoImpl implements NGODonationDao{
    @Override
    public void addNGODonation(NGODonation ngoDonation) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(ngoDonation);  // Save the NGODonation entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error adding NGO Donation: " + e.getMessage());
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public void updateNGODonation(NGODonation ngoDonation) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(ngoDonation);  // Update the existing NGODonation entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error updating NGO Donation: " + e.getMessage());
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public void deleteNGODonation(Integer ngoDonationId) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            NGODonation ngoDonation = em.find(NGODonation.class, ngoDonationId);  // Find NGODonation by ID
            if (ngoDonation == null) {
                throw new NGODonationNotFoundException("NGO Donation with ID " + ngoDonationId + " not found.");
            }
            em.remove(ngoDonation);  // Delete the NGODonation entity
            transaction.commit();
        } catch (NGODonationNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error deleting NGO Donation: " + e.getMessage());
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public NGODonation getNGODonationById(Integer ngoDonationId) {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            NGODonation ngoDonation = em.find(NGODonation.class, ngoDonationId);  // Find NGODonation by ID
            if (ngoDonation == null) {
                throw new NGODonationNotFoundException("NGO Donation with ID " + ngoDonationId + " not found.");
            }
            return ngoDonation;
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public List<NGODonation> getAllNGODonations() {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            // Query to retrieve all NGODonations
            TypedQuery<NGODonation> query = em.createQuery("SELECT nd FROM NGODonation nd", NGODonation.class);
            return query.getResultList();
        } finally {
            em.close();  // Close the EntityManager
        }
    }
}
