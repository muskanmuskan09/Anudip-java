package models;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.CleanUpActivity;
import models.User;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-18T12:44:02", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(CleanUpParticipation.class)
public class CleanUpParticipation_ { 

    public static volatile SingularAttribute<CleanUpParticipation, Date> dateOfParticipation;
    public static volatile SingularAttribute<CleanUpParticipation, CleanUpActivity> cleanupActivity;
    public static volatile SingularAttribute<CleanUpParticipation, User> user;
    public static volatile SingularAttribute<CleanUpParticipation, Integer> participationId;

}