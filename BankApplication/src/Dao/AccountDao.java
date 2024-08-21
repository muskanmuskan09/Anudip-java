/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import model.Account;

/**
 *
 * @author muska
 */
public interface AccountDao {
    
         public Account getAccountDetails(int customerId) throws SQLException ;
         public List<Integer> getAccountIdsByCustomerId(int customerId) throws SQLException ;
         public void viewTransactionHistory(List<Integer> accountIds) throws SQLException ;
         public boolean applyForLoan(int customerId, double amount, String loanType, double interestRate) throws SQLException;

}
