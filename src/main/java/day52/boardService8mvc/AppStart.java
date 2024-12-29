package day52.boardService8mvc;

import day52.boardService8mvc.view.BoardView;

public class AppStart {
    public static void main(String[] args) {
        // 싱글톤을 호출하고 싱글톤 내부 함수 호출
        BoardView.getInstance().run();
    }//m end
}//c end
