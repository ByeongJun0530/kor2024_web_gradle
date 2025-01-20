package day65.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter@Setter@ToString@Builder
@NoArgsConstructor@AllArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno; // 회원번호
    @Column(columnDefinition = "varchar(30)", nullable = false, unique = true)
    private String mid; // 회원아이디
    @Column(columnDefinition = "varchar(50)")
    private String mpwd; // 회원비밀번호
    // 양방향
    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.ALL)
    @Builder.Default // 빌터패턴 사용시 초기값 설정
    List<BoardEntity> boardEntityList = new ArrayList<>();

}
