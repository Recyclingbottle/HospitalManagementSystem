package com.hospital.service;

import com.hospital.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<UserDTO> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    public void addUser(String name, int age, String contactInfo) {
        UserDTO user = new UserDTO(name, age, contactInfo);
        users.add(user);
        System.out.println("사용자가 추가되었습니다.");
    }

    public void viewUserInfo(String name) {
        UserDTO user = findUserByName(name);
        if (user != null) {
            System.out.println("이름: " + user.getName());
            System.out.println("나이: " + user.getAge());
            System.out.println("연락처: " + user.getContactInfo());
        } else {
            System.out.println("해당 이름의 사용자가 없습니다.");
        }
    }

    public UserDTO findUserByName(String name) {
        for (UserDTO user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }
}
