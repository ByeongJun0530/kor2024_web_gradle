package day65task.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter@Setter@ToString@Builder
@NoArgsConstructor@AllArgsConstructor
public class CateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cate_no; // 카테고리 번호
    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String cate_name; // 카테고리 이름

    // 양방향
    @OneToMany(mappedBy = "cateEntity", cascade = CascadeType.ALL)
    @Builder.Default
    List<ProductEntity> productEntityList = new ArrayList<>();
}
