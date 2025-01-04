package day54.boardService13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 ================ 콘솔 ================= //
public class AppStart {
    public static void main(String[] args) {
        BoardView.getInstance.BoardView();
    }
}
*/

// ================ 웹 ================= //
@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}
