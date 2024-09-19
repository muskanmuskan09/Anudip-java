/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImplementation;

/**
 *
 * @author muska
 */

import DaoInterface.AdminDao;
import models.Admin;
import java.util.HashMap;
import java.util.Map;

public class AdminDaoImpl implements AdminDao {
    // For demonstration purposes, using an in-memory map instead of a database
    private Map<String, Admin> adminDb = new HashMap<>();

    // Constructor to populate with a sample admin
    public AdminDaoImpl() {
        adminDb.put("admin", new Admin("admin", "password123"));
    }

    @Override
    public Admin getAdminByUsername(String username) {
        return adminDb.get(username); // Returns the Admin if exists, otherwise null
    }
}

