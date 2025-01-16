package day64task.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class CateEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cateNo; // 카테고리 번호
    @Column(columnDefinition = "varchar(20)", unique = true, nullable = false)
    private String cateName;

    // 양방향
    @OneToMany(mappedBy = "cateEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    private List<ProductEntity> productEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "cateEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @Builder.Default
    private List<OrderEntity> orderEntityList = new ArrayList<>();

}
