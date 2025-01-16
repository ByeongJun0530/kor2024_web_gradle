package day64.객체연관관계;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter@Builder@ToString
@NoArgsConstructor@AllArgsConstructor
public class 게시물 {
    private int 게시물번호;
    private String 게시물제목;
    private String 게시물내용;
    // 단방향
    private 회원 게시물작성자FK;
    // 양방향
    @ToString.Exclude @Builder.Default
    List<댓글> 댓글목록 = new ArrayList<>();
}
