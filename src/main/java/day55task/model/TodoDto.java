package day55task.model;

public class TodoDto {
    // 필드
    private int todoNum;
    private String todoContent;
    private boolean todoState;

    // 생성자
    public TodoDto(int todoNum, String todoContent, boolean todoState) {
        this.todoNum = todoNum;
        this.todoContent = todoContent;
        this.todoState = todoState;
    }
    public TodoDto(){}

    // 메서드
    public int getTodoNum() {return todoNum;}
    public void setTodoNum(int todoNum) {this.todoNum = todoNum;}
    public String getTodoContent() {return todoContent;}
    public void setTodoContent(String todoContent) {this.todoContent = todoContent;}
    public boolean isTodoState() {return todoState;}
    public void setTodoState(boolean todoState) {this.todoState = todoState;}

    @Override
    public String toString() {
        return "TodoDao{" +
                "todoNum=" + todoNum +
                ", todoContent='" + todoContent + '\'' +
                ", todoState=" + todoState +
                '}';
    }
}
