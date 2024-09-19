package models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Donation;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-09-18T12:44:02", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(TreeDonation.class)
public class TreeDonation_ { 

    public static volatile SingularAttribute<TreeDonation, Integer> quantity;
    public static volatile SingularAttribute<TreeDonation, String> treeType;
    public static volatile SingularAttribute<TreeDonation, Integer> treeDonationId;
    public static volatile SingularAttribute<TreeDonation, String> plantingLocation;
    public static volatile SingularAttribute<TreeDonation, Donation> donation;

}