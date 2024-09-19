/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VolunteerParticipation")
public class VolunteerParticipation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participation_id")
    private Integer participationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private VolunteerActivity activity;

    @Column(name = "date_of_participation")
    @Temporal(TemporalType.DATE)
    private Date dateOfParticipation;

    public VolunteerParticipation(){
    
    }

    public VolunteerParticipation(Integer participationId, User user, VolunteerActivity activity, Date dateOfParticipation) {
        this.participationId = participationId;
        this.user = user;
        this.activity = activity;
        this.dateOfParticipation = dateOfParticipation;
    }

    public Integer getParticipationId() {
        return participationId;
    }

    public void setParticipationId(Integer participationId) {
        this.participationId = participationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VolunteerActivity getActivity() {
        return activity;
    }

    public void setActivity(VolunteerActivity activity) {
        this.activity = activity;
    }

    public Date getDateOfParticipation() {
        return dateOfParticipation;
    }

    public void setDateOfParticipation(Date dateOfParticipation) {
        this.dateOfParticipation = dateOfParticipation;
    }

    @Override
    public String toString() {
        return "VolunteerParticipation{" + "participationId=" + participationId + ", user=" + user + ", activity=" + activity + ", dateOfParticipation=" + dateOfParticipation + '}';
    }
 
}

