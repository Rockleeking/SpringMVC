package com.newqfx.qfx.Entity;

import com.newqfx.qfx.Entity.TblMenu;
import com.newqfx.qfx.Entity.TblMenuItem;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-13T21:23:57")
@StaticMetamodel(Link.class)
public class Link_ { 

    public static volatile SingularAttribute<Link, Integer> linkId;
    public static volatile SingularAttribute<Link, TblMenu> menuId;
    public static volatile SingularAttribute<Link, TblMenuItem> menuItemId;

}