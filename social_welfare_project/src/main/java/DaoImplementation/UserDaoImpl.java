/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImplementation;

import DaoInterface.UserDao;
import EmUtil.EmUtil;
import models.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import exception.UserNotFoundException;
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser(User user) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(user);  // Save the User entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error adding User: " + e.getMessage());
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public void updateUser(User user) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(user);  // Update the existing User entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error updating User: " + e.getMessage());
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public void deleteUser(Integer userId) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            User user = em.find(User.class, userId);  // Find User by ID
            if (user == null) {
                throw new UserNotFoundException("User with ID " + userId + " not found.");
            }
            em.remove(user);  // Delete the User entity
            transaction.commit();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();  // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error deleting User: " + e.getMessage());
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public User getUserById(Integer userId) {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            User user = em.find(User.class, userId);  // Find User by ID
            if (user == null) {
                throw new UserNotFoundException("User with ID " + userId + " not found.");
            }
            return user;
        } finally {
            em.close();  // Close the EntityManager
        }
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            // Query to retrieve all Users
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
            return query.getResultList();
        } finally {
            em.close();  // Close the EntityManager
        }
    }
}
