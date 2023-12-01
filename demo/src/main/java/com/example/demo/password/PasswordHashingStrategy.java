package com.example.demo.password;

public interface PasswordHashingStrategy {
    String hashPassword(String password, String salt);
    boolean checkPassword(String enteredPassword, String storedHashedPassword);

}
