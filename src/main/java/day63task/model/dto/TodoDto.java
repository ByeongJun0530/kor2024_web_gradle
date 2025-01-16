package day63task.model.dto;

import day63task.model.entity.TodoEntity;
import lombok.*;

@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class TodoDto {
    // 멤버변수
    private int tno;
    private String todoContent;
    private boolean todoState;

    // DTO --> Entity
    public TodoEntity toEntity(){
        return TodoEntity.builder()
                .tno(this.tno)
                .todoContent(this.todoContent)
                .todoState(this.todoState)
                .build();
    }
}
