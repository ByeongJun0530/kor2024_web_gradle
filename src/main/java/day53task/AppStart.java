package day53task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

// [1] 스프링 서버 실행 클래스
@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}// cls end

// [2] 외부 HTTP 요청 맵핑을 위한 컨트롤러 클래스
@RestController
class day53taskController{
    // POST
    @PostMapping("/day53task")
    public String postMethod(){
        System.out.println("day53taskController.postMethod");
        return "POST 메서드 통신 성공!";
    }
    // GET
    @GetMapping("/day53task")
    public String getMethod(){
        System.out.println("day53taskController.getMethod");
        return "GET 메서드 통신 성공!";
    }
    // PUT
    @PutMapping("/day53task")
    public String putMethod(){
        System.out.println("day53taskController.putMethod");
        return "PUT 메서드 통신 성공!";
    }
    // DELETE
    @DeleteMapping("/day53task")
    public String deleteMethod(){
        System.out.println("day53taskController.deleteMethod");
        return "DELETE 메서드 통신 성공!";
    }
}// cls end
