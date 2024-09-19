package models;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.User;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-18T12:44:02", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(CleanUpActivity.class)
public class CleanUpActivity_ { 

    public static volatile SingularAttribute<CleanUpActivity, Date> date;
    public static volatile SingularAttribute<CleanUpActivity, User> createdBy;
    public static volatile SingularAttribute<CleanUpActivity, Integer> cleanupId;
    public static volatile SingularAttribute<CleanUpActivity, String> description;
    public static volatile SingularAttribute<CleanUpActivity, String> location;

}