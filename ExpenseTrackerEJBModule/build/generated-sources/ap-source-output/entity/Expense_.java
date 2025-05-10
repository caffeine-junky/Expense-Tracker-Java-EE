package entity;

import entity.Category;
import entity.User;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-10T16:55:46")
@StaticMetamodel(Expense.class)
public class Expense_ { 

    public static volatile SingularAttribute<Expense, LocalDate> date;
    public static volatile SingularAttribute<Expense, Double> amount;
    public static volatile SingularAttribute<Expense, String> description;
    public static volatile SingularAttribute<Expense, Long> id;
    public static volatile SingularAttribute<Expense, Category> category;
    public static volatile SingularAttribute<Expense, User> user;

}