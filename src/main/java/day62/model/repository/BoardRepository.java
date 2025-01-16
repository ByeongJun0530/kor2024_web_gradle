package day62.model.repository;

import day62.model.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// MVC 컴포넌트 공통 : 컴포넌트 스캔을 통해 자동으로 스프링 컨테이너에 빈(인스턴스) 생성한다. (싱글톤 X)
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
}
