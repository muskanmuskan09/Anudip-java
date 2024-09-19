/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DaoInterface;

import java.util.List;
import models.CleanUpActivity;

/**
 *
 * @author Maninder Singh
 */
public interface CleanUpActivityDao {
    void addCleanUpActivity(CleanUpActivity cleanUpActivity);
    void updateCleanUpActivity(CleanUpActivity cleanUpActivity);
    void deleteCleanUpActivity(Integer cleanUpId);
    CleanUpActivity getCleanUpActivityById(Integer cleanUpId);
    List<CleanUpActivity> getAllCleanUpActivities();
}
