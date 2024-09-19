package models;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.User;
import models.VolunteerActivity;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-18T12:44:02", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(VolunteerParticipation.class)
public class VolunteerParticipation_ { 

    public static volatile SingularAttribute<VolunteerParticipation, Date> dateOfParticipation;
    public static volatile SingularAttribute<VolunteerParticipation, VolunteerActivity> activity;
    public static volatile SingularAttribute<VolunteerParticipation, User> user;
    public static volatile SingularAttribute<VolunteerParticipation, Integer> participationId;

}