/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImplementation;

import DaoInterface.CleanUpParticipationDao;
import EmUtil.EmUtil;
import models.CleanUpParticipation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import exception.CleanUpParticipationNotFoundException;
public class CleanUpParticipationDaoImpl implements CleanUpParticipationDao  {
    @Override
    public void addCleanUpParticipation(CleanUpParticipation participation) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(participation);  // Save the participation to the database
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error adding clean-up participation: " + e.getMessage());
        } finally {
            em.close();  // Close EntityManager after use
        }
    }

    @Override
    public void updateCleanUpParticipation(CleanUpParticipation participation) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(participation);  // Update the existing participation
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error updating clean-up participation: " + e.getMessage());
        } finally {
            em.close();  // Close EntityManager after use
        }
    }

    @Override
    public void deleteCleanUpParticipation(Integer participationId) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            CleanUpParticipation participation = em.find(CleanUpParticipation.class, participationId);  // Find the participation by ID
            if (participation == null) {
                throw new CleanUpParticipationNotFoundException("Clean-up participation with ID " + participationId + " not found.");
            }
            em.remove(participation);  // Delete the participation
            transaction.commit();
        } catch (CleanUpParticipationNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error deleting clean-up participation: " + e.getMessage());
        } finally {
            em.close();  // Close EntityManager after use
        }
    }

    @Override
    public CleanUpParticipation getCleanUpParticipationById(Integer participationId) {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            CleanUpParticipation participation = em.find(CleanUpParticipation.class, participationId);  // Find participation by ID
            if (participation == null) {
                throw new CleanUpParticipationNotFoundException("Clean-up participation with ID " + participationId + " not found.");
            }
            return participation;  // Return the participation
        } finally {
            em.close();  // Close EntityManager after use
        }
    }

    @Override
    public List<CleanUpParticipation> getAllCleanUpParticipations() {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            // Query to retrieve all clean-up participations
            TypedQuery<CleanUpParticipation> query = em.createQuery("SELECT p FROM CleanUpParticipation p", CleanUpParticipation.class);
            return query.getResultList();  // Return list of all clean-up participations
        } finally {
            em.close();  // Close EntityManager after use
        }
    }
}
