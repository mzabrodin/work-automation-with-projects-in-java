package com.lab3.gradle.passwordutils.validator;

import java.util.List;

public record PasswordPassayValidationResult(
        boolean isPassayValid,
        List<String> passayMessages) {

    @Override
    public String toString() {
        String messages = passayMessages.isEmpty() ? "None" : String.join(", ", passayMessages);

        StringBuilder sb = new StringBuilder();

        sb.append("Passay Validation Result:\n");
        sb.append("Passay validation passed: ").append(isPassayValid ? "Yes" : "No").append("\n");
        sb.append("Passay messages: ").append(messages).append("\n\n");

        return sb.toString();
    }
}