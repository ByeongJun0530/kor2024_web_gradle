package day63task.controller;

import day63task.model.dto.TodoDto;
import day63task.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    // 할일 등록
    @PostMapping("/todoWrite")
    public boolean todoWrite(@RequestBody TodoDto todoDto){
        return todoService.todoWrite(todoDto);
    }

    // 할일 전체 조회
    @GetMapping("/todoPrint")
    public List<TodoDto> todoPrint(){
        return todoService.todoPrint();
    }

    // 할일 수정
    @PutMapping("/todoUpdate")
    public boolean todoUpdate(@RequestBody TodoDto todoDto){
        return todoService.todoUpdate(todoDto);
    }

    // 할일 삭제
    @DeleteMapping("/todoDelete")
    public boolean todoDelete(@RequestParam int tno){
        return todoService.todoDelete(tno);
    }
}

