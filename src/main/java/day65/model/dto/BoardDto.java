package day65.model.dto;

import day65.model.entity.BoardEntity;
import lombok.*;

@Getter@Setter@ToString@Builder
@NoArgsConstructor@AllArgsConstructor
public class BoardDto {
    private int bno;
    private String btitle;
    private String bcontent;

    // DTO --> entity
    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .btitle(this.btitle)
                .bcontent(this.bcontent)
                .bno(this.bno)
                .build();
    }
}
