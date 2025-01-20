package day64task.model.entity;

import day65task.model.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orderList")
@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class OrderEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderNo; // 주문번호

    @Column(columnDefinition = "int", nullable = false)
    private int orderAmount; // 주문수량

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String address;

    // 단방향
    @ManyToOne
    @JoinColumn(name = "productNo")
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "mno")
    private MemberEntity memberEntity;
}
