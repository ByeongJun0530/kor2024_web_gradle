package day57.webProject;

import lombok.*;

@NoArgsConstructor // 디폴트 생성자 코드 주입(넣어준다)
@AllArgsConstructor // 모든 매개변수의 생성자 코드 주입
@Getter // 멤버변수의 Getter 메소드
@Setter // 멤버변수의 Setter 메소드
@ToString // toString 메소드
@Builder // 빌터 패턴 메소드 지원
public class MemberDto {
    private String id;
    private String name;

    public MemberDto(String mid){}
}
