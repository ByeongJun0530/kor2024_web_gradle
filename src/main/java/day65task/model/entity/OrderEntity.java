package day65task.model.entity;

import day65task.model.dto.OrderDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_list")
@Getter@Setter@ToString@Builder
@NoArgsConstructor@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_no; // 주문번호
    @Column(columnDefinition = "int")
    private int order_amount; // 주문수량
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String address;
    // + BaseTime
    // + 회원번호 단방향
    @ManyToOne
    @JoinColumn(name = "mno")
    private MemberEntity memberEntity;
    // + 제품번호 단방향
    @ManyToOne
    @JoinColumn(name = "pro_no")
    private ProductEntity productEntity;

    // entity --> dto
    public OrderDto toDto(){
        return OrderDto.builder()
                .order_no(this.order_no)
                .order_amount(this.order_amount)
                .address(this.address)
                .build();
    }
}
