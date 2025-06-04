package com.lab2.maven.passwordvalidation;

import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import org.passay.*;

import java.util.List;

public class PasswordValidatorService {

    public record PasswordCheckResult(
            boolean isPassayValid,
            List<String> passayMessages,
            int zxcvbnScore,
            String zxcvbnWarnings,
            String zxcvbnSuggestions) {

        @Override
        public String toString() {
            String messages = passayMessages.isEmpty() ? "None" : String.join(", ", passayMessages);
            String suggestions = zxcvbnSuggestions.isEmpty() ? "None" : zxcvbnSuggestions;

            StringBuilder sb = new StringBuilder();
            sb.append("Password Validation Result:\n");
            sb.append("Passay validation passed: ").append(isPassayValid ? "Yes" : "No").append("\n");
            sb.append("Passay messages: ").append(messages).append("\n\n");

            sb.append("Zxcvbn Validation Result:\n");
            sb.append("Zxcvbn score (0-4): ").append(zxcvbnScore).append("\n");
            sb.append("Zxcvbn warnings: ").append(zxcvbnWarnings.isEmpty() ? "None" : zxcvbnWarnings).append("\n");
            sb.append("Zxcvbn suggestions: ").append(suggestions).append("\n");


            return sb.toString();
        }
    }

    public static PasswordCheckResult validate(String password) {
        PasswordValidator passayValidator = new PasswordValidator(List.of(
                new LengthRule(8, 128),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.Special, 1)
        ));

        RuleResult passayResult = passayValidator.validate(new PasswordData(password));
        boolean isPassayValid = passayResult.isValid();

        List<String> passayMessages = passayValidator.getMessages(passayResult);

        Zxcvbn zxcvbn = new Zxcvbn();
        Strength strength = zxcvbn.measure(password);

        int score = strength.getScore();
        String warnings = strength.getFeedback().getWarning();
        String suggestions = String.join(", ", strength.getFeedback().getSuggestions());

        return new PasswordCheckResult(isPassayValid, passayMessages, score, warnings, suggestions);
    }

}
