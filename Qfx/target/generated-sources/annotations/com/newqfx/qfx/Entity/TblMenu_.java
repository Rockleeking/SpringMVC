package com.newqfx.qfx.Entity;

import com.newqfx.qfx.Entity.Link;
import com.newqfx.qfx.Entity.TblPage;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-13T21:23:57")
@StaticMetamodel(TblMenu.class)
public class TblMenu_ { 

    public static volatile SetAttribute<TblMenu, Link> linkSet;
    public static volatile SingularAttribute<TblMenu, Integer> menuId;
    public static volatile SingularAttribute<TblMenu, String> menuName;
    public static volatile SingularAttribute<TblMenu, TblPage> pageId;

}