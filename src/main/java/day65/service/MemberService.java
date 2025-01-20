package day65.service;

import day65.model.dto.BoardDto;
import day65.model.entity.BoardEntity;
import day65.model.entity.MemberEntity;
import day65.model.repository.BoardRepository;
import day65.model.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {
    @Autowired private MemberRepository memberRepository;

    // [1] 내가 쓴 글 전체 조회
    public List<BoardDto> myBoardList(int mno){
        // 1. 지정한 mno의 회원 엔티티를 찾는다.
            // Optional 클래스 : null 값을 포함할 수 있는 객체
            // 특징 : 1. Null 값을 안전하게 유무 판단
            // 주요 메소드 :
                // 1. isPresent() : 값의 존재 여부 판단 함수
                // 2. get() : Optional 객체가 갖고 있는 값을 반환하는 함수
            // 사용처 : JPA의 findById() 함수가 반환 타입
        Optional<MemberEntity> optionalMember = memberRepository.findById(mno);
        if (optionalMember.isPresent()){ // 만약에 findById 함수로 찾은 mno의 엔티티가 존재하면
            MemberEntity entity = optionalMember.get(); // Optional 객체에서 엔티티를 꺼낸다.
            // 2. 찾은 엔티티에서 양방향으로 설정된 게시물 조회
            List<BoardEntity> boardEntityList = entity.getBoardEntityList();
            // 3. 모든 게시물 엔티티를 DTO로 변환
                // 방법1 , 일반 for 문
            /*
            List<BoardDto> list = new ArrayList<>();
            for (int index = 0; index <= boardEntityList.size()-1; index++){
                // 0부터 게시물엔티티리스트의 마지막 인덱스까지
                BoardEntity boardEntity = boardEntityList.get(index); // index 번째 엔티티 추출
                // 엔티티 dto 로 변환
                BoardDto boardDto = boardEntity.toDto();
                list.add(boardDto); // dto 를 list 에 저장
            }

             */
                // 방법2 , forEach(반복변수 -> {실행문;}) , => js 방식, -> java 방식
            /*
            List<BoardDto> list = new ArrayList<>();
            boardEntityList.forEach(boardEntity -> {
                list.add(boardEntity.toDto());
            });
             */
                // 방법3, .stream().map( 타입 :: 실행함수명 ).collector(Collectors.반환할컬렉션타입)
            List<BoardDto> list = boardEntityList.stream()
                    .map(BoardEntity :: toDto)
                    .collect(Collectors.toList()); // 반환타입
            return list;
        }
        return null;
    } // f end

    @Autowired BoardRepository boardRepository;
    // [2] 게시물 작성, 양방향 관계 일때
    @Transactional // 함수 안에서 insert, update, delete 쿼리문들을 트랜잭션 으로 사용,
    // 트랜잭션이란 ? 여러 작업들을 하나의 작업 단위로 묶어, 하나라도 작업이 실패하면 모두 실패/롤백/취소, 모두 성공해야 최종 성공
    public boolean myBoardWrite(BoardDto boardDto){

        // * 현재 로그인 된 회원이 게시물을 작성한다는 가정 :
        // 1. 현재 로그인 된 회원번호를 세션에서 조회한다.
        int loginMno = 1; // 예) 1번 회원이 로그인 된 상태일때 가정
            // 1-2 현재 로그인 된 회원번호의 회원엔티티 조회
        Optional<MemberEntity> optionalMember = memberRepository.findById(loginMno);
            // Optional : null 값을 저장하고 관리할 수 있는 객체
        if (optionalMember.isPresent() == false){
            return false; // 조회된 엔티티가 없으면 비 로그인 상태로 간주하여 함수 종료
        }
            // .get() : Optional 객체 내 엔티티 꺼내기
        MemberEntity memberEntity = optionalMember.get(); // 엔티티 꺼내기
        // 2. 게시물 엔티티 생성한다. dto --> 엔티티 변환, 엔티티 처음 생성할 때는 영속성(DB테이블과 매핑) 없다.
        BoardEntity boardEntity = boardDto.toEntity();
        // 3. 게시물 엔티티에 회원엔티티 넣어주기.
        boardEntity.setMemberEntity(memberEntity);
        // 4. 게시물 엔티티 저장하기
        BoardEntity saveEntity = boardRepository.save(boardEntity);
        // 5. .save(엔티티) : 엔티티 저장을 성공하면 성공한 엔티티 영속성(자바객체 <---> DB테이블) 연결/매핑
        if (saveEntity.getBno() > 0){return true;} // 0보다크다 : pk번호는 1번 부터 시작하므로
        return false;
    }
} // cls end






















