package day56;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // 해당 클래스에 어노테이션[ 미리 코드가 담긴 스티커 ] 주입
public class RestController1 {

    @GetMapping("/day56/rest1") // [Get] http://localhost:8080/day56/rest1
    @ResponseBody
    public String getRest1(){
        return "Hi 클라이언트, 나는 Get Rest1";
    } // f end

    @PostMapping("/day56/rest1") // [Post] http://localhost:8080/day56/rest1
    @ResponseBody
    public String postRest1(){
        return "안녕 클라이언트, 나는 Post Rest1";
    } // f end

    @PutMapping("/day56/rest1") // [Put] http://localhost:8080/day56/rest1
    @ResponseBody
    public String putRest1(){
        return "안녕 클라이언트, 나는 Put Rest1";
    }

    @DeleteMapping("/day56/rest1") // [Delete] http://localhost:8080/day56/rest1
    @ResponseBody
    public String deleteRest1(){
        return "안녕 클라이언트, 나는 Delete Rest1";
    }

} // cls end
