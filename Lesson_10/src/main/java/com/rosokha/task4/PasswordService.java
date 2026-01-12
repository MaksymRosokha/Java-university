package com.rosokha.task4;

public class PasswordService {
    public boolean isStrong(String password) {
        class Rules {
            public boolean checkAll() {
                if (password == null) {
                    return false;
                }
                return password.length() >= 8
                        && password.matches(".*[A-Z].*")
                        && password.matches(".*[0-9].*")
                        && password.matches(".*[!@#$%^&*].*");
            }
        }

        return new Rules().checkAll();
    }
}
