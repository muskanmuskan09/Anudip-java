/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImplementation;

import DaoInterface.VolunteerActivityDao;
import EmUtil.EmUtil;

import models.VolunteerActivity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import exception.VolunteerActivityNotFoundException;
public class VolunteerActivityDaoImpl implements VolunteerActivityDao {
     @Override
    public void addVolunteerActivity(VolunteerActivity activity) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(activity);  // Save the VolunteerActivity entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error adding Volunteer Activity: " + e.getMessage());
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public void updateVolunteerActivity(VolunteerActivity activity) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(activity);  // Update the existing VolunteerActivity entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error updating Volunteer Activity: " + e.getMessage());
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public void deleteVolunteerActivity(Integer activityId) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            VolunteerActivity activity = em.find(VolunteerActivity.class, activityId);  // Find VolunteerActivity by ID
            if (activity == null) {
                throw new VolunteerActivityNotFoundException("Volunteer Activity with ID " + activityId + " not found.");
            }
            em.remove(activity);  // Delete the VolunteerActivity entity
            transaction.commit();
        } catch (VolunteerActivityNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error deleting Volunteer Activity: " + e.getMessage());
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public VolunteerActivity getVolunteerActivityById(Integer activityId) {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            VolunteerActivity activity = em.find(VolunteerActivity.class, activityId);  // Find VolunteerActivity by ID
            if (activity == null) {
                throw new VolunteerActivityNotFoundException("Volunteer Activity with ID " + activityId + " not found.");
            }
            return activity;
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public List<VolunteerActivity> getAllVolunteerActivities() {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            // Query to retrieve all VolunteerActivities
            TypedQuery<VolunteerActivity> query = em.createQuery("SELECT va FROM VolunteerActivity va", VolunteerActivity.class);
            return query.getResultList();
        } finally {
            em.close();  // Close the EntityManager
        }
    }
}
