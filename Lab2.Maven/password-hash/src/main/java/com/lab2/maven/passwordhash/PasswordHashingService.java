package com.lab2.maven.passwordhash;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashingService {

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }
}
