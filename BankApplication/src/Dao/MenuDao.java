/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.SQLException;


/**
 *
 * @author muska
 */
public interface MenuDao {

    //      -------Admin Functionality---------
    public void handleAddNewCustomer() throws SQLException;
    public void handleEditAccount() throws SQLException;
    public void handleRemoveAccount()throws SQLException ;
    public void handleViewAccountDetailsByAccountNumber()throws SQLException ;
    public void handleViewAllAccounts()throws SQLException ;
    public void handleDepositMoney() throws SQLException ;
    public int  fetchAccountIdByAccountNumber(String accountNumber, Connection connection) throws SQLException ;
    public void handleWithdrawMoney() throws SQLException ;
    public void viewTransaction()throws SQLException ;
//    ---------Customer Functionality------
    public void displayMenu();
    public int handleLogin() ;
    public void displayPostLoginMenu(int accountId)throws SQLException;
    public void handleTransferMoney(int accountId) throws SQLException;
    public void handleViewTransactionHistory(int accountId)throws SQLException;
    

    
}
