package models;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.NGO;
import models.User;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-18T12:44:02", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(VolunteerActivity.class)
public class VolunteerActivity_ { 

    public static volatile SingularAttribute<VolunteerActivity, Date> date;
    public static volatile SingularAttribute<VolunteerActivity, Integer> activityId;
    public static volatile SingularAttribute<VolunteerActivity, User> createdBy;
    public static volatile SingularAttribute<VolunteerActivity, NGO> ngo;
    public static volatile SingularAttribute<VolunteerActivity, String> name;
    public static volatile SingularAttribute<VolunteerActivity, String> description;
    public static volatile SingularAttribute<VolunteerActivity, String> location;

}