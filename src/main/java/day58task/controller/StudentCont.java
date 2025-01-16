package day58task.controller;

import day58task.model.dto.StudentDto;
import day58task.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController // + 객체(빈) 생성해서 메모리(SPRING 컨테이너) 등록
// 이 클래스의 객체(빈)는 너가(Spring) 관리해줘 : IOC
// + 싱글톤 필요 X
public class StudentCont {
    // 너(Spring)가 만든 클래스의 객체/인스턴스 를 주세요.
    @Autowired private StudentService studentService;

    // 점수 등록
    @PostMapping("/scoreWrite")
    public boolean scoreWrite(@RequestBody StudentDto studentDto){
        System.out.println("StudentCont.scoreWrite");
        System.out.println("studentDto = " + studentDto);
        boolean result = studentService.scoreWrite(studentDto);
        return result;
    }
    // 전체 점수 출력
    @GetMapping("/scorePrint")
    public ArrayList<StudentDto> scorePrint(){
        ArrayList<StudentDto> result = studentService.scorePrint();
        return result;
    }
    // 특정 학생 점수 수정
    @PutMapping("/scoreUpdate")
    public boolean scoreUpdate(@RequestBody StudentDto studentDto){
        System.out.println("StudentCont.scoreUpdate");
        System.out.println("studentDto = " + studentDto);
        boolean result = studentService.scoreUpdate(studentDto);
        return result;
    }
    // 특정 학생 점수  삭제
    @DeleteMapping("/scoreDelete")
    public boolean scoreDelete(@RequestParam int stuNum){
        System.out.println("StudentCont.scoreDelete");
        System.out.println("StuNum = " + stuNum);
        boolean result = studentService.scoreDelete(stuNum);
        return result;
    }
}
