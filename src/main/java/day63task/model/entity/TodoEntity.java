package day63task.model.entity;

import day63task.model.dto.TodoDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "todo")
@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
public class TodoEntity extends BaseTime{
    // 테이블 필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tno;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String todoContent;

    @Column(columnDefinition = "boolean")
    private boolean todoState;

    // Entity --> DTO 변환 메소드
    public TodoDto toDto(){
        return TodoDto.builder()
                .tno(this.tno)
                .todoContent(this.todoContent)
                .todoState(this.todoState)
                .build();
    }
}











