package day65.controller;

import day65.model.dto.BoardDto;
import day65.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    @Autowired private MemberService memberService;

    // [1] 내가 쓴 글 전체 조회
    @GetMapping("/info/board/findall")
    // http://localhost:8080/info/board/findall?mno=1
    public List<BoardDto> myBoardList(@RequestParam int mno){
        return memberService.myBoardList(mno);
    }

    // [2] 게시물 작성
    @PostMapping("/info/board/write")
    // http://localhost:8080/info/board/write
    // Body : { "btitle" : "안녕제목11", "bcontent" : "안녕내용11" }
    public boolean myBoardWrite(@RequestBody BoardDto boardDto){
        return memberService.myBoardWrite(boardDto);
    }
}
