package models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Donation;
import models.NGO;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-18T12:44:02", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(NGODonation.class)
public class NGODonation_ { 

    public static volatile SingularAttribute<NGODonation, NGO> ngo;
    public static volatile SingularAttribute<NGODonation, Donation> donation;
    public static volatile SingularAttribute<NGODonation, Integer> ngoDonationId;

}