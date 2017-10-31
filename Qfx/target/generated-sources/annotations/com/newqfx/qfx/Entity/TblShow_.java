package com.newqfx.qfx.Entity;

import com.newqfx.qfx.Entity.TblMovie;
import com.newqfx.qfx.Entity.TblTheatre;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-13T21:23:57")
@StaticMetamodel(TblShow.class)
public class TblShow_ { 

    public static volatile SingularAttribute<TblShow, Integer> showId;
    public static volatile SingularAttribute<TblShow, String> showTime;
    public static volatile SingularAttribute<TblShow, TblTheatre> thId;
    public static volatile SingularAttribute<TblShow, TblMovie> mId;

}