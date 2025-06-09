package com.lab3.gradle.passwordutils.validator;

public record PasswordZxcvbnValidationResult(
        int zxcvbnScore,
        String zxcvbnWarnings,
        String zxcvbnSuggestions) {

    @Override
    public String toString() {
        String suggestions = zxcvbnSuggestions.isEmpty() ? "None" : zxcvbnSuggestions;

        StringBuilder sb = new StringBuilder();

        sb.append("Zxcvbn Validation Result:\n");
        sb.append("Zxcvbn score (0-4): ").append(zxcvbnScore).append("\n");
        sb.append("Zxcvbn warnings: ").append(zxcvbnWarnings.isEmpty() ? "None" : zxcvbnWarnings).append("\n");
        sb.append("Zxcvbn suggestions: ").append(suggestions).append("\n");

        return sb.toString();
    }
}