/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VolunteerActivity")
public class VolunteerActivity {
    public VolunteerActivity(){
    
    }

    @Override
    public String toString() {
        return "VolunteerActivity{" + "activityId=" + activityId + ", name=" + name + '}';
    }

    public VolunteerActivity(Integer activityId, String name, String description, Date date, String location, NGO ngo, User createdBy) {
        this.activityId = activityId;
        this.name = name;
        this.description = description;
        this.date = date;
        this.location = location;
        this.ngo = ngo;
        this.createdBy = createdBy;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public NGO getNgo() {
        return ngo;
    }

    public void setNgo(NGO ngo) {
        this.ngo = ngo;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Integer activityId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "location")
    private String location;

    @ManyToOne
    @JoinColumn(name = "ngo_id")
    private NGO ngo;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    // Getters and setters
}

