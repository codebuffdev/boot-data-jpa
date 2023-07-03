package in.codebuffdev.jpaannotations.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ToString
@Entity
@Table(
        name = "products",
        schema = "boot_jpa_basic",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique",
                        columnNames = "stock_keeping_unit"
                )
        }
)
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_seq_generator",
            sequenceName = "product_sequence_generator",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_generator")
    private Long id;
    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;
    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean isActive;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}
