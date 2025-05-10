package entity;

import entity.Expense;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-10T16:55:46")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, String> name;
    public static volatile SingularAttribute<Category, Boolean> isGlobal;
    public static volatile SingularAttribute<Category, Long> id;
    public static volatile ListAttribute<Category, Expense> expenses;

}