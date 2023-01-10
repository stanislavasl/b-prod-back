package lt.seb.api.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Long customerId;
    private Long customerPersonalCode;
    private String firstName;
    private String secondName;
    private Integer age;
    private Boolean isStudent;
    private Long annualIncome;
    private Long account;
    private Long debitCard;
    private Long creditCard;
}
