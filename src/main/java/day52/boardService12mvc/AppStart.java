package day52.boardService12mvc;

import day52.boardService8mvc.view.BoardView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication

public class AppStart {
    public static void main(String[] args) {
        // 싱글톤을 호출하고 싱글톤 내부 함수 호출
        //BoardView.getInstance().run();
        // * 콘솔 뷰가 아닌 스플힝 실행 코드 작성
        SpringApplication.run(AppStart.class);
    }//m end
}//c end
