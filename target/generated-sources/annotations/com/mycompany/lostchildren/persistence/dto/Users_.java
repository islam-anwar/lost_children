package com.mycompany.lostchildren.persistence.dto;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Users.class)
public abstract class Users_ {

	public static volatile SingularAttribute<Users, String> firstName;
	public static volatile SingularAttribute<Users, String> lastName;
	public static volatile SingularAttribute<Users, String> password;
	public static volatile SingularAttribute<Users, String> address;
	public static volatile CollectionAttribute<Users, Lost> lostCollection;
	public static volatile SingularAttribute<Users, String> phone;
	public static volatile SingularAttribute<Users, String> imageUrl;
	public static volatile SingularAttribute<Users, Integer> id;
	public static volatile CollectionAttribute<Users, Found> foundCollection;
	public static volatile SingularAttribute<Users, String> email;

}

