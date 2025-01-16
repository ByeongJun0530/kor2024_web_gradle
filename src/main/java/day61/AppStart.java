package day61;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AppStart {
    @Autowired
    static BoardRepository boardRepository;
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);

        // (1) BoardEntity 클래스로 인스턴스 생성
            // new BoardEntity(); : ===인스턴스1, 엔티티1개===
        BoardEntity boardEntity1 = new BoardEntity(1, "안녕제목", "안녕내용");

            // new BoardEntity(); : ===인스턴스2, 엔티티1개===
        BoardEntity boardEntity2 = new BoardEntity(2, "안녕제목2", "안녕내용2");

        boardRepository.save(boardEntity1); // .save(엔티티/인스턴스)
        boardRepository.save(boardEntity2);

        List<BoardEntity> list = boardRepository.findAll();
    }
}
