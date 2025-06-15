package com.lab4.annotations;

import org.apache.commons.validator.routines.EmailValidator;

import java.lang.reflect.Field;

public class EmailValidation {

    private static final EmailValidator EMAIL_VALIDATOR = EmailValidator.getInstance();

    public static void validate(Object object) throws IllegalArgumentException, IllegalAccessException {
        Class<?> clazz = object.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(ValidEmail.class)) {
                Object value = field.get(object);
                if (value instanceof String email) {
                    if (email.isEmpty() || !EMAIL_VALIDATOR.isValid(email)) {
                        ValidEmail validEmail = field.getAnnotation(ValidEmail.class);
                        throw new IllegalArgumentException("Field " + field.getName() + " is not valid: " + validEmail.message());
                    }
                }
            }
        }
    }
}