package com.mycompany.lostchildren.persistence.dto;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Lost.class)
public abstract class Lost_ {

	public static volatile SingularAttribute<Lost, String> lostDate;
	public static volatile SingularAttribute<Lost, String> lastName;
	public static volatile SingularAttribute<Lost, String> gender;
	public static volatile SingularAttribute<Lost, String> motherName;
	public static volatile SingularAttribute<Lost, String> description;
	public static volatile SingularAttribute<Lost, String> firstName;
	public static volatile SingularAttribute<Lost, String> orginalAddress;
	public static volatile SingularAttribute<Lost, String> phone;
	public static volatile SingularAttribute<Lost, String> imageUrl;
	public static volatile SingularAttribute<Lost, Integer> id;
	public static volatile SingularAttribute<Lost, Users> lostUserId;
	public static volatile SingularAttribute<Lost, String> returned;
	public static volatile SingularAttribute<Lost, String> lostLocation;
	public static volatile SingularAttribute<Lost, Integer> age;

}

