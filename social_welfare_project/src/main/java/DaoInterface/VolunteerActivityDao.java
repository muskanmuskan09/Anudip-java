/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DaoInterface;

import java.util.List;
import models.VolunteerActivity;

/**
 *
 * @author Maninder Singh
 */
public interface VolunteerActivityDao {
    void addVolunteerActivity(VolunteerActivity activity);
    void updateVolunteerActivity(VolunteerActivity activity);
    void deleteVolunteerActivity(Integer activityId);
    VolunteerActivity getVolunteerActivityById(Integer activityId);
    List<VolunteerActivity> getAllVolunteerActivities();
    
}
