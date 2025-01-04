package day55task.Controller;

import day55task.model.TodoDao;
import day55task.model.TodoDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TodoController {
    // + 싱글톤
    private static TodoController todoController = new TodoController();
    private TodoController(){}
    public static TodoController getInstance(){return todoController;}

    // 게시물 등록 함수
    @PostMapping("/todoWrite")
    public boolean todoWrite(@RequestBody TodoDto todoDto){
        System.out.println("TodoController.todoWrite");
        System.out.println("todoDto = " + todoDto);
        boolean result = TodoDao.getInstance().todoWrite(todoDto);
        return result;
    }
    // 게시물 출력 함수
    @GetMapping("/todoPrint")
    public ArrayList<TodoDto> todoPrint(){
        ArrayList<TodoDto> result = TodoDao.getInstance().todoPrint();
        return result;
    }
    // 게시물 수정 함수
    @PutMapping("/todoUpdate")
    public boolean todoUpdate(@RequestBody TodoDto todoDto){
        System.out.println("TodoController.todoUpdate");
        System.out.println("todoDto = " + todoDto);
        boolean result = TodoDao.getInstance().todoUpdate(todoDto);
        return result;
    }

    // 게시물 삭제 함수
    @DeleteMapping("/todoDelete")
    public boolean todoDelete(@RequestParam int todoNum){
        System.out.println("TodoController.todoDelete");
        System.out.println("todoNum = " + todoNum);
        boolean result = TodoDao.getInstance().todoDelete(todoNum);
        return result;
    }
}
