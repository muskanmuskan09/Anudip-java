/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DaoInterface;

import java.util.List;
import models.CleanUpParticipation;

/**
 *
 * @author Maninder Singh
 */
public interface CleanUpParticipationDao {
    void addCleanUpParticipation(CleanUpParticipation participation);
    void updateCleanUpParticipation(CleanUpParticipation participation);
    void deleteCleanUpParticipation(Integer participationId);
    CleanUpParticipation getCleanUpParticipationById(Integer participationId);
    List<CleanUpParticipation> getAllCleanUpParticipations();
}
