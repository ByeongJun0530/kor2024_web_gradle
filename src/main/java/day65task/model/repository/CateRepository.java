package day65task.model.repository;

import day65task.model.entity.CateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CateRepository extends JpaRepository<CateEntity, Integer> {
}
