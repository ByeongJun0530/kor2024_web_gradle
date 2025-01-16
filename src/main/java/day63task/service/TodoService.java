package day63task.service;

import day59.model.dto.MemberDto;
import day63task.model.dto.TodoDto;
import day63task.model.entity.TodoEntity;
import day63task.model.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired private TodoRepository todoRepository;

    // 할일 등록
    public boolean todoWrite(TodoDto todoDto){
        TodoEntity todoEntity = todoDto.toEntity();
        TodoEntity saveEntity = todoRepository.save(todoEntity);
        if (saveEntity.getTno() > 0){
            return true;
        }else {
            return false;
        }
    }

    // 할일 전체 조회
    public List<TodoDto> todoPrint(){
        List<TodoEntity> entityList = todoRepository.findAll();
        List<TodoDto> list = new ArrayList<>();
        for (int index = 0; index <= entityList.size()-1; index++){
            TodoEntity entity = entityList.get(index);
            list.add(entity.toDto());
        }
        return list;
    }

    // 할일 상태 수정
    public boolean todoUpdate(TodoDto todoDto){
        TodoEntity todoEntity = todoDto.toEntity();
        TodoEntity saveEntity = todoRepository.save(todoEntity);
        return !saveEntity.isTodoState();
    }

    // 할일 상태 삭제
    public boolean todoDelete(int tno){
        todoRepository.deleteById(tno);
        return true;
    }
}
