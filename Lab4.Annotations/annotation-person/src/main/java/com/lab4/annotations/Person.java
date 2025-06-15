package com.lab4.annotations;

@GenerateBuilder
public class Person {
    private String name;
    private String surname;

    @ValidEmail
    private String email;

    private int age;

    public Person(String name, String surname, String email, int age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;

        try {
            EmailValidation.validate(this);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            throw new InvalidPerson(e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person:\n" +
                "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Email: " + email + "\n" +
                "Age: " + age + "\n";
    }
}