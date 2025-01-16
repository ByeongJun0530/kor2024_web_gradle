package day63.service;

import day63.model.dto.MemberDto;
import day63.model.entity.MemberEntity;
import day63.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    @Autowired private MemberRepository memberRepository;

    // 1. 회원가입
    public boolean signup(MemberDto memberDto){
        // 1. 저장할 DTO 를 entity 로 반환한다.
        MemberEntity memberEntity = memberDto.toEntity();
        // 2. 변환된 entity 를 save 한다.
        // 3. 세이브된 결과 entity 반환 받는다.
        MemberEntity saveEntity = memberRepository.save(memberEntity);
        // 4. 회원번호(A.I) 확인하여 엔티티가 잘 생성되었는지 확인한다.
        if (saveEntity.getMno() > 0){ // 만약에 회원번호가 생성되었다면
            return true; // 회원가입 성공
        }else {
            return false; // 회원가입 실패
        }
    }
    // 2. 모든 회원 목록 조회
    public List<MemberDto> infolist(){
        // 1. 모든 엔티티를 조회한다.
        List<MemberEntity> entityList = memberRepository.findAll();
        // 2. 모든 엔티티를 DTO로 변환한다.
        List<MemberDto> list = new ArrayList<>(); // 변환된 DTO를 저장할 리스트 선언
        for (int index = 0; index <= entityList.size()-1; index++){
            // 0부터 엔티티리스트의 마지막 인덱스까지 1씩 증가 반복
            MemberEntity entity = entityList.get(index);
            // index 번째의 엔티티 1개 반환한다.
            list.add(entity.toDto()); // index 번째의 엔티티를 DTO로 변환 후 리스트 저장
        }
        return list; // 모든 엔티티를 DTO로 변환 후 반환
    }
}















