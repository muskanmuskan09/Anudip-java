/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operations;

import DaoInterface.*;
import DaoImplementation.*;
import models.*;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserOperations {

    private final CleanUpActivityDao cleanUpActivityDao=new CleanUpActivityDaoImpl();
    private TreeDonationDao treeDonationDao =new TreeDonationDaoImpl();
    private NGODao ngoDao=new NGODaoImpl();
    private UserDao userDao=new UserDaoImpl();
    private VolunteerActivityDao volunteerActivityDao=new VolunteerActivityDaoImpl();
    private DonationDao donationDao =new DonationDAOImpl();
    private CleanUpParticipationDao cleanUpParticipationDao =new CleanUpParticipationDaoImpl();
    private NGODonationDao ngoDonationDao =new NGODonationDaoImpl();
    private VolunteerParticipationDao volunteerParticipationDao=new VolunteerParticipationDaoImpl();


   
    public void manageCleanUpParticipation() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n==============================");
            System.out.println("     Clean-Up Participation    ");
            System.out.println("==============================");
            System.out.println("1. Add Clean-Up Participation");
            System.out.println("2. Update Clean-Up Participation");
            System.out.println("3. Delete Clean-Up Participation");
            System.out.println("4. View All Clean-Up Participations");
            System.out.println("5. Back to User Menu");
            System.out.println("==============================");
            System.out.print("Choose an option (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addCleanUpParticipation(scanner);
                    break;
                case 2:
                    updateCleanUpParticipation(scanner);
                    break;
                case 3:
                    deleteCleanUpParticipation(scanner);
                    break;
                case 4:
                    viewAllCleanUpParticipations();
                    break;
                case 5:
                    return; // Back to User Menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

   private void addCleanUpParticipation(Scanner scanner) {
    System.out.print("Enter clean-up activity ID: ");
    int cleanUpActivityId = scanner.nextInt();
    scanner.nextLine();  // Consume newline
    CleanUpActivity cleanUpActivity = cleanUpActivityDao.getCleanUpActivityById(cleanUpActivityId);

    if (cleanUpActivity == null) {
        System.out.println("Clean-up activity not found.");
        return;
    }

    System.out.print("Enter user ID: ");
    int userId = scanner.nextInt();
    scanner.nextLine();  // Consume newline
    User user = userDao.getUserById(userId);

    if (user == null) {
        System.out.println("User not found.");
        return;
    }

    System.out.print("Enter date of participation (yyyy-MM-dd): ");
    String dateString = scanner.nextLine();
    Date date = java.sql.Date.valueOf(dateString); // Convert string to Date

    // Convert the input string to java.sql.Date
//    Date date;
//    try {
//        date = java.sql.Date.valueOf(dateString);  // java.sql.Date expects the string in yyyy-MM-dd format
//    } catch (IllegalArgumentException e) {
//        System.out.println("Invalid date format. Please use yyyy-MM-dd.");
//        return;
//    }

    CleanUpParticipation participation = new CleanUpParticipation();
    participation.setCleanupActivity(cleanUpActivity);
    participation.setUser(user);
    participation.setDateOfParticipation(date);

    cleanUpParticipationDao.addCleanUpParticipation(participation);
    System.out.println("Clean-up participation added successfully.");
}
    private void updateCleanUpParticipation(Scanner scanner) {
        System.out.print("Enter clean-up participation ID to update: ");
        int participationId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        CleanUpParticipation participation = cleanUpParticipationDao.getCleanUpParticipationById(participationId);
        if (participation != null) {
            System.out.print("Enter new clean-up activity ID: ");
            int cleanUpActivityId = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            CleanUpActivity cleanUpActivity = cleanUpActivityDao.getCleanUpActivityById(cleanUpActivityId);
            
            if (cleanUpActivity == null) {
                System.out.println("Clean-up activity not found.");
                return;
            }
            participation.setCleanupActivity(cleanUpActivity);

            System.out.print("Enter new user ID: ");
            int userId = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            User user = userDao.getUserById(userId);
            
            if (user == null) {
                System.out.println("User not found.");
                return;
            }
            participation.setUser(user);

            System.out.print("Enter new date of participation (yyyy-MM-dd): ");
            String dateString = scanner.nextLine();
            Date date = java.sql.Date.valueOf(dateString); // Convert string to Date
            participation.setDateOfParticipation(date);

            cleanUpParticipationDao.updateCleanUpParticipation(participation);
            System.out.println("Clean-up participation updated successfully.");
        } else {
            System.out.println("Clean-up participation not found.");
        }
    }

    private void deleteCleanUpParticipation(Scanner scanner) {
        System.out.print("Enter clean-up participation ID to delete: ");
        int participationId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        cleanUpParticipationDao.deleteCleanUpParticipation(participationId);
        System.out.println("Clean-up participation deleted successfully.");
    }

    private void viewAllCleanUpParticipations() {
        List<CleanUpParticipation> participations = cleanUpParticipationDao.getAllCleanUpParticipations();
        for (CleanUpParticipation participation : participations) {
            System.out.println(participation);
        }
    }
    
     public void manageNGODonations() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n==============================");
            System.out.println("     NGO Donation Management    ");
            System.out.println("==============================");
            System.out.println("1. Add NGO Donation");
            System.out.println("2. Update NGO Donation");
            System.out.println("3. Delete NGO Donation");
            System.out.println("4. View All NGO Donations");
            System.out.println("5. Back to User Menu");
            System.out.println("==============================");
            System.out.print("Choose an option (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addNGODonation(scanner);
                    break;
                case 2:
                    updateNGODonation(scanner);
                    break;
                case 3:
                    deleteNGODonation(scanner);
                    break;
                case 4:
                    viewAllNGODonations();
                    break;
                case 5:
                    return; // Back to User Menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addNGODonation(Scanner scanner) {
        System.out.print("Enter NGO ID: ");
        int ngoId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        NGO ngo = ngoDao.getNGOById(ngoId);

        if (ngo == null) {
            System.out.println("NGO not found.");
            return;
        }

        System.out.print("Enter Donation ID: ");
        int donationId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        Donation donation = donationDao.getDonationById(donationId);

        if (donation == null) {
            System.out.println("Donation not found.");
            return;
        }

        NGODonation ngoDonation = new NGODonation();
        ngoDonation.setNgo(ngo);
        ngoDonation.setDonation(donation);

        ngoDonationDao.addNGODonation(ngoDonation);
        System.out.println("NGO Donation added successfully.");
    }

    private void updateNGODonation(Scanner scanner) {
        System.out.print("Enter NGO Donation ID to update: ");
        int ngoDonationId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        NGODonation ngoDonation = ngoDonationDao.getNGODonationById(ngoDonationId);
        if (ngoDonation != null) {
            System.out.print("Enter new NGO ID: ");
            int ngoId = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            NGO ngo = ngoDao.getNGOById(ngoId);

            if (ngo == null) {
                System.out.println("NGO not found.");
                return;
            }
            ngoDonation.setNgo(ngo);

            System.out.print("Enter new Donation ID: ");
            int donationId = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            Donation donation = donationDao.getDonationById(donationId);

            if (donation == null) {
                System.out.println("Donation not found.");
                return;
            }
            ngoDonation.setDonation(donation);

            ngoDonationDao.updateNGODonation(ngoDonation);
            System.out.println("NGO Donation updated successfully.");
        } else {
            System.out.println("NGO Donation not found.");
        }
    }

    private void deleteNGODonation(Scanner scanner) {
        System.out.print("Enter NGO Donation ID to delete: ");
        int ngoDonationId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        ngoDonationDao.deleteNGODonation(ngoDonationId);
        System.out.println("NGO Donation deleted successfully.");
    }

    private void viewAllNGODonations() {
        List<NGODonation> ngoDonations = ngoDonationDao.getAllNGODonations();
        for (NGODonation ngoDonation : ngoDonations) {
            System.out.println(ngoDonation);
        }
    }
    
    public void manageTreeDonations() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n==============================");
            System.out.println("     Tree Donation Management    ");
            System.out.println("==============================");
            System.out.println("1. Add Tree Donation");
            System.out.println("2. Update Tree Donation");
            System.out.println("3. Delete Tree Donation");
            System.out.println("4. View All Tree Donations");
            System.out.println("5. Back to User Menu");
            System.out.println("==============================");
            System.out.print("Choose an option (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addTreeDonation(scanner);
                    break;
                case 2:
                    updateTreeDonation(scanner);
                    break;
                case 3:
                    deleteTreeDonation(scanner);
                    break;
                case 4:
                    viewAllTreeDonations();
                    break;
                case 5:
                    return; // Back to User Menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addTreeDonation(Scanner scanner) {
        System.out.print("Enter Tree Type: ");
        String treeType = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter Planting Location: ");
        String plantingLocation = scanner.nextLine();

        System.out.print("Enter Donation ID: ");
        int donationId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        Donation donation = donationDao.getDonationById(donationId);

        if (donation == null) {
            System.out.println("Donation not found.");
            return;
        }

        TreeDonation treeDonation = new TreeDonation();
        treeDonation.setTreeType(treeType);
        treeDonation.setQuantity(quantity);
        treeDonation.setPlantingLocation(plantingLocation);
        treeDonation.setDonation(donation);

        treeDonationDao.addTreeDonation(treeDonation);
        System.out.println("Tree Donation added successfully.");
    }

    private void updateTreeDonation(Scanner scanner) {
        System.out.print("Enter Tree Donation ID to update: ");
        int treeDonationId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        TreeDonation treeDonation = treeDonationDao.getTreeDonationById(treeDonationId);
        if (treeDonation != null) {
            System.out.print("Enter new Tree Type: ");
            String treeType = scanner.nextLine();
            treeDonation.setTreeType(treeType);

            System.out.print("Enter new Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            treeDonation.setQuantity(quantity);

            System.out.print("Enter new Planting Location: ");
            String plantingLocation = scanner.nextLine();
            treeDonation.setPlantingLocation(plantingLocation);

            System.out.print("Enter new Donation ID: ");
            int donationId = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            Donation donation = donationDao.getDonationById(donationId);

            if (donation == null) {
                System.out.println("Donation not found.");
                return;
            }
            treeDonation.setDonation(donation);

            treeDonationDao.updateTreeDonation(treeDonation);
            System.out.println("Tree Donation updated successfully.");
        } else {
            System.out.println("Tree Donation not found.");
        }
    }

    private void deleteTreeDonation(Scanner scanner) {
        System.out.print("Enter Tree Donation ID to delete: ");
        int treeDonationId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        treeDonationDao.deleteTreeDonation(treeDonationId);
        System.out.println("Tree Donation deleted successfully.");
    }

    private void viewAllTreeDonations() {
        List<TreeDonation> treeDonations = treeDonationDao.getAllTreeDonations();
        for (TreeDonation treeDonation : treeDonations) {
            System.out.println(treeDonation);
        }
    }
    
    public void manageVolunteerParticipations() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n==============================");
            System.out.println("  Volunteer Participation Management");
            System.out.println("==============================");
            System.out.println("1. Add Volunteer Participation");
            System.out.println("2. Update Volunteer Participation");
            System.out.println("3. Delete Volunteer Participation");
            System.out.println("4. View All Volunteer Participations");
            System.out.println("5. Back to User Menu");
            System.out.println("==============================");
            System.out.print("Choose an option (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addVolunteerParticipation(scanner);
                    break;
                case 2:
                    updateVolunteerParticipation(scanner);
                    break;
                case 3:
                    deleteVolunteerParticipation(scanner);
                    break;
                case 4:
                    viewAllVolunteerParticipations();
                    break;
                case 5:
                    return; // Back to User Menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addVolunteerParticipation(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        User user = userDao.getUserById(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Enter Activity ID: ");
        int activityId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        VolunteerActivity activity = volunteerActivityDao.getVolunteerActivityById(activityId);

        if (activity == null) {
            System.out.println("Activity not found.");
            return;
        }

        System.out.print("Enter Date of Participation (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
        Date dateOfParticipation = java.sql.Date.valueOf(dateStr);

        VolunteerParticipation participation = new VolunteerParticipation();
        participation.setUser(user);
        participation.setActivity(activity);
        participation.setDateOfParticipation(dateOfParticipation);

        volunteerParticipationDao.addVolunteerParticipation(participation);
        System.out.println("Volunteer Participation added successfully.");
    }

    private void updateVolunteerParticipation(Scanner scanner) {
        System.out.print("Enter Volunteer Participation ID to update: ");
        int participationId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        VolunteerParticipation participation = volunteerParticipationDao.getVolunteerParticipationById(participationId);
        if (participation != null) {
            System.out.print("Enter new User ID: ");
            int userId = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            User user = userDao.getUserById(userId);

            if (user == null) {
                System.out.println("User not found.");
                return;
            }
            participation.setUser(user);

            System.out.print("Enter new Activity ID: ");
            int activityId = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            VolunteerActivity activity = volunteerActivityDao.getVolunteerActivityById(activityId);

            if (activity == null) {
                System.out.println("Activity not found.");
                return;
            }
            participation.setActivity(activity);

            System.out.print("Enter new Date of Participation (YYYY-MM-DD): ");
            String dateStr = scanner.nextLine();
            Date dateOfParticipation = java.sql.Date.valueOf(dateStr);
            participation.setDateOfParticipation(dateOfParticipation);

            volunteerParticipationDao.updateVolunteerParticipation(participation);
            System.out.println("Volunteer Participation updated successfully.");
        } else {
            System.out.println("Volunteer Participation not found.");
        }
    }

    private void deleteVolunteerParticipation(Scanner scanner) {
        System.out.print("Enter Volunteer Participation ID to delete: ");
        int participationId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        volunteerParticipationDao.deleteVolunteerParticipation(participationId);
        System.out.println("Volunteer Participation deleted successfully.");
    }

    private void viewAllVolunteerParticipations() {
        List<VolunteerParticipation> participations = volunteerParticipationDao.getAllVolunteerParticipations();
        for (VolunteerParticipation participation : participations) {
            System.out.println(participation);
        }
    }
}

