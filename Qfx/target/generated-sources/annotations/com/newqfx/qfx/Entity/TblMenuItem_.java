package com.newqfx.qfx.Entity;

import com.newqfx.qfx.Entity.Link;
import com.newqfx.qfx.Entity.TblPage;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-13T21:23:57")
@StaticMetamodel(TblMenuItem.class)
public class TblMenuItem_ { 

    public static volatile SetAttribute<TblMenuItem, Link> linkSet;
    public static volatile SingularAttribute<TblMenuItem, String> menuItemName;
    public static volatile SingularAttribute<TblMenuItem, TblPage> pageId;
    public static volatile SingularAttribute<TblMenuItem, Integer> menuItemId;

}