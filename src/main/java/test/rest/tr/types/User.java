package test.rest.tr.types;

import test.rest.tr.types.Expense;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_user")
public class User {

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id;

    String name;

    @Column(unique = true)
    String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    List<Expense> expenses = new ArrayList<Expense>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
