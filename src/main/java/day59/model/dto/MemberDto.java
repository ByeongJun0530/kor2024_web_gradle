package day59.model.dto;

import lombok.*;

// 롬복 : 반복되는 코드들을 자동으로 주입해주는 라이브러리
@NoArgsConstructor // 디폴트 생성자
@AllArgsConstructor // 풀 생성자
@Getter // Getter
@Setter // Setter
@ToString // ToString
@Builder // 빌더 패턴 제공
public class MemberDto {
    private int mno;
    private String mid;
    private String mpwd;
    private String mname;
    private String mphone;
}
