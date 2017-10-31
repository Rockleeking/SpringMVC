package com.newqfx.qfx.Entity;

import com.newqfx.qfx.Entity.TblShow;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-13T21:23:57")
@StaticMetamodel(TblMovie.class)
public class TblMovie_ { 

    public static volatile SingularAttribute<TblMovie, String> mPhotoUrl;
    public static volatile SingularAttribute<TblMovie, String> mCast;
    public static volatile SingularAttribute<TblMovie, Date> mReleaseDate;
    public static volatile SingularAttribute<TblMovie, Integer> mId;
    public static volatile SingularAttribute<TblMovie, String> mTrailerUrl;
    public static volatile SingularAttribute<TblMovie, String> mName;
    public static volatile SingularAttribute<TblMovie, String> mTime;
    public static volatile SingularAttribute<TblMovie, String> mDesc;
    public static volatile SingularAttribute<TblMovie, String> mDirector;
    public static volatile SingularAttribute<TblMovie, String> mGenre;
    public static volatile SetAttribute<TblMovie, TblShow> tblShowSet;

}