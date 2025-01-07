package day57.webProject;

public class Lombok {
    public static void main(String[] args) {

        // 1. 디폴트 생성자로 MemberDto 객체 생성,
            // @NoArgsConstructor 어노테이션이 디폴트 생성자를 주입/만들어준다.
        MemberDto m1 = new MemberDto();

        // 2. 모든 매개변수 생성자로 객체 생성
            // @AllArgsConstructor 어노테이션이 모든 매개변수 생성자를 주입
        MemberDto m2 = new MemberDto("qwe1", "유재석");

        // + 매개변수 1개로 구성된 생성자가 없으므로 오류
        // MemberDto m3 = new MemberDto("qwe1");
            MemberDto m3 = MemberDto.builder()
                    .id("qwe2")
                    .name("강호동")
                    .build();

        // 3. setter 메소드 사용
            // @Setter 어노테이션이 멤버변수 Setter 메소드 주입
        m1.setId("asd1");

        // 4. getter 메소드 사용
            // @Getter 어노테이션이 멤버변수의 Getter 메소드 주입
        System.out.println(m1.getId());

        // 5. toString  메소드 사용
            // @ToString 어노테이션이 멤버변수의 값들을 반환하는 toString() 메소드 주입
        System.out.println(m2.toString());
        System.out.println(m2); // 객체 참조(주소)값 대신 멤버변수 값 호출하고 싶을 때 toString()

    }
}
