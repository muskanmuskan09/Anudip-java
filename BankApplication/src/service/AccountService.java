/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Connection.ConnectionFactory;
import Dao.AccountDao;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author muska
 */
public class AccountService implements AccountDao{
    
     public Account getAccountDetails(int customerId) throws SQLException {
        String query = "SELECT Account.account_number, Account.account_type, Account.balance, "
                + "Customer.name, Customer.email, Customer.phone_number, Customer.username "
                + "FROM Account JOIN Customer ON Account.customer_id = Customer.customer_id "
                + "WHERE Account.customer_id = ?";
        try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setAccountNumber(rs.getString("account_number"));
                account.setAccountType(rs.getString("account_type"));
                account.setBalance(rs.getDouble("balance"));
                account.setName(rs.getString("name"));
                account.setEmail(rs.getString("email"));
                account.setPhoneNumber(rs.getString("phone_number"));
                account.setUsername(rs.getString("username"));
                return account;
            }
        }
        return null;
    }
     public List<Integer> getAccountIdsByCustomerId(int customerId) throws SQLException {
        List<Integer> accountIds = new ArrayList<>();
        String query = "SELECT account_id FROM Account WHERE customer_id = ?";
        
        try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                accountIds.add(resultSet.getInt("account_id"));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving account IDs: " + e.getMessage());
            throw e;
        }
        
        return accountIds;
    }
     public void viewTransactionHistory(List<Integer> accountIds) throws SQLException {
        String query = "SELECT transaction_type, amount, transaction_date, initiating_account_number, receiving_account_number " +
                       "FROM Transaction WHERE account_id = ? ORDER BY transaction_date DESC";

        try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            for (int accountId : accountIds) {
                pstmt.setInt(1, accountId);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    System.out.println("Transaction Type: " + rs.getString("transaction_type"));
                    System.out.println("Amount: " + rs.getDouble("amount"));
                    System.out.println("Date: " + rs.getTimestamp("transaction_date"));
                    System.out.println("Initiating Account Number: " + rs.getString("initiating_account_number"));
                    System.out.println("Receiving Account Number: " + rs.getString("receiving_account_number"));
                    System.out.println("----------------------------");
                }
            }
        }
    }
public boolean applyForLoan(int customerId, double amount, String loanType, double interestRate)throws SQLException {
        String query = "INSERT INTO Loan (loan_type, amount, interest_rate, duration, customer_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, loanType);
            pstmt.setDouble(2, amount);
            pstmt.setDouble(3, interestRate);
            pstmt.setInt(4, 5); // Example duration, replace as needed
            pstmt.setInt(5, customerId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error applying for loan: " + e.getMessage());
        }
        return false;
    }
//    boolean applyForLoan(int customerId, double amount, String loanType, double interestRate) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
   

