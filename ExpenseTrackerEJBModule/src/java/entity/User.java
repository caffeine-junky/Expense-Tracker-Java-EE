package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;
import javax.persistence.CascadeType;

/**
 *
 * @author moses
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;

    private String password;

    @Column(nullable = false)
    private String userRole; // "USER" or "ADMIN"

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Expense> expenses;

    public User() {}

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.userRole = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
