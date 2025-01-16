package day58task.service;

import day58task.model.dao.StudentDao;
import day58task.model.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service // + 객체(빈) 생성해서 메모리(SPRING 컨테이너) 등록
// 이 클래스의 객체(빈)는 너가(Spring) 관리해줘 : IOC
// + 싱글톤 필요 X
public class StudentService {
    // 너가(spring) 만들었던 빈(객체/인스턴스)를 주세요. @AutoWired(DI)
    @Autowired private StudentDao studentDao;

    // 점수 등록
    public boolean scoreWrite(StudentDto studentDto){
        return studentDao.scoreWrite(studentDto);
    }
    // 전체 점수 출력
    public ArrayList<StudentDto> scorePrint(){
        return studentDao.scorePrint();
    }
    // 특정 학생 점수 수정
    public boolean scoreUpdate(StudentDto studentDto){
        return studentDao.scoreUpdate(studentDto);
    }
    // 특정 학생 점수 삭제
    public boolean scoreDelete(int stuNum){
        return studentDao.scoreDelete(stuNum);
    }
}
