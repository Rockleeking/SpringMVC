package com.newqfx.qfx.Entity;

import com.newqfx.qfx.Entity.TblMenu;
import com.newqfx.qfx.Entity.TblMenuItem;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-13T21:23:57")
@StaticMetamodel(TblPage.class)
public class TblPage_ { 

    public static volatile SingularAttribute<TblPage, String> pageSlug;
    public static volatile SetAttribute<TblPage, TblMenu> tblMenuSet;
    public static volatile SingularAttribute<TblPage, String> pageContent;
    public static volatile SetAttribute<TblPage, TblMenuItem> tblMenuItemSet;
    public static volatile SingularAttribute<TblPage, Integer> pageId;
    public static volatile SingularAttribute<TblPage, String> pageName;

}