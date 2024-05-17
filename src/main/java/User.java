import java.util.Scanner;

public class User {
    // 사용자 고유 ID
    private int userId;
    // 사용자 이름
    private String name;
    // 사용자 나이
    private int age;
    // 사용자 연락처 정보
    private String contactInfo;

    // 생성자
    public User(int userId, String name, int age, String contactInfo) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.contactInfo = contactInfo;
    }

    // 사용자 정보 출력
    public void viewInfo() {
        System.out.println("사용자 ID: " + userId);
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("연락처: " + contactInfo);
    }

    // Getter 및 Setter 메소드
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
