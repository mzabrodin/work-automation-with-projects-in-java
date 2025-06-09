package com.lab3.gradle.passwordutils.hasher;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashingService {
    public static String hashPassword(String password, int salt) {
        return BCrypt.hashpw(password, BCrypt.gensalt(salt));
    }

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }
}