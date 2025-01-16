package day64.JPA연관관계.model.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 현재 클래는 자체 매핑하지 않고 현재 클래스를 상속받은 클래스에서 멤버변수 매핑
@EntityListeners(AuditingEntityListener.class) // 엔티티의 변화 감지
public class BaseTime {
    @CreatedDate // 생성날짜 자동 주입
    private LocalDateTime cdate;
    @LastModifiedDate
    private LocalDateTime udate;
}
