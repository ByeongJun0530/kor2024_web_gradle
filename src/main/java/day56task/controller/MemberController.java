package day56task.controller;

import day56task.Dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/day56task/member")
public class MemberController {
    //회원가입
    @PostMapping("")
    public boolean memberRegist(@RequestBody MemberDto memberDto){
        System.out.println("MemberController.memberRegist");
        System.out.println("memberDto = " + memberDto);
        //boolean result  = memberDao.getInstance().memberWrite(memberDto);
        //return result;
        return true;
    }
    //로그인
    @PostMapping("")
    public boolean memberLogin(@RequestBody MemberDto memberDto){
        System.out.println("MemberController.memberLogin");
        System.out.println("memberDto = " + memberDto);
        //boolean result = memberDao.getInstance().memberLogin(memberDto);
        //return result;
        return true;
    }
    //회원수정
    @PutMapping("")
    public boolean memberUpdate(@RequestBody MemberDto memberDto){
        System.out.println("MemberController.memberUpdate");
        System.out.println("memberDto = " + memberDto);
        //boolean result = memberDao.getInstance().memberUpdate(memberDto);
        //return result;
        return true;
    }

    //내정보보기
    @GetMapping("")
    public ArrayList<MemberDto> memberPrint(){
        //ArrayList<MemberDto> result = memberDao.getInstance().memberPrint();
        //return result;
        return null;
    }

    //회원탈퇴
    @DeleteMapping("")
    public boolean memberDelete(@RequestParam int memberNum){
        System.out.println("MemberController.memberDelete");
        System.out.println("memberNum = " + memberNum);
        //boolean result = memberDao.getInstance().memberDelete(memberNum);
        //return result;
        return true;
    }
}
