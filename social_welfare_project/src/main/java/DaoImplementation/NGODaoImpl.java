/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImplementation;

import DaoInterface.NGODao;
import EmUtil.EmUtil;
import models.NGO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import exception.NGONotFoundException;

public class NGODaoImpl implements NGODao {
    @Override
    public void addNGO(NGO ngo) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(ngo);  // Save the NGO entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error adding NGO: " + e.getMessage());
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public void updateNGO(NGO ngo) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(ngo);  // Update the existing NGO entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error updating NGO: " + e.getMessage());
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public void deleteNGO(Integer ngoId) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            NGO ngo = em.find(NGO.class, ngoId);  // Find the NGO by ID
            if (ngo == null) {
                throw new NGONotFoundException("NGO with ID " + ngoId + " not found.");
            }
            em.remove(ngo);  // Delete the NGO entity
            transaction.commit();
        } catch (NGONotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error deleting NGO: " + e.getMessage());
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public NGO getNGOById(Integer ngoId) {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            NGO ngo = em.find(NGO.class, ngoId);  // Find NGO by ID
            if (ngo == null) {
                throw new NGONotFoundException("NGO with ID " + ngoId + " not found.");
            }
            return ngo;
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public List<NGO> getAllNGOs() {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            // Query to retrieve all NGOs
            TypedQuery<NGO> query = em.createQuery("SELECT n FROM NGO n", NGO.class);
            return query.getResultList();
        } finally {
            em.close();  // Close the EntityManager
        }
    } 
}
