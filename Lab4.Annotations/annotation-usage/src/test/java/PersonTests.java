import com.lab4.annotations.InvalidPerson;
import com.lab4.annotations.Person;
import com.lab4.annotations.PersonBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTests {

    @Test
    void validEmailPerson() {
        Person person = new Person(
                "Maksym",
                "Zabrodin",
                "m.d.zabrodin@ukma.edu.ua",
                19
        );

        String expectedName = "Maksym";
        String expectedSurname = "Zabrodin";
        String expectedEmail = "m.d.zabrodin@ukma.edu.ua";
        int expectedAge = 19;

        String actualName = person.getName();
        String actualSurname = person.getSurname();
        String actualEmail = person.getEmail();
        int actualAge = person.getAge();

        assertEquals(expectedName, actualName);
        assertEquals(expectedSurname, actualSurname);
        assertEquals(expectedEmail, actualEmail);
        assertEquals(expectedAge, actualAge);
    }

    @Test
    void invalidEmailPerson() {
        assertThrows(InvalidPerson.class, () -> {
            new Person(
                    "Maksym",
                    "Zabrodin",
                    "invalid-email",
                    19
            );
        });
    }

    @Test
    void validBuiltPerson() {
        Person person = new PersonBuilder()
                .name("Maksym")
                .surname("Zabrodin")
                .email("m.d.zabrodin@ukma.edu.ua")
                .age(19)
                .build();

        String expectedName = "Maksym";
        String expectedSurname = "Zabrodin";
        String expectedEmail = "m.d.zabrodin@ukma.edu.ua";
        int expectedAge = 19;

        String actualName = person.getName();
        String actualSurname = person.getSurname();
        String actualEmail = person.getEmail();
        int actualAge = person.getAge();

        assertEquals(expectedName, actualName);
        assertEquals(expectedSurname, actualSurname);
        assertEquals(expectedEmail, actualEmail);
        assertEquals(expectedAge, actualAge);
    }

    @Test
    void invalidBuiltPerson() {
        assertThrows(InvalidPerson.class, () -> {
            new PersonBuilder()
                    .name("Maksym")
                    .surname("Zabrodin")
                    .email("invalid-email")
                    .age(19)
                    .build();
        });
    }
}
