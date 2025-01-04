package day54.boardService13.model.dao;

import day54.boardService13.model.dto.BoardDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDao {
    private Connection conn; // 연동 인터페이스
    // + 싱글톤
    private static BoardDao instance = new BoardDao();
    private BoardDao(){
        // ========== DB 연동 =========== //
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb0102","root", "1234");
        }catch (Exception e){System.out.println(e);}
    }
    public static BoardDao getInstance(){return instance;}
    // 1. 게시물 쓰기 제어 함수
    public boolean write(BoardDto boardDto){
        try {
            String sql = "insert into board(btitle, bcontent, bwriter, bpwd) values(?, ?, ?, ?)"; // 1.SQL 작성
            PreparedStatement ps = conn.prepareStatement(sql); // 2. 작성한 SQL 기재하기
            ps.setString(1, boardDto.getBtitle());      // 3. 기재된 SQL의 첫번째 ? 매개변수에 값 대입.
            ps.setString(2, boardDto.getBcontent());    // 3. 기재된 SQL의 두번째 ? 매개변수에 값 대입.
            ps.setString(3, boardDto.getBwriter());     // 3. 기재된 SQL의 세번째 ? 매개변수에 값 대입.
            ps.setString(4, boardDto.getBpwd());        // 3. 기재된 SQL의 네번째 ? 매개변수에 값 대입.
            int count = ps.executeUpdate();             // 4. SQL 실행 => 실행된 결과 레코드 수 반환
            if (count == 1){return true;}               // 5. 삽입된 결과 레코드가 1개이면 등록 성공 true
        }catch (Exception e){ System.out.println(e.getMessage());}
        return false; // 5. 등록실패 false
    }
    // 2. 게시물 전체 조회 제어 함수
    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> list = new ArrayList<>();
        try {
            String sql = "select* from board"; // 1. sql 작성
            PreparedStatement ps = conn.prepareStatement(sql); // 2. sql 기재
            ResultSet rs = ps.executeQuery(); // 3. sql 실행하고 결과를 조작하는 ResultSet 인터페이스로 받는다.
            // 4. 조회 결과의 레코드 하나씩 조회하기 .next() : 다음 레코드로 이동
            while (rs.next()){
                // 5. 레코드를 DTO로 만들기
                BoardDto boardDto = new BoardDto(
                        // *현재 조회중인 레코드의 특정 필드명의 값 반환. rs.get타입("필드명")
                        rs.getInt("bno"), rs.getString("btitle"),
                        rs.getString("bcontent"), rs.getString("bdate"),
                        rs.getString("bwriter"), null // 패스워드는 보안상 조회시 제외
                );
                // 6. 만든 DTO에 ArrayList에 대입.
                list.add(boardDto);
            }// w end
        }catch (Exception e){System.out.println(e.getMessage());}
        return list; // 7.리스트 반환
    }

    // 3. 게시물 개별 조회 제어 함수
    public BoardDto findid(int bno){
        try {
            // (1) sql 작성
            String sql = "select* from board where bno = ?";
            // (2) sql 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // (3) 기재된 sql에 매개변수 대입
            ps.setInt(1, bno);
            // (4) 기재된 sql을 실행하고 결과를 반환받는다.
            ResultSet rs = ps.executeQuery();
            if (rs.next()){ // (5) 실행 결과에 따른 제어
                BoardDto boardDto = new BoardDto(
                  rs.getInt("bno"), rs.getString("btitle"),
                  rs.getString("bcontent"), rs.getString("bdate"),
                  rs.getString("bwriter"), null
                );
                return boardDto;
            }
        }catch (Exception e){System.out.println(e.getMessage());}
        return null;
    } // f end

    // 4. 게시물 수정 제어 함수
    public boolean update(BoardDto boardDto){
        try {
            String sql = "update board set btitle = ?, bcontent = ? where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBtitle());
            ps.setString(2, boardDto.getBcontent());
            ps.setInt(3, boardDto.getBno());
            int count = ps.executeUpdate();
            if (count == 1) {
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }// f end

    // 5. 게시물 삭제 제어 함수
    public boolean delete(int bno){
        try {
            //(1) sql 작성
            String sql = "delete from board where bno = ?";
            //(2) sql 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            //(3) 기재된 sql의 매개변수 대입
            ps.setInt(1, bno);
            //(4) 기재된 sql실행하고 결과를 반환받는다
            int count = ps.executeUpdate();
            //(5) 실행결과에 따른 제어한다.
            if (count == 1){return true;}
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }// f end

}
