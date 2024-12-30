package day53;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

// [1] 스프링 서버를 실행하기 위한 클래스
@SpringBootApplication // 톰캣(웹) 서버 세팅해주는 어노테이션
public class AppStart {
    public static void main(String[] args) {
        // 스프링 서버가 실행되면서 톰캣(웹)서버도 같이 실행된다.
        SpringApplication.run(AppStart.class);
    }
}//cls end
// [2] 외부로부터 HTTP 요청을 맵핑(연결) 하기 위한 컨트롤러 클래스
@RestController// 현재 클래스의 HTTP 컨트롤 클래스임을 지정한다.
class day53Controller {
    @PostMapping("/day52")
    public String postMethod(){
        System.err.println("day52Controller.postMethod"); // soutm
        return "server connect POST OK";
    }
    @GetMapping("/day52") // HTTP [GET] http://localhost8080/day52 주소 선언/만들기
    public String getMethod(){
        System.err.println("day52Controller.getMethod"); // soutm
        return "server connect GET OK";
    }
    @PutMapping("/day52")
    public String putMethod(){
        System.err.println("day52Controller.putMethod"); // soutm
        return "server connect PUT OK";
    }

    @DeleteMapping("/day52")
    public String deleteMethod(){
        System.err.println("day52Controller.deleteMethod"); // soutm
        return "server connect DELETE OK";
    }
}














