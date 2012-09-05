package com.mdstech.workflow.domain.customer;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.mdstech.workflow.type.GenderType;
import com.mdstech.workflow.type.MaritalStatusType;
import com.mdstech.workflow.type.SalutationType;

@StaticMetamodel(Customer.class)
public class Customer_ {
	public static volatile SingularAttribute<Customer, String> lastName;
	public static volatile SingularAttribute<Customer, String> firstName;
	public static volatile SingularAttribute<Customer, String> middleName;
	public static volatile SingularAttribute<Customer, String> occupation;
	public static volatile SingularAttribute<Customer, String> orgName;
	public static volatile SingularAttribute<Customer, String> email;
	public static volatile SingularAttribute<Customer, GenderType> genderType;
	public static volatile SingularAttribute<Customer, Date> birthDate;
	public static volatile SingularAttribute<Customer, MaritalStatusType> maritalStatusType;
	public static volatile SingularAttribute<Customer, SalutationType> salutationType;

}
