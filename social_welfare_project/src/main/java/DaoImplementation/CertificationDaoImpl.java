/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImplementation;

import DaoInterface.CertificationDao;
import EmUtil.EmUtil;
import exception.CertificationNotFoundException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import models.Certification;


public class CertificationDaoImpl implements CertificationDao{
   public void addCertification(Certification certification) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(certification);  // Save the certification to the database
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error adding certification: " + e.getMessage());
        } finally {
            em.close();  // Close EntityManager after use
        }
    }

    @Override
    public void updateCertification(Certification certification) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(certification);  // Update the existing certification
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error updating certification: " + e.getMessage());
        } finally {
            em.close();  // Close EntityManager after use
        }
    }

    @Override
    public void deleteCertification(Integer certificationId) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Certification certification = em.find(Certification.class, certificationId);  // Find certification by ID
            if (certification == null) {
                throw new CertificationNotFoundException("Certification with ID " + certificationId + " not found.");
            }
            em.remove(certification);  // Delete certification
            transaction.commit();
        } catch (CertificationNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback if the deletion fails
            }
            e.printStackTrace();
            throw new RuntimeException("Error deleting certification: " + e.getMessage());
        } finally {
            em.close();  // Close EntityManager after use
        }
    }

    @Override
    public Certification getCertificationById(Integer certificationId) {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            Certification certification = em.find(Certification.class, certificationId);  // Find certification by ID
            if (certification == null) {
                throw new CertificationNotFoundException("Certification with ID " + certificationId + " not found.");
            }
            return certification;  // Return the certification
        } finally {
            em.close();  // Close EntityManager after use
        }
    }

    @Override
    public List<Certification> getAllCertifications() {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            // Query to retrieve all certifications
            TypedQuery<Certification> query = em.createQuery("SELECT c FROM Certification c", Certification.class);
            return query.getResultList();  // Return list of all certifications
        } finally {
            em.close();  // Close EntityManager after use
        }
    } 
}
