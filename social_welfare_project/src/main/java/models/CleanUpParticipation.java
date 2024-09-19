/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CleanUpParticipation")
public class CleanUpParticipation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participation_id")
    private Integer participationId;

    @ManyToOne
    @JoinColumn(name = "cleanup_id")
    private CleanUpActivity cleanupActivity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "date_of_participation")
    @Temporal(TemporalType.DATE)
    private Date dateOfParticipation;
  
    
    public CleanUpParticipation(){
        
    }
    
    public CleanUpParticipation(Integer participationId, CleanUpActivity cleanupActivity, User user, Date dateOfParticipation) {
        this.participationId = participationId;
        this.cleanupActivity = cleanupActivity;
        this.user = user;
        this.dateOfParticipation = dateOfParticipation;
    }
   
    public Integer getParticipationId() {
        return participationId;
    }

    public void setParticipationId(Integer participationId) {
        this.participationId = participationId;
    }

    public CleanUpActivity getCleanupActivity() {
        return cleanupActivity;
    }

    public void setCleanupActivity(CleanUpActivity cleanupActivity) {
        this.cleanupActivity = cleanupActivity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateOfParticipation() {
        return dateOfParticipation;
    }

    public void setDateOfParticipation(Date dateOfParticipation) {
        this.dateOfParticipation = dateOfParticipation;
    }

    @Override
    public String toString() {
        return "CleanUpParticipation{" + "participationId=" + participationId + ", cleanupActivity=" + cleanupActivity + ", user=" + user + ", dateOfParticipation=" + dateOfParticipation + '}';
    }}

