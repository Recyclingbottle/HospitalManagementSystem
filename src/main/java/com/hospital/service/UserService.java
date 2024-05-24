package com.hospital.service;

import com.hospital.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<UserDTO> users = new ArrayList<>();

    public void addUser(UserDTO user) {
        users.add(user);
        System.out.println("사용자가 추가되었습니다: " + user.getName());
    }

    public UserDTO findUserByName(String name) {
        for (UserDTO user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    public List<UserDTO> getAllUsers() {
        return users;
    }
}
