package com.newqfx.qfx.Entity;

import com.newqfx.qfx.Entity.TblTicket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-13T21:23:57")
@StaticMetamodel(TblCustomer.class)
public class TblCustomer_ { 

    public static volatile SetAttribute<TblCustomer, TblTicket> tblTicketSet;
    public static volatile SingularAttribute<TblCustomer, String> gender;
    public static volatile SingularAttribute<TblCustomer, String> cPassword;
    public static volatile SingularAttribute<TblCustomer, String> cEmail;
    public static volatile SingularAttribute<TblCustomer, Date> dob;
    public static volatile SingularAttribute<TblCustomer, String> fullName;
    public static volatile SingularAttribute<TblCustomer, String> location;
    public static volatile SingularAttribute<TblCustomer, Long> mobileNo;
    public static volatile SingularAttribute<TblCustomer, Integer> cId;

}