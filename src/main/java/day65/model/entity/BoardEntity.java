package day65.model.entity;

import day65.model.dto.BoardDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "board")
@Getter@Setter@ToString@Builder
@NoArgsConstructor@AllArgsConstructor
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno; // 게시물 번호
    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String btitle; // 게시물 제목
    @Column(columnDefinition = "longtext")
    private String bcontent; // 게시물 내용
    // 단방향 설정
    @ManyToOne
    @JoinColumn(name = "mno") // FK 필드명
    private MemberEntity memberEntity;
    // entity --> dto
    public BoardDto toDto(){
        return BoardDto.builder()
                .bno(this.bno)
                .btitle(this.btitle)
                .bcontent(this.bcontent)
                .build();

    }
}
