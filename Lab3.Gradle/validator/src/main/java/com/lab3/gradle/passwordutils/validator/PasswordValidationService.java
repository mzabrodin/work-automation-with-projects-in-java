package com.lab3.gradle.passwordutils.validator;

import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import org.passay.*;

import java.util.List;

public class PasswordValidationService {
    public static PasswordPassayValidationResult passayValidate(String password) {
        PasswordValidator passayValidator = new PasswordValidator(List.of(
                new LengthRule(8, 128),
                new WhitespaceRule(),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.Special, 1)
        ));

        RuleResult passayResult = passayValidator.validate(new PasswordData(password));
        boolean isPassayValid = passayResult.isValid();

        List<String> passayMessages = passayValidator.getMessages(passayResult);

        return new PasswordPassayValidationResult(isPassayValid, passayMessages);
    }

    public static PasswordZxcvbnValidationResult zxcvbnValidate(String password) {
        Zxcvbn zxcvbn = new Zxcvbn();
        Strength strength = zxcvbn.measure(password);

        int score = strength.getScore();
        String warnings = strength.getFeedback().getWarning();
        String suggestions = String.join(", ", strength.getFeedback().getSuggestions());

        return new PasswordZxcvbnValidationResult(score, warnings, suggestions);
    }
}