package day55task.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TodoDao {
    private Connection conn;
    // + 싱글톤
    private static TodoDao todoDao = new TodoDao();
    private TodoDao(){
        //db연동
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/day55task","root","1234"
            );
        }catch (Exception e){System.out.println(e.getMessage());}
    }
    public static TodoDao getInstance(){
        return todoDao;
    }

    ArrayList<TodoDto> todoDB = new ArrayList<>();

    // 게시물 등록 함수
    public boolean todoWrite(TodoDto todoDto){
        try{
            String sql = "insert into todoList(todoContent, todoState) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, todoDto.getTodoContent());
            ps.setBoolean(2, todoDto.isTodoState());
            int count = ps.executeUpdate();
            if (count == 1){return true;}
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    // 게시물 출력 함수
    public ArrayList<TodoDto> todoPrint(){
        try{
            String sql = "select* from todoList";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                TodoDto todoDto = new TodoDto(
                        rs.getInt("todoNum"),
                        rs.getString("todoContent"),
                        rs.getBoolean("todoState")
                );
                todoDB.add(todoDto);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return todoDB;
    }

    // 게시물 수정 함수
    public boolean todoUpdate(TodoDto todoDto){
        try{
            String sql = "update todoList set todoContent = ?, todoState = ? where todoNum = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, todoDto.getTodoContent());
            ps.setBoolean(2, todoDto.isTodoState());
            ps.setInt(3, todoDto.getTodoNum());
            int count = ps.executeUpdate();
            if (count == 1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    // 게시물 삭제 함수
    public boolean todoDelete(int todoNum){
        try {
            String sql = "delete* from todoList where todoNum = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, todoNum);
            int count = ps.executeUpdate();
            if (count == 1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}// c end
