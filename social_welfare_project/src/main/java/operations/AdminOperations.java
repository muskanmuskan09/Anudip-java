package operations;

import DaoImplementation.*;
import DaoInterface.*;
import exception.AuthenticationException;
//import models.Admin;
import models.Donation;
import models.NGO;
import models.VolunteerActivity;
import models.CleanUpActivity;
import models.NGODonation;
import models.Certification;
import models.User;
import models.TreeDonation;
import models.VolunteerParticipation;
import models.CleanUpParticipation;
//import exception.AuthenticationException;
import exception.DonationNotFoundException;
import exception.NGONotFoundException;
import exception.VolunteerActivityNotFoundException;
import exception.CleanUpActivityNotFoundException;
import exception.CertificationNotFoundException;
import exception.UserNotFoundException;
import java.math.BigDecimal;
import java.util.Date;

import java.util.List;
import java.util.Scanner;
import models.Admin;
import static models.CleanUpActivity_.cleanupId;
import static models.User_.userId;

public class AdminOperations {

//    private final AdminDao adminDao = new AdminDaoImpl();
    private final DonationDao donationDao = new DonationDAOImpl();
    private final NGODao ngoDao = new NGODaoImpl();
    private final VolunteerActivityDao volunteerActivityDao = new VolunteerActivityDaoImpl();
    private final CleanUpActivityDao cleanUpActivityDao = new CleanUpActivityDaoImpl();
    private final NGODonationDao ngoDonationDao = new NGODonationDaoImpl();
    private final CertificationDao certificationDao = new CertificationDaoImpl();
    private final UserDao userDao = new UserDaoImpl();
    private final TreeDonationDao treeDonationDao = new TreeDonationDaoImpl();
    private final VolunteerParticipationDao volunteerParticipationDao = new VolunteerParticipationDaoImpl();
    private final CleanUpParticipationDao cleanUpParticipationDao = new CleanUpParticipationDaoImpl();
    private Scanner scanner = new Scanner(System.in);

//     Admin login
//  
    public Admin loginAdmin(Scanner scanner) throws AuthenticationException {
    System.out.print("Enter username: ");
    String username = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    AdminDao adminDao = (AdminDao) new AdminDaoImpl(); // Assume you're using this implementation
    Admin admin = adminDao.getAdminByUsername(username);

    if (admin != null && admin.getPassword().equals(password)) {
        return admin; // Successful login
    } else {
        throw new AuthenticationException("Invalid username or password.");
    }
}


    // Manage users
    public void manageUsers() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("\n==============================");
        System.out.println("         User Management       ");
        System.out.println("==============================");
        System.out.println("1. Add User");
        System.out.println("2. Update User");
        System.out.println("3. Delete User");
        System.out.println("4. View All Users");
        System.out.println("5. Back to Admin Menu");
        System.out.println("==============================");
        System.out.print("Choose an option (1-5): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                addUser(scanner);
                break;
            case 2:
                updateUser(scanner);
                break;
            case 3:
                deleteUser(scanner);
                break;
            case 4:
                viewAllUsers();
                break;
            case 5:
                return; // Back to Admin Menu
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

private void addUser(Scanner scanner) {
    System.out.print("Enter username: ");
    String username = scanner.nextLine();
    System.out.print("Enter email: ");
    String email = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();
    System.out.print("Enter contact number: ");
    String contactNumber = scanner.nextLine();
    System.out.print("Enter address: ");
    String address = scanner.nextLine();

    User user = new User();
    user.setName(username);
    user.setEmail(email);
    user.setPassword(password);
    user.setContactNumber(contactNumber);
    user.setAddress(address);

    userDao.addUser(user);
    System.out.println("User added successfully.");
}

private void updateUser(Scanner scanner) {
    System.out.print("Enter user ID to update: ");
    int userId = scanner.nextInt();
    scanner.nextLine();  // Consume newline
    User user = userDao.getUserById(userId);
    if (user != null) {
        System.out.print("Enter new username: ");
        String username = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new password: ");
        String password = scanner.nextLine();
        System.out.print("Enter new contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter new address: ");
        String address = scanner.nextLine();

        user.setName(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setContactNumber(contactNumber);
        user.setAddress(address);

        userDao.updateUser(user);
        System.out.println("User updated successfully.");
    } else {
        System.out.println("User not found.");
    }
}

private void deleteUser(Scanner scanner) {
    System.out.print("Enter user ID to delete: ");
    int userId = scanner.nextInt();
    scanner.nextLine();  // Consume newline
    userDao.deleteUser(userId);
    System.out.println("User deleted successfully.");
}

private void viewAllUsers() {
    List<User> users = userDao.getAllUsers();
    for (User user : users) {
        System.out.println(user);
    }
}


    // Manage donations
    public void manageDonations() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n==============================");
            System.out.println("         Donation Management    ");
            System.out.println("==============================");
            System.out.println("1. Add Donation");
            System.out.println("2. Update Donation");
            System.out.println("3. Delete Donation");
            System.out.println("4. View All Donations");
            System.out.println("5. Back to Admin Menu");
            System.out.println("==============================");
            System.out.print("Choose an option (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addDonation(scanner);
                    break;
                case 2:
                    updateDonation(scanner);
                    break;
                case 3:
                    deleteDonation(scanner);
                    break;
                case 4:
                    viewAllDonations();
                    break;
                case 5:
                    return; // Back to Admin Menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    
    private void addDonation(Scanner scanner) {
        System.out.print("Enter amount: ");
        BigDecimal amount = scanner.nextBigDecimal();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter date (yyyy-MM-dd): ");
        String dateString = scanner.nextLine();
        Date date = java.sql.Date.valueOf(dateString); // Convert string to Date
        System.out.print("Enter donation type: ");
        String donationType = scanner.nextLine();
        System.out.print("Enter item description: ");
        String itemDescription = scanner.nextLine();
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Create a User object with the provided ID (assuming a method to fetch User by ID exists)
        User user = new User();
        user.setUserId(userId);

        Donation donation = new Donation();
        donation.setAmount(amount);
        donation.setDate(date);
        donation.setDonationType(donationType);
        donation.setItemDescription(itemDescription);
        donation.setUser(user);

        donationDao.addDonation(donation);
        System.out.println("Donation added successfully.");
    }

    private void updateDonation(Scanner scanner) {
        System.out.print("Enter donation ID to update: ");
        int donationId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Donation donation = donationDao.getDonationById(donationId);
        if (donation != null) {
            System.out.print("Enter new amount: ");
            BigDecimal amount = scanner.nextBigDecimal();
            scanner.nextLine();  // Consume newline
            System.out.print("Enter new date (yyyy-MM-dd): ");
            String dateString = scanner.nextLine();
            Date date = java.sql.Date.valueOf(dateString); // Convert string to Date
            System.out.print("Enter new donation type: ");
            String donationType = scanner.nextLine();
            System.out.print("Enter new item description: ");
            String itemDescription = scanner.nextLine();

            donation.setAmount(amount);
            donation.setDate(date);
            donation.setDonationType(donationType);
            donation.setItemDescription(itemDescription);

            donationDao.updateDonation(donation);
            System.out.println("Donation updated successfully.");
        } else {
            System.out.println("Donation not found.");
        }
    }

    private void deleteDonation(Scanner scanner) {
        System.out.print("Enter donation ID to delete: ");
        int donationId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        donationDao.deleteDonation(donationId);
        System.out.println("Donation deleted successfully.");
    }

    private void viewAllDonations() {
        List<Donation> donations = donationDao.getAllDonations();
        for (Donation donation : donations) {
            System.out.println(donation);
        }
    }

    // Manage NGOs
    public void manageNGOs() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n==============================");
            System.out.println("         NGO Management        ");
            System.out.println("==============================");
            System.out.println("1. Add NGO");
            System.out.println("2. Update NGO");
            System.out.println("3. Delete NGO");
            System.out.println("4. View All NGOs");
            System.out.println("5. Back to Admin Menu");
            System.out.println("==============================");
            System.out.print("Choose an option (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addNGO(scanner);
                    break;
                case 2:
                    updateNGO(scanner);
                    break;
                case 3:
                    deleteNGO(scanner);
                    break;
                case 4:
                    viewAllNGOs();
                    break;
                case 5:
                    return; // Back to Admin Menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

     private void addNGO(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact person: ");
        String contactPerson = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter website URL: ");
        String websiteUrl = scanner.nextLine();

        NGO ngo = new NGO();
        ngo.setName(name);
        ngo.setContactPerson(contactPerson);
        ngo.setContactNumber(contactNumber);
        ngo.setEmail(email);
        ngo.setAddress(address);
        ngo.setWebsiteUrl(websiteUrl);

        ngoDao.addNGO(ngo);
        System.out.println("NGO added successfully.");
    }

    private void updateNGO(Scanner scanner) {
        System.out.print("Enter NGO ID to update: ");
        int ngoId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        NGO ngo = ngoDao.getNGOById(ngoId);
        if (ngo != null) {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new contact person: ");
            String contactPerson = scanner.nextLine();
            System.out.print("Enter new contact number: ");
            String contactNumber = scanner.nextLine();
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();
            System.out.print("Enter new address: ");
            String address = scanner.nextLine();
            System.out.print("Enter new website URL: ");
            String websiteUrl = scanner.nextLine();

            ngo.setName(name);
            ngo.setContactPerson(contactPerson);
            ngo.setContactNumber(contactNumber);
            ngo.setEmail(email);
            ngo.setAddress(address);
            ngo.setWebsiteUrl(websiteUrl);

            ngoDao.updateNGO(ngo);
            System.out.println("NGO updated successfully.");
        } else {
            System.out.println("NGO not found.");
        }
    }

    private void deleteNGO(Scanner scanner) {
        System.out.print("Enter NGO ID to delete: ");
        int ngoId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        ngoDao.deleteNGO(ngoId);
        System.out.println("NGO deleted successfully.");
    }

    private void viewAllNGOs() {
        List<NGO> ngos = ngoDao.getAllNGOs();
        for (NGO ngo : ngos) {
            System.out.println(ngo);
        }
    }

    // Manage volunteer activities
    public void manageVolunteerActivities() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n==============================");
            System.out.println("    Volunteer Activity Management");
            System.out.println("==============================");
            System.out.println("1. Add Volunteer Activity");
            System.out.println("2. Update Volunteer Activity");
            System.out.println("3. Delete Volunteer Activity");
            System.out.println("4. View All Volunteer Activities");
            System.out.println("5. Back to Admin Menu");
            System.out.println("==============================");
            System.out.print("Choose an option (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addVolunteerActivity();
                    break;
                case 2:
                    updateVolunteerActivity();
                    break;
                case 3:
                    deleteVolunteerActivity();
                    break;
                case 4:
                    viewAllVolunteerActivities();
                    break;
                case 5:
                    return; // Back to Admin Menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

  private void addVolunteerActivity() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter date (yyyy-MM-dd): ");
        String dateString = scanner.nextLine();
        Date date = null;
                
        try{
             date=java.sql.Date.valueOf(dateString);
        } catch (IllegalArgumentException e) {
             System.out.println("Error: Date format is incorrect. Please use yyyy-MM-dd format.");
             return; // Exit the method if the date format is incorrect
        }

        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        // Create dummy NGO and User for the example
        NGO ngo = new NGO();
        ngo.setNgoId(1); // Assume you have an NGO with ID 1 for simplicity

    // Ask the user to input the user ID of the activity creator (or fetch current user in real scenarios)
    System.out.print("Enter the user ID of the creator: ");
    int userId = scanner.nextInt();
    scanner.nextLine(); // Consume newline
    
    // Fetch the user from the database using the userId
    try{
    User createdBy = userDao.getUserById(userId); 
    if (createdBy == null) {
        System.out.println("Error: User with ID " + userId + " not found.");
        return; // Exit the method if the user is not found
    }
        VolunteerActivity activity = new VolunteerActivity();
        activity.setName(name);
        activity.setDescription(description);
        activity.setDate(date);
        activity.setLocation(location);
        activity.setNgo(ngo);
        activity.setCreatedBy(createdBy);

        volunteerActivityDao.addVolunteerActivity(activity);
        System.out.println("Volunteer Activity added successfully.");
    } catch (UserNotFoundException e) {
        System.out.println("Error: User with ID " + userId + " not found. Please check the user ID and try again.");
    } catch (Exception e) {
        System.out.println("An unexpected error occurred: " + e.getMessage());
    }
  }

    private void updateVolunteerActivity() {
        System.out.print("Enter Volunteer Activity ID to update: ");
        int activityId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        VolunteerActivity activity = volunteerActivityDao.getVolunteerActivityById(activityId);
        if (activity != null) {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new description: ");
            String description = scanner.nextLine();
            System.out.print("Enter new date (yyyy-MM-dd): ");
            String dateString = scanner.nextLine();
            Date date = java.sql.Date.valueOf(dateString);
            System.out.print("Enter new location: ");
            String location = scanner.nextLine();

            // Update existing NGO and User for the example
            NGO ngo = activity.getNgo();
            User createdBy = activity.getCreatedBy();

            activity.setName(name);
            activity.setDescription(description);
            activity.setDate(date);
            activity.setLocation(location);
            activity.setNgo(ngo);
            activity.setCreatedBy(createdBy);

            volunteerActivityDao.updateVolunteerActivity(activity);
            System.out.println("Volunteer Activity updated successfully.");
        } else {
            System.out.println("Volunteer Activity not found.");
        }
    }

    private void deleteVolunteerActivity() {
        System.out.print("Enter Volunteer Activity ID to delete: ");
        int activityId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        volunteerActivityDao.deleteVolunteerActivity(activityId);
        System.out.println("Volunteer Activity deleted successfully.");
    }

    private void viewAllVolunteerActivities() {
        List<VolunteerActivity> activities = volunteerActivityDao.getAllVolunteerActivities();
        for (VolunteerActivity activity : activities) {
            System.out.println(activity);
        }
    }

    // Manage clean-up activities
    public void manageCleanUpActivities() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n==============================");
            System.out.println("   Clean-Up Activity Management");
            System.out.println("==============================");
            System.out.println("1. Add Clean-Up Activity");
            System.out.println("2. Update Clean-Up Activity");
            System.out.println("3. Delete Clean-Up Activity");
            System.out.println("4. View All Clean-Up Activities");
            System.out.println("5. Back to Admin Menu");
            System.out.println("==============================");
            System.out.print("Choose an option (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addCleanUpActivity();
                    break;
                case 2:
                    updateCleanUpActivity();
                    break;
                case 3:
                    deleteCleanUpActivity();
                    break;
                case 4:
                    viewAllCleanUpActivities();
                    break;
                case 5:
                    return; // Back to Admin Menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addCleanUpActivity() {
        System.out.print("Enter location: ");
        String location = scanner.nextLine();
        System.out.print("Enter date (yyyy-MM-dd): ");
        String dateString = scanner.nextLine();
        Date date = null;
        try{
            date=java.sql.Date.valueOf(dateString);
        } catch (IllegalArgumentException e) {
        System.out.println("Error: Date format is incorrect. Please use yyyy-MM-dd format.");
        return; // Exit the method if the date format is incorrect
    }

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

//         Create dummy User for the example
//        User createdBy = new User();
//        createdBy.setUserId(1); // Assume you have a User with ID 1 for simplicity
// Fetch the user from the database using the user ID
    User createdBy;
    try {
        System.out.print("Enter the user ID of the creator: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        createdBy = userDao.getUserById(userId);
        if (createdBy == null) {
            System.out.println("Error: User with ID " + userId + " not found.");
            return; // Exit the method if the user is not found
        }
    } catch (UserNotFoundException e) {
        System.out.println("Error: User not found. Please check the user ID and try again.");
        return; // Exit the method if the user is not found
    } catch (Exception e) {
        System.out.println("An unexpected error occurred: " + e.getMessage());
        return; // Exit the method if there's an unexpected error
    }
        CleanUpActivity activity = new CleanUpActivity();
        activity.setLocation(location);
        activity.setDate(date);
        activity.setDescription(description);
        activity.setCreatedBy(createdBy);

        cleanUpActivityDao.addCleanUpActivity(activity);
        System.out.println("Clean Up Activity added successfully.");
    }

    private void updateCleanUpActivity() {
        System.out.print("Enter Clean Up Activity ID to update: ");
        int activityId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        CleanUpActivity activity;

    try {
        // Fetch the clean-up activity from the database using the activityId
        activity = cleanUpActivityDao.getCleanUpActivityById(activityId);
        if (activity == null) {
            System.out.println("Error: Clean-up activity with ID " + activityId + " not found.");
            return; // Exit the method if the activity is not found
        }
            System.out.print("Enter new location: ");
            String location = scanner.nextLine();
            System.out.print("Enter new date (yyyy-MM-dd): ");
            String dateString = scanner.nextLine();
            Date date = null;
            try{
                date=java.sql.Date.valueOf(dateString);
            }catch (IllegalArgumentException e) {
            System.out.println("Error: Date format is incorrect. Please use yyyy-MM-dd format.");
            return; // Exit the method if the date format is incorrect
        }
            System.out.print("Enter new description: ");
            String description = scanner.nextLine();

            // Update existing User for the example
//            User createdBy = activity.getCreatedBy();

            activity.setLocation(location);
            activity.setDate(date);
            activity.setDescription(description);
//            activity.setCreatedBy(createdBy);

            cleanUpActivityDao.updateCleanUpActivity(activity);
            System.out.println("Clean Up Activity updated successfully.");
        } catch (CleanUpActivityNotFoundException e) {
        System.out.println("Error: Clean-up activity with ID " + activityId + " not found.");
    } catch (Exception e) {
        System.out.println("An unexpected error occurred: " + e.getMessage());
    }
    }

    private void deleteCleanUpActivity() {
        System.out.print("Enter Clean Up Activity ID to delete: ");
        int cleanupId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
try{
        cleanUpActivityDao.deleteCleanUpActivity(cleanupId);
        System.out.println("Clean Up Activity deleted successfully.");
    }catch (CleanUpActivityNotFoundException e) {
        // Handle the case when the clean-up activity is not found
        System.out.println("Error: Clean-up activity with ID " + cleanupId + " not found.");
    } catch (Exception e) {
        // Handle any other unexpected exceptions
        System.out.println("An unexpected error occurred: " + e.getMessage());
    }
    }

    private void viewAllCleanUpActivities() {
        List<CleanUpActivity> activities = cleanUpActivityDao.getAllCleanUpActivities();
        for (CleanUpActivity activity : activities) {
            System.out.println(activity);
        }
    }
    // Manage certifications
    public void manageCertifications() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n==============================");
            System.out.println("       Certification Management");
            System.out.println("==============================");
            System.out.println("1. Add Certification");
            System.out.println("2. Update Certification");
            System.out.println("3. Delete Certification");
            System.out.println("4. View All Certifications");
            System.out.println("5. Back to Admin Menu");
            System.out.println("==============================");
            System.out.print("Choose an option (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addCertification();
                    break;
                case 2:
                    updateCertification();
                    break;
                case 3:
                    deleteCertification();
                    break;
                case 4:
                    viewAllCertifications();
                    break;
                case 5:
                    return; // Back to Admin Menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
 private void addCertification() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter issue date (yyyy-MM-dd): ");
        Date issueDate = null;
        while (issueDate == null) {
           System.out.print("Enter issue date (yyyy-MM-dd): ");
           String dateString = scanner.nextLine();
           try {
               issueDate = java.sql.Date.valueOf(dateString); // Try to parse the input date
           } catch (IllegalArgumentException e) {
               System.out.println("Error: Invalid date format. Please enter the date in yyyy-MM-dd format.");
           }
        }

        User user = null;

        while (user == null) {
            System.out.print("Enter User ID: ");
            int userId = scanner.nextInt();  // Fetch user ID from input
            scanner.nextLine(); // Consume the newline left by nextInt()
            // Retrieve User from the database using UserDao
            user = userDao.getUserById(userId);   // Fetch user by the provided userId
            if (user == null) {
                System.out.println("Error: User with ID " + userId + " does not exist. Please enter a valid User ID.");
            }
        }
       VolunteerActivity activity = null;

    // Loop until a valid VolunteerActivity ID is entered
    while (activity == null) {
        System.out.print("Enter Volunteer Activity ID: ");
        int activityId = scanner.nextInt();  // Fetch activity ID from input
        scanner.nextLine(); // Consume the newline left by nextInt()

        // Retrieve VolunteerActivity from the database using VolunteerActivityDao
        VolunteerActivityDao volunteerActivityDao = new VolunteerActivityDaoImpl();  // Assuming VolunteerActivityDaoImpl is your implementation
        activity = volunteerActivityDao.getVolunteerActivityById(activityId); // Fetch activity by the provided activityId

        if (activity == null) {
            System.out.println("Error: Volunteer Activity with ID " + activityId + " does not exist. Please enter a valid Volunteer Activity ID.");
        }
    }
   
        Certification certification = new Certification();
        certification.setTitle(title);
        certification.setDescription(description);
        certification.setIssueDate(issueDate);
        certification.setUser(user);
        certification.setActivity(activity);

        certificationDao.addCertification(certification);
        System.out.println("Certification added successfully.");
    }

    private void updateCertification() {
        System.out.print("Enter Certification ID to update: ");
        int certificationId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Certification certification = certificationDao.getCertificationById(certificationId);
        if (certification != null) {
            System.out.print("Enter new title: ");
            String title = scanner.nextLine();
            System.out.print("Enter new description: ");
            String description = scanner.nextLine();
            System.out.print("Enter new issue date (yyyy-MM-dd): ");
            String dateString = scanner.nextLine();
            Date issueDate = java.sql.Date.valueOf(dateString);

            // Update existing User and VolunteerActivity for the example
            User user = certification.getUser();
            VolunteerActivity activity = certification.getActivity();

            certification.setTitle(title);
            certification.setDescription(description);
            certification.setIssueDate(issueDate);
            certification.setUser(user);
            certification.setActivity(activity);

            certificationDao.updateCertification(certification);
            System.out.println("Certification updated successfully.");
        } else {
            System.out.println("Certification not found.");
        }
    }

    private void deleteCertification() {
        System.out.print("Enter Certification ID to delete: ");
        int certificationId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        try{
            certificationDao.deleteCertification(certificationId);
            System.out.println("Certification deleted successfully.");
        }catch (CertificationNotFoundException e) {
        // Handle the case when the clean-up activity is not found
            System.out.println("Error: Clean-up activity with ID " + cleanupId + " not found.");
        } catch (Exception e) {
        // Handle any other unexpected exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
    private void viewAllCertifications() {
        List<Certification> certifications = certificationDao.getAllCertifications();
        for (Certification certification : certifications) {
            System.out.println(certification);
        }
    }
}

