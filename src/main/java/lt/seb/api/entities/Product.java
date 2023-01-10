package lt.seb.api.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Long productId;
    private String productName;
    private Integer minAge;
    private Integer minIncome;

}
