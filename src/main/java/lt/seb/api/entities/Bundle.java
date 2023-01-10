package lt.seb.api.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Bundles")
@Getter
@Setter
public class Bundle {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private Long bundleId;
    private Integer bundleValue;
    private String bundleName;
    private Long account;
    private Long debitCard;
    private Long creditCard;
}
