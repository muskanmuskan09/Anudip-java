package DaoImplementation;

import DaoInterface.DonationDao;
import EmUtil.EmUtil;
import models.Donation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import exception.DonationNotFoundException;

public class DonationDAOImpl implements DonationDao {

    @Override
    public void addDonation(Donation donation) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(donation); // Save the donation to the database
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error adding donation: " + e.getMessage());
        } finally {
            em.close(); // Close EntityManager after use
        }
    }

    @Override
    public void updateDonation(Donation donation) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(donation); // Update the existing donation
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Rollback if the update fails
            }
            e.printStackTrace();
            throw new RuntimeException("Error updating donation: " + e.getMessage());
        } finally {
            em.close(); // Close EntityManager
        }
    }

    @Override
    public void deleteDonation(Integer donationId) {
        EntityManager em = EmUtil.provideEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Donation donation = em.find(Donation.class, donationId); // Find the donation by ID
            if (donation == null) {
                throw new DonationNotFoundException("Donation with ID " + donationId + " not found.");
            }
            em.remove(donation); // Remove the donation from the database
            transaction.commit();
        } catch (DonationNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback(); // Rollback in case of failure
            }
            e.printStackTrace();
            throw new RuntimeException("Error deleting donation: " + e.getMessage());
        } finally {
            em.close(); // Close EntityManager
        }
    }

    @Override
    public Donation getDonationById(Integer donationId) {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            Donation donation = em.find(Donation.class, donationId); // Find the donation by ID
            if (donation == null) {
                throw new DonationNotFoundException("Donation with ID " + donationId + " not found.");
            }
            return donation; // Return the donation
        } finally {
            em.close(); // Close EntityManager
        }
    }

    @Override
    public List<Donation> getAllDonations() {
        EntityManager em = EmUtil.provideEntityManager();

        try {
            // Query to retrieve all donations
            TypedQuery<Donation> query = em.createQuery("SELECT d FROM Donation d", Donation.class);
            return query.getResultList(); // Return list of all donations
        } finally {
            em.close(); // Close EntityManager
        }
    }
}
