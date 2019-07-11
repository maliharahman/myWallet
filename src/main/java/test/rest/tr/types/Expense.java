package test.rest.tr.types;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_expense")
public class Expense {

    @Id
    @Column(name = "expenseId")
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id;

    @JoinColumn(name = "userId")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    User user;

    String description;
    long amount;
    Date timestamp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
