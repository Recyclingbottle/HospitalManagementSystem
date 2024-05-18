public class User {
    private String name;
    private int age;
    private String contactInfo;

    public User(String name, int age, String contactInfo) {
        this.name = name;
        this.age = age;
        this.contactInfo = contactInfo;
    }

    // 사용자 정보를 출력하는 메소드
    public void viewInfo() {
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("연락처: " + contactInfo);
    }

    // Getter와 Setter 메소드
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
