package day65task.model.dto;

import day65task.model.entity.OrderEntity;
import lombok.*;

@Getter@Setter@ToString@Builder
@NoArgsConstructor@AllArgsConstructor
public class OrderDto {
    private int order_no;
    private int order_amount;
    private String address;

    // DTO -> entity
    public OrderEntity toEntity(){
        return OrderEntity.builder()
                .order_no(this.order_no)
                .order_amount(this.order_amount)
                .address(this.address)
                .build();
    }
}
