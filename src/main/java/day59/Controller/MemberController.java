package day59.Controller;

import day59.Service.MemberService;
import day59.model.dao.MemberDao;
import day59.model.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //스프링 컨테이너(메모리)에 빈(인스턴스) 주입
public class MemberController {
    // + 객체(값) 반환하는 메소드들을 모아둔 클래스 + @ResponseBody
    // 스프링 컨테이너 메모리에 존재하는 빈(인스턴스) 호출
    @Autowired private MemberService memberService;

    // [1] 회원가입 컨트롤러 : http://localhost:8080/signup.do
    // [POST] body
    @PostMapping("/signup.do")
    public boolean signup(@RequestBody MemberDto memberDto){
        boolean result = memberService.signup(memberDto);
        return result;
    }

    // [2] 로그인 컨트롤러 : http://localhost:8080/login.do
    // [GET] query : http://localhost:8080/login.do?mid=asd&mpwd=1234
    @GetMapping("/login.do")
    public boolean login(@RequestParam String mid, @RequestParam String mpwd){
        boolean result = memberService.login(mid, mpwd);
        return result;
    }
}
