/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoInterface;

/**
 *
 * @author muska
 */


import models.Admin;

public interface AdminDao {
    Admin getAdminByUsername(String username);
}
