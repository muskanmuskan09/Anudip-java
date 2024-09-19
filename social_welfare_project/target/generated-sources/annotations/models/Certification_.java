package models;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.User;
import models.VolunteerActivity;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-18T12:44:02", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Certification.class)
public class Certification_ { 

    public static volatile SingularAttribute<Certification, VolunteerActivity> activity;
    public static volatile SingularAttribute<Certification, Integer> certificationId;
    public static volatile SingularAttribute<Certification, String> description;
    public static volatile SingularAttribute<Certification, String> title;
    public static volatile SingularAttribute<Certification, Date> issueDate;
    public static volatile SingularAttribute<Certification, User> user;

}