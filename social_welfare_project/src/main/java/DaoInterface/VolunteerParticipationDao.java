/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DaoInterface;

import java.util.List;
import models.VolunteerParticipation;

/**
 *
 * @author Maninder Singh
 */
public interface VolunteerParticipationDao {
       void addVolunteerParticipation(VolunteerParticipation participation);
    void updateVolunteerParticipation(VolunteerParticipation participation);
    void deleteVolunteerParticipation(Integer participationId);
    VolunteerParticipation getVolunteerParticipationById(Integer participationId);
    List<VolunteerParticipation> getAllVolunteerParticipations();
}
