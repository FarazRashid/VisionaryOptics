package com.example.demo.password;

public class BasicPasswordHashingStrategy implements PasswordHashingStrategy{
    @Override
    public String hashPassword(String password, String salt) {
        String generatedSalt = (salt != null) ? salt : BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);

    }

    public boolean checkPassword(String enteredPassword, String storedHashedPassword) {
        return BCrypt.checkpw(enteredPassword, storedHashedPassword);
    }
}
