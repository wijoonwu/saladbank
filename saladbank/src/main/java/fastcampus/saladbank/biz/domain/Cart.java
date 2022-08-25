package fastcampus.saladbank.biz.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CART")
@Getter
public class Cart extends BaseTime {

    @Id
    @Column(name = "CART_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    @JoinColumn(name = "PRODUCT_ID")
    private List<Product> product;
}
