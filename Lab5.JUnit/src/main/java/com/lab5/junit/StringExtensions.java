package com.lab5.junit;

public class StringExtensions {

    public static boolean isPalindrome(String input) {
        if (input == null) return false;

        StringBuilder filtered = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                filtered.append(Character.toLowerCase(ch));
            }
        }

        String processed = filtered.toString();
        String reversed = filtered.reverse().toString();

        return processed.equals(reversed);
    }

    public static String capitalizeWords(String input) {
        if (input == null || input.isEmpty()) return input;

        StringBuilder result = new StringBuilder();
        String[] words = input.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String[] parts = word.split("-");

            for (int j = 0; j < parts.length; j++) {
                String part = parts[j];
                if (!part.isEmpty()) {
                    parts[j] = Character.toUpperCase(part.charAt(0)) +
                            (part.length() > 1 ? part.substring(1) : "");
                }
            }

            result.append(String.join("-", parts));

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
