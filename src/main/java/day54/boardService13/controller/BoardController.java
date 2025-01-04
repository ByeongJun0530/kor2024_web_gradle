package day54.boardService13.controller;

import day54.boardService13.model.dao.BoardDao;
import day54.boardService13.model.dto.BoardDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

// ======================= 콘솔 ======================= //
//public class BoardController {
//    // + 싱글톤
//    private static BoardController instance = new BoardController();
//    private BoardController(){}
//    public static BoardController getInstance(){return instance;}
//
//    // 1. 게시물 쓰기 제어 함수 [CRUD 중에 C, HTTP METHOD 중에 POST]
//    public boolean write(BoardDto boardDto){
//        boolean result = BoardDao.getInstance().write(boardDto);
//        return result;
//    }
//    // 2. 게시물 전체 조회 제어 함수 [CRUD 중에 R, HTTP METHOD 중에 GET]
//    public ArrayList<BoardDto> findAll() {
//        ArrayList<BoardDto> result = BoardDao.getInstance().findAll();
//        return result;
//    }
//}

// ====================== 웹 ======================= //
@RestController// 현재 클래스에 rest api 가 가능한 클래스임을 주입한다. + ResponseBody
// [1] 클래스 위에 @RestController
public class BoardController {
    // 1. 게시물 쓰기 제어 함수 [CRUD 중에 C, HTTP METHOD 중에 POST]
    // [2] 함수 위에 @XXXMapping("/주소만들기")
    // [TEST] Talend Api Tester : [POST] https://localhost:8080/write
    //                            [Headers] Content-type : application/json
    //                            [Body] {"btitle" : "테스트제목", "bcontent" : "테스트내용", "bwriter" : "테스트", "bpwd" : "1234"}
    @PostMapping("/write")
    public boolean write(@RequestBody BoardDto boardDto){ // body 데이터를 받기 위한 @RequestBody
        System.out.println("BoardController.write"); // soutm : 메소드명 출력함수 자동완성
        System.out.println("boardDto = " + boardDto); // soutp : 메소드 매개변수 출력함수 자동완성
        boolean result = BoardDao.getInstance().write(boardDto);
        return result;
    }// m end

    // 2. 게시물 전체 조회 제어 함수 [CRUD 중에 R, HTTP METHOD 중에 GET]
    // [2] 함수 위에 @XXXMapping("/주소만들기")
    // [TEST] Talend Api Tester : [POST] https://localhost:8080/findAll
    @GetMapping("/findAll")
    public ArrayList<BoardDto> findAll() {
        ArrayList<BoardDto> result = BoardDao.getInstance().findAll();
        return result;
    }// m end

    // 3. 게시물 개별 조회 [ CRUD 중에 R, HTTP METHOD 중에 GET, 쿼리스트링 ], 누구를 조회할지 bno가 매개변수로 필요로 한다.
    @GetMapping("/findid")
    // [TEST] Talend Api Tester : [GET] http://localhost:8080/findid?bno=조회할번호
    public BoardDto findid(@RequestParam int bno){
        System.out.println("BoardController.findid");
        System.out.println("bno = " + bno);
        BoardDto result = BoardDao.getInstance().findid(bno);
        return result;
    }// m end

    // 4. 게시물 수정 함수 [ CRUD 중에 U, HTTP METHOD 중에 PUT, BODY ]
    //[TEST] Talend Api Tester :
    //                  [PUT] http://localhost:8080/update
    //                  [Headers] Content-type : application/json
    //                  [Body] {"bno" : 3 ,  "btitle" : "수정한제목" ,  "bcontent" : "수정한내용" }
    @PutMapping ("/update")
    public boolean update(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.update");
        System.out.println("boardDto = " + boardDto);
        boolean result = BoardDao.getInstance().update(boardDto);
        return result;
    }// f end

    // 5. 게시물 삭제 함수 [ CRUD 중에 D, HTTP METHOD 중에 DELETE ]
    @DeleteMapping ("/delete")
    // [TEST] Talend Api Tester : [DELETE] http://localhost:8080/delete?bno=삭제할 번호
    public boolean delete(@RequestParam int bno){
        System.out.println("BoardController.delete");
        System.out.println("bno = " + bno);
        boolean result = BoardDao.getInstance().delete(bno);
        return result;
    }// f end
}// c end















