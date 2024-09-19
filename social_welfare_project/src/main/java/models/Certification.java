/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Certification")
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certification_id")
    private Integer certificationId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "issue_date")
    @Temporal(TemporalType.DATE)
    private Date issueDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private VolunteerActivity activity;

     public Certification() {
    }
     
    public Certification(Integer certificationId, String title, String description, Date issueDate, User user, VolunteerActivity activity) {
        this.certificationId = certificationId;
        this.title = title;
        this.description = description;
        this.issueDate = issueDate;
        this.user = user;
        this.activity = activity;
    }
 
    public Integer getCertificationId() {
        return certificationId;
    }

    public void setCertificationId(Integer certificationId) {
        this.certificationId = certificationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
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

  
    @Override
    public String toString() {
        return "Certification{" + "certificationId=" + certificationId + ", title=" + title + ", description=" + description + ", issueDate=" + issueDate + ", user=" + user + ", activity=" + activity + '}';
    }
}

