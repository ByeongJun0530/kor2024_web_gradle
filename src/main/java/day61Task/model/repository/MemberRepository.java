package day61Task.model.repository;

import day61Task.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository
                extends JpaRepository<MemberEntity, String> {

}
