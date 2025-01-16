package day61Task.controller;

import day61Task.model.entity.MemberEntity;
import day61Task.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    @Autowired // 스프링 컨테이너에 등록된 빈(객체)를 가져온다
    private MemberService memberService;

    @PostMapping("/signup")
    public boolean signup(@RequestParam String id, @RequestParam String pwd){
        boolean result = memberService.signup(id, pwd);
        return result;
    }

    @GetMapping("/findAll")
    public List<MemberEntity> finaAll(){
        List<MemberEntity> result = memberService.findAll();
        return result;
    }
}
