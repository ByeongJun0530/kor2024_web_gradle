package day65task.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Getter@Setter@ToString@Builder
@NoArgsConstructor@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pro_no; // 제품번호
    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String proName; // 제품이름
    // 단방향
    @ManyToOne
    @JoinColumn(name = "cate_no")
    private CateEntity cateEntity;
    // 양방향
    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL)
    @Builder.Default
    List<OrderEntity> orderEntityList = new ArrayList<>();
}
