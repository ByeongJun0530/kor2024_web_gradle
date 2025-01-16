package day63.model.entity;

import day63.model.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

@Entity // 현재 클래스의 데이터베이스의 테이블과 매핑 정의
@Table(name = "member") // 테이블의 이름 정의
@Getter@Setter@ToString@Builder
@NoArgsConstructor@AllArgsConstructor
public class MemberEntity extends BaseTime{

    // ============= 테이블의 필드/속성 설계 day 59 회원 테이블과 비교 ============== //

    @Id // primary key 제약 조건 정의
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 제약조건 정의
    private int mno; // 회원번호

    @Column(columnDefinition = "varchar(30)",
            nullable = false, unique = true)
    private String mid; // 회원아이디( not null, unique 제약조건)

    @Column(columnDefinition = "varchar(30)",nullable = false)
    private String mpwd; // 회원비밀번호( not null )

    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String mname; // 회원 닉네임( not null )

    @Column(columnDefinition = "varchar(13)", nullable = false, unique = true)
    private String mphone; // 회원 전화번호( not null, unique 제약조건 )

    // Entity --> DTO 변환 메소드 (롬복에서 제공하지 않음)
    public MemberDto toDto(){
        // + 빌더패턴 이용한 인스턴스 생성
        // 클래스명.builder().필드명(새로운값).build();
        return MemberDto.builder() // .builder() 빌더 패턴의 시작점
                .mno(this.mno)
                .mid(this.mid)
                // 패스워드 보안상 생략
                .mname(this.mname)
                .mphone(this.mphone)
                .build(); // .build() 빌더 패턴의 끝마침.
    }// f end

}// cls end

















