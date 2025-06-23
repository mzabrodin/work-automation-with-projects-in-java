import com.lab6.cicd.Rabbits;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RabbitsTest {
    @ParameterizedTest(name = "months = {0}, rabbits = {1} -> expected result = {2}")
    @DisplayName("Parameterized Test for Rabbits.calculate()")
    @CsvSource({
            "0, 10, 1",
            "5, 10, 12",
            "10, 100, 24",
            "73, 4, 8"
    })
    public void testRabbits(int months, int rabbits, int expected) {
        Assertions.assertEquals(expected, Rabbits.calculate(months, rabbits));
    }
}