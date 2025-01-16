package day58task.model.dao;

import day58task.model.dto.StudentDto;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component // + 객체(빈) 생성해서 메모리(SPRING 컨테이너) 등록
// 이 클래스의 객체(빈)는 너가(Spring) 관리해줘 : IOC
// + 싱글톤 필요 X
public class StudentDao {
    private Connection conn;
    private StudentDao(){
        // DB 연동
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb0107","root", "1234");
        }catch (Exception e){System.out.println(e);}
    }

    ArrayList<StudentDto> scoreDB = new ArrayList<>();

    // 점수 등록
    public boolean scoreWrite(StudentDto studentDto){
        try{
            String sql = "insert into student(stuName, korScore, mathScore, engScore) values (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, studentDto.getStuName());
            ps.setInt(2, studentDto.getKorScore());
            ps.setInt(3, studentDto.getMathScore());
            ps.setInt(4, studentDto.getEngScore());
            int count = ps.executeUpdate();
            if (count == 1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    // 전체 점수 출력
    public ArrayList<StudentDto> scorePrint(){
        try{
            String sql = "select* from student";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                StudentDto studentDto = new StudentDto(
                        rs.getInt("stuNum"), rs.getString("stuName"),
                        rs.getInt("korScore"),rs.getInt("mathScore"),
                        rs.getInt("engScore")
                );
                scoreDB.add(studentDto);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return scoreDB;
    }
    // 개별 점수 수정
    public boolean scoreUpdate(StudentDto studentDto){
        try{
            String sql = "update student set korScore = ?, mathScore = ?, engScore = ? where stuNum = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, studentDto.getKorScore());
            ps.setInt(2, studentDto.getMathScore());
            ps.setInt(3, studentDto.getEngScore());
            ps.setInt(4, studentDto.getStuNum());
            int count = ps.executeUpdate();
            if (count == 1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    // 개별 점수 삭제
    public boolean scoreDelete(int stuNum){
        try{
            String sql = "delete from student where stuNum = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, stuNum);
            int count = ps.executeUpdate();
            if (count == 1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
