package day64task.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_list")
@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class OrderEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderNo; // 주문번호

    @Column(columnDefinition = "int", nullable = false)
    private int orderAmount; // 주문수량

    // 단방향
    @ManyToOne
    @JoinColumn(name = "cateNo")
    private CateEntity cateEntity;

    @ManyToOne
    @JoinColumn(name = "productNo")
    private ProductEntity productEntity;
}
