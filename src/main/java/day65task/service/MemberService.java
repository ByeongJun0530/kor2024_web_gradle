package day65task.service;

import day65task.model.dto.OrderDto;
import day65task.model.entity.MemberEntity;
import day65task.model.entity.OrderEntity;
import day65task.model.repository.MemberRepository;
import day65task.model.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired private OrderRepository orderRepository;
    @Autowired private MemberRepository memberRepository;
    // 주문 등록
    @Transactional
    public boolean myOrderRegist(OrderDto orderDto){
        int loginMno = 1; // 로그인 상태 가정
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(loginMno);
        if (optionalMemberEntity.isPresent() == false){
            return false;
        }
        // 객체 내 엔티티 꺼내기
        MemberEntity memberEntity = optionalMemberEntity.get();
        // 주문 엔티티 생성
        OrderEntity orderEntity = orderDto.toEntity();
        // 주문 엔티티에 회원 엔티티 삽입
        orderEntity.setMemberEntity(memberEntity);
        // 주문 엔티티 저장
        OrderEntity saveEntity = orderRepository.save(orderEntity);
        // 저장 성공시 엔티티 영속성 맵핑
        if (saveEntity.getOrder_no() > 0){return true;}
            return false;
    }

    // 주문 조회
    public List<OrderDto> myOrderPrint(int mno){
        // mno 회원 엔티티 조회
        Optional<MemberEntity> optionalMember = memberRepository.findById(mno);
        if (optionalMember.isPresent()){
            MemberEntity entity = optionalMember.get(); // 객체에서 엔티티 꺼내기
            // 엔티티에서 양방향 설정된 주문 조회
            List<OrderEntity> orderEntityList = entity.getOrderEntityList();
            // 모든 주문 엔티티 DTO 변환
            List<OrderDto> list = new ArrayList<>();
            orderEntityList.forEach(orderEntity -> {
                list.add(orderEntity.toDto());
            });
            return list;
        }
        return null;
    }
}
