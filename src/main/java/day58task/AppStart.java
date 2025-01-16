package day58task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication // * MVC 관련 컴포넌트(클래스)들을 스캔해서 등록 처리한다.
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}

@Controller
class viewController{
    @GetMapping("") // 템플릿 파일 반환하는 HTTP URL 정의
    public String index(){
        return "/day58/index.html"; // index.html 템플릿 파일 반환
    }
    @GetMapping("/layout")// 매핑/연결 할 HTTP URL 정의
    public String index2(){
        return "/day58/layout/index.html"; // index.html 템플릿 파일 반환
    }
    // [1] student 메인 페이지를 매핑/연결 하는 URL 주소 정의/만들기
    @GetMapping("/student")
    public String index3(){
        return "/day58/student/index.html"; // index.html 템플릿 파일 반환
    }
    // [2] student 학생점수 등록 페이지를 매핑/연결 하는 URL 주소 정의/만들기
    @GetMapping("/student/regist")
    public String regist(){
        return "/day58/student/regist.html";
    }
    // [3] student  전체 학생 점수 조회 페이지
    @GetMapping("/student/list")
    public String list(){
        return "/day58/student/list.html";
    }
    // [4] student 개별 학생 점수 조회 페이지
    @GetMapping("/student/info")
    public String info(){
        return "/day58/student/info.html";
    }
    // [5] student 점수 수정 페이지
    @GetMapping("/student/update")
    public String update(){
        return "/day58/student/update.html";
    }
    // [6] student 점수 삭제 페이지
    @GetMapping("/student/delete")
    public String delete(){
        return "/day58/student/delete.html";
    }
}