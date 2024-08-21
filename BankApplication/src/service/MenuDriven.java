/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
//import service.AccountService; 
//import Dao.AccountDao;

import Connection.ConnectionFactory;
import Dao.MenuDao;
import java.security.Timestamp;
//import com.mysql.cj.xdevapi.Statement;
import java.sql.Statement;
//import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
//import java.sql.Timestamp;

/**
 *
 * @author muska
 */
public class MenuDriven implements MenuDao {

    private static MenuDriven instance;
    private AccountService accountService;
    private Scanner scanner;
    private int customerId;
    private String accountNumber;

    private MenuDriven() {
        accountService = new AccountService(); // Use only AccountService
        scanner = new Scanner(System.in);
    }

    public static MenuDriven getInstance() {
        if (instance == null) {
            instance = new MenuDriven();
        }
        return instance;
    }

    @Override
    public void displayMenu() {
        while (true) {
            System.out.println("""
                               Welcome to the Online Banking System
                               1. Login as an Existing Customer
                               2. Login as Admin
                               3. Exit""");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    int accountId = handleLogin(); // Now returns accountId
                    if (accountId != -1) {
                        try {
                            displayPostLoginMenu(accountId);
                        } catch (SQLException ex) {
                            Logger.getLogger(MenuDriven.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                case 2 -> {
                    try {
                        handleAdminLogin();
                    } catch (SQLException ex) {
                        Logger.getLogger(MenuDriven.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                case 3 -> {
                    System.out.println("Thank you for using the Online Banking System!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
                    }
    }



    @Override
    public int handleLogin() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // SQL query to validate username and password and get account number
        String query = "SELECT c.customer_id, a.account_number "
                + "FROM Customer c "
                + "JOIN Account a ON c.customer_id = a.customer_id "
                + "WHERE c.username = ? AND c.password = ?";

        try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int customerId = rs.getInt("customer_id");
                String accountNumber = rs.getString("account_number");

                this.customerId = customerId;
                this.accountNumber = accountNumber;

                return customerId;
            } else {

                System.out.println("Invalid username or password. Please try again.");
                return -1;
            }
        } catch (SQLException e) {
            System.err.println("Error during login: " + e.getMessage());
            return -1;
        }
    }

    public void displayPostLoginMenu(int accountId) throws SQLException {
        while (true) {
            System.out.println("1. View Account Details");
            System.out.println("2. Transfer Money");
            System.out.println("3. View Transaction History");
//            System.out.println("4. Apply for Loan");
            System.out.println("4. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 ->
                    viewAccountDetails(accountId);
                case 2 ->
                    handleTransferMoney(accountId);
                case 3 ->
                    handleViewTransactionHistory(accountId);
//                case 4 ->
//                    handleApplyForLoan(accountId);
                case 4 -> {
                    System.out.println("Logged out successfully.");
                    return; // Return to the main menu
                }
                default ->
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewAccountDetails(int accountId) throws SQLException {
        try {
            Account account = accountService.getAccountDetails(accountId);
            if (account != null) {
                System.out.println("Account Number: " + account.getAccountNumber());
                System.out.println("Account Type: " + account.getAccountType());
                System.out.println("Balance: " + account.getBalance());
                System.out.println("Name: " + account.getName());
                System.out.println("Email: " + account.getEmail());
                System.out.println("Phone Number: " + account.getPhoneNumber());
                System.out.println("Username: " + account.getUsername());
                System.out.println("");
                System.out.println("");
                System.out.println("");

            } else {
                System.out.println("Account details not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving account details: " + e.getMessage());
        }

    }

    public void handleViewTransactionHistory(int accountId) throws SQLException {
        try {
            List<Integer> accountIds = accountService.getAccountIdsByCustomerId(accountId);
            if (accountIds.isEmpty()) {
                System.out.println("No accounts found for the customer.");
            } else {
                accountService.viewTransactionHistory(accountIds);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving transaction history: " + e.getMessage());
        }
    }

    public void handleApplyForLoan(int customerId) {
        System.out.print("Enter the loan type: ");
        String loanType = scanner.nextLine();
        System.out.print("Enter the loan amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter the interest rate: ");
        double interestRate = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        try {
            boolean success = accountService.applyForLoan(customerId, amount, loanType, interestRate);
            if (success) {
                System.out.println("Loan application submitted successfully.");
            } else {
                System.out.println("Failed to apply for loan.");
            }
        } catch (Exception e) {
            System.err.println("Error applying for loan: " + e.getMessage());
        }
    }

    public void handleTransferMoney(int accountId) throws SQLException {
        System.out.print("Enter recipient's account number: ");
        String recipientAccountNumber = scanner.nextLine();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        // SQL queries to update balances and record transactions
        String queryWithdraw = "UPDATE Account SET balance = balance - ? WHERE account_id = ?";
        String queryDeposit = "UPDATE Account SET balance = balance + ? WHERE account_id = ?";
        String queryTransaction = "INSERT INTO Transaction (account_id, transaction_type, amount, transaction_date, initiating_account_number, receiving_account_number) VALUES (?, ?, ?, ?, ?, ?)";
        String getRecipientAccountIdQuery = "SELECT account_id FROM Account WHERE account_number = ?";

        try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection()) {
            connection.setAutoCommit(false); // Start transaction

            // Debug: Print accountId to confirm
            System.out.println("Sender Account ID: " + accountId);

            // Deduct amount from sender's account
            try (PreparedStatement withdrawStmt = connection.prepareStatement(queryWithdraw)) {
                double senderBalance = getBalanceByAccountId(accountId, connection);
                if (senderBalance < amount) {
                    System.out.println("Insufficient balance. Transaction canceled.");
                    connection.rollback();
                    return;
                }

                withdrawStmt.setDouble(1, amount);
                withdrawStmt.setInt(2, accountId);
                withdrawStmt.executeUpdate();
            }

            // Get recipient's account ID using account number
            int recipientAccountId = -1;
            try (PreparedStatement getRecipientAccountIdStmt = connection.prepareStatement(getRecipientAccountIdQuery)) {
                getRecipientAccountIdStmt.setString(1, recipientAccountNumber);
                ResultSet rs = getRecipientAccountIdStmt.executeQuery();
                if (rs.next()) {
                    recipientAccountId = rs.getInt("account_id");
                    System.out.println("Recipient Account ID: " + recipientAccountId); // Debug statement
                } else {
                    System.out.println("Recipient account not found. Transaction canceled.");
                    connection.rollback();
                    return;
                }
            }

            // Add amount to recipient's account
            try (PreparedStatement depositStmt = connection.prepareStatement(queryDeposit)) {
                depositStmt.setDouble(1, amount);
                depositStmt.setInt(2, recipientAccountId);
                depositStmt.executeUpdate();
            }

            // Record the transaction for the sender
            try (PreparedStatement recordStmt = connection.prepareStatement(queryTransaction)) {
                recordStmt.setInt(1, accountId);
                recordStmt.setString(2, "debit");
                recordStmt.setDouble(3, amount);
                recordStmt.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
                recordStmt.setString(5, getAccountNumberById(accountId, connection)); // Initiating account number
                recordStmt.setString(6, recipientAccountNumber); // Receiving account number
                recordStmt.executeUpdate();
            }

            // Record the transaction for the recipient
            try (PreparedStatement recordStmt = connection.prepareStatement(queryTransaction)) {
                recordStmt.setInt(1, recipientAccountId);
                recordStmt.setString(2, "credit");
                recordStmt.setDouble(3, amount);
                recordStmt.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
                recordStmt.setString(5, getAccountNumberById(accountId, connection)); // Initiating account number
                recordStmt.setString(6, recipientAccountNumber); // Receiving account number
                recordStmt.executeUpdate();
            }

            connection.commit(); // Commit transaction
            System.out.println("Money transferred successfully.");
        } catch (SQLException e) {
            System.err.println("Transaction failed: " + e.getMessage());
        }
    }

    public double getBalanceByAccountId(int accountId, Connection connection) throws SQLException {
        String query = "SELECT balance FROM Account WHERE account_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance");
            } else {
                throw new SQLException("Account not found for ID: " + accountId);
            }
        }
    }

    public String getAccountNumberById(int accountId, Connection connection) throws SQLException {
        String query = "SELECT account_number FROM Account WHERE account_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("account_number");
            } else {
                throw new SQLException("Account not found for ID: " + accountId);
            }
        }
    }
//-----------------Admin----------------------

    public void handleAdminLogin() throws SQLException {
        System.out.print("Enter admin username: ");
        String adminUsername = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String adminPassword = scanner.nextLine();

        // Hardcoded admin credentials for example purpose
        if ("admin".equals(adminUsername) && "admin1234".equals(adminPassword)) {
            try {
                displayAdminMenu();
            } catch (Exception ex) {
                Logger.getLogger(MenuDriven.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Invalid admin credentials. Please try again.");
        }
    }

    private void displayAdminMenu() throws SQLException {
        while (true) {
            System.out.println("""
                               Admin Portal
                               1. Add New Customer Account
                               2. Edit Existing Account
                               3. Remove Account by Account Number
                               4. View Account Details by Account Number
                               5. View All Account Details
                               6. Deposit Money
                               7. Withdraw Money
                               8. View Transactions
                               9. Logout""");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    handleAddNewCustomer();
                    break;
                case 2:
                    handleEditAccount();
                    break;
                case 3:
                    handleRemoveAccount();
                    break;
                case 4:
                    handleViewAccountDetailsByAccountNumber();
                    break;
                case 5:
                    handleViewAllAccounts();
                    break;
                case 6:
                    handleDepositMoney();
                    break;
                case 7:
                    handleWithdrawMoney();
                    break;
                case 8:
                    viewTransaction();
                case 9:
                    System.out.println("Logged out successfully.");
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
public void handleAddNewCustomer() throws SQLException {
    System.out.println("Enter your name: ");
    String name = scanner.nextLine();
    System.out.println("Enter your email: ");
    String email = scanner.nextLine();
    System.out.println("Enter your phone number: ");
    String phoneNumber = scanner.nextLine();
    System.out.println("Choose a username: ");
    String username = scanner.nextLine();
    System.out.println("Choose a password: ");
    String password = scanner.nextLine();
    System.out.println("Enter account number: ");
    String accountNumber = scanner.nextLine();
    System.out.println("Enter account type ( Savings, Current): ");
    String accountType = scanner.nextLine();
    System.out.println("Enter initial balance: ");
    double balance = Double.parseDouble(scanner.nextLine());

    // Check if a customer already exists
    if (doesCustomerExist(username, email)) {
        System.out.println("A customer with the same username or email already exists. Registration failed.");
        return;
    }

    String customerQuery = "INSERT INTO Customer (name, email, phone_number, username, password) VALUES (?, ?, ?, ?, ?)";
    String accountQuery = "INSERT INTO Account (account_number, account_type, balance, customer_id) VALUES (?, ?, ?, ?)";

    try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection(); 
         PreparedStatement customerPstmt = connection.prepareStatement(customerQuery, Statement.RETURN_GENERATED_KEYS);
         PreparedStatement accountPstmt = connection.prepareStatement(accountQuery)) {

        // Insert customer details
        customerPstmt.setString(1, name);
        customerPstmt.setString(2, email);
        customerPstmt.setString(3, phoneNumber);
        customerPstmt.setString(4, username);
        customerPstmt.setString(5, password);
        int customerRowsAffected = customerPstmt.executeUpdate();

        if (customerRowsAffected > 0) {
            System.out.println("Customer added successfully.");

            ResultSet generatedKeys = customerPstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int customerId = generatedKeys.getInt(1);

                accountPstmt.setString(1, accountNumber);
                accountPstmt.setString(2, accountType);
                accountPstmt.setDouble(3, balance);
                accountPstmt.setInt(4, customerId);

                int accountRowsAffected = accountPstmt.executeUpdate();
                if (accountRowsAffected > 0) {
                    System.out.println("Account created successfully.");
                } else {
                    System.out.println("Failed to create account.");
                }
            } else {
                System.out.println("Failed to retrieve customer ID.");
            }
        } else {
            System.out.println("Failed to add customer.");
        }
    } catch (SQLException e) {
        if (e.getErrorCode() == 1062) { 
            System.err.println("Error: Duplicate entry for username or email.");
        } else {
            System.err.println("Error adding customer: " + e.getMessage());
        }
    }
}



    private boolean doesCustomerExist(String username, String email) throws SQLException {
        String query = "SELECT COUNT(*) FROM Customer WHERE username = ? OR email = ?";
        try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            } else {
                return false;
            }
        }
    }
   
public void handleEditAccount() throws SQLException {
    System.out.println("Enter account number to edit: ");
    String accountNumber = scanner.nextLine();

    // Find the customer ID associated with the account number
    int customerId = findCustomerIdByAccountNumber(accountNumber);
    if (customerId == -1) {
        System.out.println("Account number not found. Update cancelled.");
        return;
    }

    // Display options to the admin
    System.out.println("What would you like to edit?");
    System.out.println("1. Phone Number");
    System.out.println("2. Email");
    System.out.println("3. Cancel");

    int choice = Integer.parseInt(scanner.nextLine());

    String fieldToEdit = null;
    String newValue = null;

    switch (choice) {
        case 1 -> {
            fieldToEdit = "phone_number";
            System.out.println("Enter new phone number: ");
            newValue = scanner.nextLine();
            }
        case 2 -> {
            fieldToEdit = "email";
            System.out.println("Enter new email: ");
            newValue = scanner.nextLine();
            }
        case 3 -> {
            System.out.println("Edit cancelled.");
            return; // Exit the method
            }
        default -> {
            System.out.println("Invalid option selected.");
            return; // Exit the method
            }
    }

    if (fieldToEdit != null && newValue != null) {
        String query = "UPDATE Customer SET " + fieldToEdit + " = ? WHERE customer_id = ?";
        try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, newValue);
            pstmt.setInt(2, customerId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer updated successfully.");
            } else {
                System.out.println("Failed to update customer. Please check the customer ID.");
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

private int findCustomerIdByAccountNumber(String accountNumber) throws SQLException {
    String query = "SELECT customer_id FROM Account WHERE account_number = ?";
    try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {

        pstmt.setString(1, accountNumber);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            return rs.getInt("customer_id");
        } else {
            return -1; // Account number not found
        }
    }
}


    public void handleRemoveAccount() throws SQLException {
        System.out.println("Enter the account number of the account you want to remove: ");
        String accountNumber = scanner.nextLine();

        String getCustomerIdQuery = "SELECT customer_id FROM Account WHERE account_number = ?";
        String deleteAccountQuery = "DELETE FROM Account WHERE account_number = ?";
        String deleteCustomerQuery = "DELETE FROM Customer WHERE customer_id = ?";

        try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection()) {
            connection.setAutoCommit(false); // Begin transaction

            try (PreparedStatement getCustomerIdStmt = connection.prepareStatement(getCustomerIdQuery); PreparedStatement deleteAccountStmt = connection.prepareStatement(deleteAccountQuery); PreparedStatement deleteCustomerStmt = connection.prepareStatement(deleteCustomerQuery)) {

                // Step 1: Get customer_id from Account table
                getCustomerIdStmt.setString(1, accountNumber);
                ResultSet rs = getCustomerIdStmt.executeQuery();
                if (rs.next()) {
                    int customerId = rs.getInt("customer_id");

                    // Step 2: Delete from Account table
                    deleteAccountStmt.setString(1, accountNumber);
                    int accountRowsAffected = deleteAccountStmt.executeUpdate();

                    // Step 3: Delete from Customer table
                    deleteCustomerStmt.setInt(1, customerId);
                    int customerRowsAffected = deleteCustomerStmt.executeUpdate();

                    // Check if both deletions were successful
                    if (accountRowsAffected > 0 && customerRowsAffected > 0) {
                        connection.commit(); // Commit transaction
                        System.out.println("Account and corresponding customer removed successfully.");
                    } else {
                        connection.rollback(); // Rollback transaction if something went wrong
                        System.out.println("Failed to remove account or customer. Please check the details.");
                    }
                } else {
                    System.out.println("Account not found. Please check the account number.");
                }
            } catch (SQLException e) {
                connection.rollback(); // Rollback transaction on any error
                System.out.println("An error occurred: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

//    private void handleViewAccountDetailsByAccountNumber() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    public void handleViewAccountDetailsByAccountNumber() throws SQLException {
        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();

        String query = "SELECT a.account_id, a.account_number, a.account_type, a.balance, c.customer_id, c.phone_number, c.email "
                + "FROM Account a "
                + "JOIN Customer c ON a.customer_id = c.customer_id "
                + "WHERE a.account_number = ?";

        try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection(); PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setString(1, accountNumber);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int accountId = rs.getInt("account_id");
                    String accountType = rs.getString("account_type");
                    double balance = rs.getDouble("balance");
                    int customerId = rs.getInt("customer_id");
                    String phoneNumber = rs.getString("phone_number");
                    String email = rs.getString("email");

                    System.out.println("Account ID: " + accountId + "\n"
                            + "Account Number: " + accountNumber + "\n"
                            + "Account Type: " + accountType + "\n"
                            + "Balance: " + balance + "\n"
                            + "Customer ID: " + customerId + "\n"
                            + "Phone Number: " + phoneNumber + "\n"
                            + "Email: " + email + "\n");

                } else {
                    System.out.println("No account found with the provided account number.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error fetching account details: " + e.getMessage());
        }
    }

      public void handleViewAllAccounts() throws SQLException {
    String query = "SELECT a.account_id, a.account_number, a.account_type, a.balance, c.customer_id, c.name, c.phone_number, c.email " +
                   "FROM Account a " +
                   "JOIN Customer c ON a.customer_id = c.customer_id";

    try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection(); 
         PreparedStatement pstmt = connection.prepareStatement(query); 
         ResultSet rs = pstmt.executeQuery()) {

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-15s %-10s %-15s %-15s %-15s %-25s%n", 
                          "Account ID", "Account Number", "Account Type", "Balance", "Customer ID", "Name", "Phone Number", "Email");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");

        while (rs.next()) {
            int accountId = rs.getInt("account_id");
            String accountNumber = rs.getString("account_number");
            String accountType = rs.getString("account_type");
            double balance = rs.getDouble("balance");
            int customerId = rs.getInt("customer_id");
            String name = rs.getString("name");
            String phoneNumber = rs.getString("phone_number");
            String email = rs.getString("email");

            System.out.printf("%-10s %-15s %-15s %-15s %-10s %-20s %-15s %-25s%n", 
                              accountId, accountNumber, accountType, balance, customerId, name, phoneNumber, email);
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
    }
}

    public void handleDepositMoney() throws SQLException {
    System.out.println("Enter account number: ");
    String accountNumber = scanner.nextLine();
    System.out.println("Enter amount to deposit: ");
    double amountToDeposit = scanner.nextDouble();
    scanner.nextLine(); // Consume newline

    String fetchBalanceQuery = "SELECT balance FROM Account WHERE account_number = ?";
    String updateBalanceQuery = "UPDATE Account SET balance = balance + ? WHERE account_number = ?";
    String insertTransactionQuery = "INSERT INTO Transaction (account_id, transaction_type, amount, transaction_date) VALUES (?, 'Deposit', ?, CURRENT_TIMESTAMP)";

    try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection(); 
         PreparedStatement fetchBalanceStmt = connection.prepareStatement(fetchBalanceQuery);
         PreparedStatement updateBalanceStmt = connection.prepareStatement(updateBalanceQuery);
         PreparedStatement insertTransactionStmt = connection.prepareStatement(insertTransactionQuery)) {

        connection.setAutoCommit(false); // Begin transaction

        // Fetch current balance
        fetchBalanceStmt.setString(1, accountNumber);
        ResultSet rs = fetchBalanceStmt.executeQuery();
        if (rs.next()) {
            double currentBalance = rs.getDouble("balance");

            // Update balance
            updateBalanceStmt.setDouble(1, amountToDeposit);
            updateBalanceStmt.setString(2, accountNumber);
            int rowsAffected = updateBalanceStmt.executeUpdate();

            if (rowsAffected > 0) {
                // Log transaction
                int accountId = fetchAccountIdByAccountNumber(accountNumber, connection); // Helper method to get account_id
                insertTransactionStmt.setInt(1, accountId);
                insertTransactionStmt.setDouble(2, amountToDeposit);
                insertTransactionStmt.executeUpdate();

                connection.commit(); // Commit transaction
                System.out.println("Deposit successful. New balance: " + (currentBalance + amountToDeposit));
            } else {
                connection.rollback(); // Rollback transaction if update fails
                System.out.println("Failed to deposit money.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }
}
    public int fetchAccountIdByAccountNumber(String accountNumber, Connection connection) throws SQLException {
    String query = "SELECT account_id FROM Account WHERE account_number = ?";
    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
        pstmt.setString(1, accountNumber);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("account_id");
        } else {
            throw new SQLException("Account with number " + accountNumber + " not found.");
        }
    }
}



    public void handleWithdrawMoney() throws SQLException {
    System.out.println("Enter account number: ");
    String accountNumber = scanner.nextLine();
    System.out.println("Enter amount to withdraw: ");
    double amountToWithdraw = scanner.nextDouble();
    scanner.nextLine(); // Consume newline

    String fetchBalanceQuery = "SELECT balance FROM Account WHERE account_number = ?";
    String updateBalanceQuery = "UPDATE Account SET balance = balance - ? WHERE account_number = ?";
    String insertTransactionQuery = "INSERT INTO Transaction (account_id, transaction_type, amount, transaction_date) VALUES (?, 'Withdrawal', ?, CURRENT_TIMESTAMP)";

    try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection(); 
         PreparedStatement fetchBalanceStmt = connection.prepareStatement(fetchBalanceQuery);
         PreparedStatement updateBalanceStmt = connection.prepareStatement(updateBalanceQuery);
         PreparedStatement insertTransactionStmt = connection.prepareStatement(insertTransactionQuery)) {

        connection.setAutoCommit(false); // Begin transaction

        // Fetch current balance
        fetchBalanceStmt.setString(1, accountNumber);
        ResultSet rs = fetchBalanceStmt.executeQuery();
        if (rs.next()) {
            double currentBalance = rs.getDouble("balance");

            if (currentBalance >= amountToWithdraw) {
                // Update balance
                updateBalanceStmt.setDouble(1, amountToWithdraw);
                updateBalanceStmt.setString(2, accountNumber);
                int rowsAffected = updateBalanceStmt.executeUpdate();

                if (rowsAffected > 0) {
                    // Log transaction
                    int accountId = fetchAccountIdByAccountNumber(accountNumber, connection); // Helper method to get account_id
                    insertTransactionStmt.setInt(1, accountId);
                    insertTransactionStmt.setDouble(2, amountToWithdraw);
                    insertTransactionStmt.executeUpdate();

                    connection.commit(); // Commit transaction
                    System.out.println("Withdrawal successful. New balance: " + (currentBalance - amountToWithdraw));
                } else {
                    connection.rollback(); // Rollback transaction if update fails
                    System.out.println("Failed to withdraw money.");
                }
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }
}



public void viewTransaction() throws SQLException {
    // SQL query to fetch transaction details
    String query = "SELECT transaction_id, account_id, transaction_type, amount, transaction_date, " +
                   "initiating_account_number, receiving_account_number " +
                   "FROM Transaction";

    try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
         PreparedStatement pstmt = connection.prepareStatement(query);
         ResultSet rs = pstmt.executeQuery()) {

        // Print table headers
        System.out.printf("%-15s %-10s %-15s %-10s %-20s %-25s %-25s%n", 
                          "Transaction ID", "Account ID", "Transaction Type", "Amount", 
                          "Transaction Date", "Initiating Acc. No.", "Receiving Acc. No.");
        System.out.println("------------------------------------------------------------------------------------");

        // Flag to check if any transactions are found
        boolean hasTransactions = false;

        // Iterate through the result set
        while (rs.next()) {
            hasTransactions = true;

            // Retrieve transaction details
            int transactionId = rs.getInt("transaction_id");
            int accountId = rs.getInt("account_id");
            String transactionType = rs.getString("transaction_type");
            double amount = rs.getDouble("amount");
            java.sql.Timestamp transactionDate = rs.getTimestamp("transaction_date");
            String initiatingAccountNumber = rs.getString("initiating_account_number");
            String receivingAccountNumber = rs.getString("receiving_account_number");

            // Print transaction details in a table format
            System.out.printf("%-15d %-10d %-15s %-10.2f %-20s %-25s %-25s%n", 
                              transactionId, accountId, transactionType, amount, 
                              transactionDate, 
                              (initiatingAccountNumber != null ? initiatingAccountNumber : "Payment done by Bank"),
                              (receivingAccountNumber != null ? receivingAccountNumber : "Payment done by Bank"));
        }

        // Inform the user if no transactions were found
        if (!hasTransactions) {
            System.out.println("No transactions found with initiating or receiving account number as null.");
        }

    } catch (SQLException e) {
        System.err.println("Error retrieving transactions: " + e.getMessage());
        e.printStackTrace();
    }
}
   


    

    

}
