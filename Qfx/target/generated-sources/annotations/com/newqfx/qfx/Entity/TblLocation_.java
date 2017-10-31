package com.newqfx.qfx.Entity;

import com.newqfx.qfx.Entity.TblTheatre;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-13T21:23:57")
@StaticMetamodel(TblLocation.class)
public class TblLocation_ { 

    public static volatile SingularAttribute<TblLocation, Integer> hallId;
    public static volatile SetAttribute<TblLocation, TblTheatre> tblTheatreSet;
    public static volatile SingularAttribute<TblLocation, String> hallLocation;
    public static volatile SingularAttribute<TblLocation, String> hallName;

}