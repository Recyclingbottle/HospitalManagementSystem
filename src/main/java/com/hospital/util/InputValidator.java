package com.hospital.util;

public class InputValidator {

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // 간단한 전화번호 유효성 검사
        return phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}");
    }

    public static boolean isValidName(String name) {
        // 간단한 이름 유효성 검사
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidAge(int age) {
        // 간단한 나이 유효성 검사
        return age > 0 && age < 120;
    }
}
