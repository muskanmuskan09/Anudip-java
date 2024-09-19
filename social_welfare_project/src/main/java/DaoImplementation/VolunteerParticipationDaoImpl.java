/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImplementation;

import DaoInterface.VolunteerParticipationDao;
import EmUtil.EmUtil;
import models.VolunteerParticipation;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import exception.VolunteerParticipationNotFoundException;
public class VolunteerParticipationDaoImpl implements VolunteerParticipationDao{
    @Override
    public void addVolunteerParticipation(VolunteerParticipation participation) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(participation);  // Save the VolunteerParticipation entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error adding Volunteer Participation: " + e.getMessage());
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public void updateVolunteerParticipation(VolunteerParticipation participation) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(participation);  // Update the existing VolunteerParticipation entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error updating Volunteer Participation: " + e.getMessage());
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public void deleteVolunteerParticipation(Integer participationId) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            VolunteerParticipation participation = em.find(VolunteerParticipation.class, participationId);  // Find VolunteerParticipation by ID
            if (participation == null) {
                throw new VolunteerParticipationNotFoundException("Volunteer Participation with ID " + participationId + " not found.");
            }
            em.remove(participation);  // Delete the VolunteerParticipation entity
            transaction.commit();
        } catch (VolunteerParticipationNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error deleting Volunteer Participation: " + e.getMessage());
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public VolunteerParticipation getVolunteerParticipationById(Integer participationId) {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            VolunteerParticipation participation = em.find(VolunteerParticipation.class, participationId);  // Find VolunteerParticipation by ID
            if (participation == null) {
                throw new VolunteerParticipationNotFoundException("Volunteer Participation with ID " + participationId + " not found.");
            }
            return participation;
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public List<VolunteerParticipation> getAllVolunteerParticipations() {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            // Query to retrieve all VolunteerParticipations
            TypedQuery<VolunteerParticipation> query = em.createQuery("SELECT vp FROM VolunteerParticipation vp", VolunteerParticipation.class);
            return query.getResultList();
        } finally {
            em.close();  // Close the EntityManager
        }
    }
}
