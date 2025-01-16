package day64task.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@DynamicInsert
@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class ProductEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productNo; // 제품번호
    @Column(columnDefinition = "varchar(20)", unique = true, nullable = false)
    private String productName; // 제품명
    @Column(columnDefinition = "int", nullable = false)
    private int productPrice; // 제품가격

    // 단방향
    @JoinColumn(name = "cateNo")
    @ManyToOne
    private CateEntity cateEntity;

    // 양방향
    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    List<OrderEntity> orderEntityList = new ArrayList<>();
}
