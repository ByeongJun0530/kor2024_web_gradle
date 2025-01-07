package day57task.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class StudentDto {
    // 필드
    private int stuNum;
    private String stuName;
    private int korScore;
    private int mathScore;
    private int engScore;
}
