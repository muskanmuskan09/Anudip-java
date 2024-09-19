/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CleanUpActivity")
public class CleanUpActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cleanup_id")
    private Integer cleanupId;

    @Column(name = "location")
    private String location;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    public CleanUpActivity(){
    
    }
    
    public CleanUpActivity(Integer cleanupId, String location, Date date, String description, User createdBy) {
        this.cleanupId = cleanupId;
        this.location = location;
        this.date = date;
        this.description = description;
        this.createdBy = createdBy;
    }
    public Integer getCleanupId() {
        return cleanupId;
    }

    public void setCleanupId(Integer cleanupId) {
        this.cleanupId = cleanupId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
 @Override
    public String toString() {
        return "CleanUpActivity{" + "cleanupId=" + cleanupId + ", location=" + location + ", date=" + date + ", description=" + description + ", createdBy=" + createdBy + '}';
    }


}

