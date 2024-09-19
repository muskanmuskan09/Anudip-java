/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImplementation;

import DaoInterface.CleanUpActivityDao;
import EmUtil.EmUtil;
import exception.CleanUpActivityNotFoundException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import models.CleanUpActivity;

/**
 *
 * @author Maninder Singh
 */
public class CleanUpActivityDaoImpl implements CleanUpActivityDao {
     @Override
    public void addCleanUpActivity(CleanUpActivity cleanUpActivity) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(cleanUpActivity);  // Save the clean-up activity to the database
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error adding clean-up activity: " + e.getMessage());
        } finally {
            em.close();  // Close EntityManager after use
        }
    }

    @Override
    public void updateCleanUpActivity(CleanUpActivity cleanUpActivity) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(cleanUpActivity);  // Update the existing clean-up activity
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error updating clean-up activity: " + e.getMessage());
        } finally {
            em.close();  // Close EntityManager after use
        }
    }

    @Override
    public void deleteCleanUpActivity(Integer cleanUpId) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            CleanUpActivity cleanUpActivity = em.find(CleanUpActivity.class, cleanUpId);  // Find the clean-up activity by ID
            if (cleanUpActivity == null) {
                throw new CleanUpActivityNotFoundException("Clean-up activity with ID " + cleanUpId + " not found.");
            }
            em.remove(cleanUpActivity);  // Delete the clean-up activity
            transaction.commit();
        } catch (CleanUpActivityNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error deleting clean-up activity: " + e.getMessage());
        } finally {
            em.close();  // Close EntityManager after use
        }
    }

    @Override
    public CleanUpActivity getCleanUpActivityById(Integer cleanUpId) {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            CleanUpActivity cleanUpActivity = em.find(CleanUpActivity.class, cleanUpId);  // Find clean-up activity by ID
            if (cleanUpActivity == null) {
                throw new CleanUpActivityNotFoundException("Clean-up activity with ID " + cleanUpId + " not found.");
            }
            return cleanUpActivity;  // Return the clean-up activity
        } finally {
            em.close();  // Close EntityManager after use
        }
    }

    @Override
    public List<CleanUpActivity> getAllCleanUpActivities() {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            // Query to retrieve all clean-up activities
            TypedQuery<CleanUpActivity> query = em.createQuery("SELECT c FROM CleanUpActivity c", CleanUpActivity.class);
            return query.getResultList();  // Return list of all clean-up activities
        } finally {
            em.close();  // Close EntityManager after use
        }
    }
}
