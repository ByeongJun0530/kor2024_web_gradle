package day52.boardService8mvc.controller;

import day52.boardService8mvc.model.BoardDao;
import day52.boardService8mvc.model.BoardDto;

import java.util.ArrayList;

public class BoardController {
    // +싱글톤 3단계
    private static BoardController boardController = new BoardController();
    private BoardController(){}
    public static BoardController getInstance(){return boardController;}

    // 1. 게시물 쓰기 제어 함수
    public boolean write(BoardDto boardDto){
        return BoardDao.getInstance().write(boardDto);
    }

    // 2. 게시물 출력 제어 함수
    public ArrayList<BoardDto> findAll(){
        return BoardDao.getInstance().findAll();
    }
}
