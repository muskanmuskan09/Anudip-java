package models;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.User;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-18T12:44:02", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Donation.class)
public class Donation_ { 

    public static volatile SingularAttribute<Donation, Date> date;
    public static volatile SingularAttribute<Donation, BigDecimal> amount;
    public static volatile SingularAttribute<Donation, Integer> donationId;
    public static volatile SingularAttribute<Donation, String> itemDescription;
    public static volatile SingularAttribute<Donation, String> donationType;
    public static volatile SingularAttribute<Donation, User> user;

}