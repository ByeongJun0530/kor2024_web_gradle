package day56task.Dto;

public class MemberDto {
    //멤버변수
    private int MemberNum;
    private String id;
    private String pwd;
    private String name;
    private String phone;
    //생성자
    public MemberDto(){};

    public MemberDto(int memberNum, String id, String pwd, String name, String phone) {
        MemberNum = memberNum;
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.phone = phone;
    }

    //메서드
    public int getMemberNum() {return MemberNum;}
    public void setMemberNum(int memberNum) {MemberNum = memberNum;}
    public String getId() { return id;}
    public void setId(String id) { this.id = id;}
    public String getPwd() { return pwd;}
    public void setPwd(String pwd) { this.pwd = pwd;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name; }
    public String getPhone() {return phone;}
    public void setPhone(String phone) { this.phone = phone;}

    //toString
    @Override
    public String toString() {
        return "MemberDto{" +
                "MemberNum=" + MemberNum +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
