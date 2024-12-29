package day52.boardService12mvc.controller;

import day52.boardService12mvc.model.BoardDao;
import day52.boardService12mvc.model.BoardDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController

public class BoardController {
    // 1. 게시물 쓰기 제어 함수
    @PostMapping("/day52/write")
    public boolean write(BoardDto boardDto){
        return BoardDao.getInstance().write(boardDto);
    }

    // 2. 게시물 출력 제어 함수
    @GetMapping("/day52/findAll")
    public ArrayList<BoardDto> findAll(){
        return BoardDao.getInstance().findAll();
    }
}
