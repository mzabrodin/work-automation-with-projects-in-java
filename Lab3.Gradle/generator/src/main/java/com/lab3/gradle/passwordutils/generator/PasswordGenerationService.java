package com.lab3.gradle.passwordutils.generator;

import com.lab3.gradle.passwordutils.validator.PasswordPassayValidationResult;
import com.lab3.gradle.passwordutils.validator.PasswordValidationService;
import com.lab3.gradle.passwordutils.validator.PasswordZxcvbnValidationResult;
import org.passay.*;

import java.util.List;

public class PasswordGenerationService {
    public static String generatePassword(int length) {
        if (length < 8) {
            throw new IllegalArgumentException("Length must be at least 8");
        }

        PasswordGenerator passwordGenerator = new PasswordGenerator();

        List<CharacterRule> rules = List.of(
                new CharacterRule(EnglishCharacterData.LowerCase, 2),
                new CharacterRule(EnglishCharacterData.UpperCase, 2),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.Special, 1)
        );


        final int attempts = 10;
        for (int i = 0; i < attempts; i++) {
            String password = passwordGenerator.generatePassword(length, rules);
            PasswordPassayValidationResult passayResult = PasswordValidationService.passayValidate(password);
            PasswordZxcvbnValidationResult zxcvbnResult = PasswordValidationService.zxcvbnValidate(password);

            if ((passayResult.isPassayValid()) && (zxcvbnResult.zxcvbnScore() >= 3)) {
                return password;
            }
        }

        throw new IllegalArgumentException("Password generation failed after " + attempts + " attempts");
    }

    public static String generatePassword() {
        return generatePassword(12);
    }
}
