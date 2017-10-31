package com.newqfx.qfx.Entity;

import com.newqfx.qfx.Entity.TblLocation;
import com.newqfx.qfx.Entity.TblShow;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-13T21:23:57")
@StaticMetamodel(TblTheatre.class)
public class TblTheatre_ { 

    public static volatile SingularAttribute<TblTheatre, TblLocation> hallId;
    public static volatile SingularAttribute<TblTheatre, Integer> thId;
    public static volatile SetAttribute<TblTheatre, TblShow> tblShowSet;
    public static volatile SingularAttribute<TblTheatre, String> thName;

}