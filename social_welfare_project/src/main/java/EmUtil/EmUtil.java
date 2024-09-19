/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Maninder Singh
 */
public class EmUtil {
     private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("user_role");
    }

    public static EntityManager provideEntityManager() {
        return emf.createEntityManager();
    }
    
}
