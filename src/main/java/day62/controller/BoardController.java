package day62.controller;

import day62.model.entity.BoardEntity;
import day62.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// MVC 컴포넌트 공통 : 컴포넌트 스캔을 통해 자동으로 스프링 컨테이너에 빈(인스턴스) 생성한다. (싱글톤 X)
// 1. 사용자가 보내는 HTTP(fetch/talend api) 요청은 모두 Controller 에서 찾는다. ( HTTP 가 요청이 오고 응답이 가는 곳)
public class BoardController {
    // 싱글톤 x : 스프링은 자동으로 빈(인스턴스)를 생성하고 관리를 해준다. 개발자가 인스턴스 관리를 Spring에게 위임하다. IOC : 제어 역전
    @Autowired private BoardService boardService;
    // 컨트롤러는 무조건 서비스에게 요청하고 응답을 받는다.
        // 규칙 : 컨트롤러에서 리포지토리/엔티티 객체를 사용하면 안된다.

    // 프레임워크가 관례적으로 CRUD 구현할 때 사용되는 어노테이션
    // C : @PostMapping R : @GetMapping U : @PutMapping D : @DeleteMapping ("HTTP 매핑 주소 정의")
    // HTTP 요청 데이터 전송 방식 : 1.HTTP Header body @RequestBody vs 2.queryString @RequestParam, 2.HTTP.txt 참고

    // C : 게시물 쓰기
    @PostMapping("/write") // localhost:8080/write,
    // {"btitle" : "제목1","bcontent" : "내용1", "bwriter" : "작성자1","bpwd" : "1234"}
    public boolean write(@RequestBody BoardEntity boardEntity){
        return boardService.write(boardEntity);
    }

    // R : 게시물 전체 조회
    @GetMapping("/printall") // localhost:8080/printall
    public List<BoardEntity> printall(){
        return boardService.printall();
    }

    // R : 게시물 개별 조회
    @GetMapping("/print") // localhost:8080/print?bno=1
    public BoardEntity print(@RequestParam int bno){
        return boardService.print(bno);
    }

    // U : 게시물 수정
    @PutMapping("/update") // localhost:8080/update,
    // { "bno" : "1", "btitle" : "수정제목","bcontent" : "수정내용"}
    public boolean update(@RequestBody BoardEntity boardEntity){
        return boardService.update(boardEntity);
    }

    // D : 게시물 삭제
    @DeleteMapping("/delete") // // localhost:8080/delete?bno=1
    public boolean delete(@RequestParam int bno){
        return boardService.delete(bno);
    }

}
