package com.newqfx.qfx.Entity;

import com.newqfx.qfx.Entity.TblCustomer;
import com.newqfx.qfx.Entity.TblShow;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-13T21:23:57")
@StaticMetamodel(TblTicket.class)
public class TblTicket_ { 

    public static volatile SingularAttribute<TblTicket, TblShow> showId;
    public static volatile SingularAttribute<TblTicket, String> ticketSeatNo;
    public static volatile SingularAttribute<TblTicket, Integer> ticketId;
    public static volatile SingularAttribute<TblTicket, TblCustomer> cId;

}