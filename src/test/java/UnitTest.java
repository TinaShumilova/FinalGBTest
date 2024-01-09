import org.example.MathService;
import org.example.NotFoundAnswerException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UnitTest {
    @ParameterizedTest
    @CsvSource(value = {
            "3, -14, -5, 5, -0.3333333333333333",
            "1, -13, 36, 9, 4",})
    void testDisMoreZero(int a, int b, int c, double x1, double x2) throws NotFoundAnswerException {
        MathService mathService = new MathService();
        String expected = "Answer{first="+x1+", second="+x2+"}";
        assertEquals(expected,String.valueOf(mathService.getAnswer(a,b,c)));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "4, -4, 1, 0.5",
            "4, -12, 9, 1.5"})
    void testDisEqualZero(int a, int b, int c, double x) throws NotFoundAnswerException {
        MathService mathService = new MathService();
        String expected = "Answer{first="+x+", second="+x+"}";
        assertEquals(expected,String.valueOf(mathService.getAnswer(a,b,c)));

    }
    @Test
    void testDisLessZero() {
        MathService mathService = new MathService();
        int a = 1;
        int b = -5;
        int c = 7;
        String actual = "";
        try {
            mathService.getAnswer(a,b,c);
        } catch (NotFoundAnswerException e) {
            actual = e.getMessage();
        }
        String expected = "Корни не могут быть найдены";
        assertEquals(expected,actual);
    }

    @Test
    void testNegative() throws NotFoundAnswerException {
        MathService mathService = new MathService();
        String a = "one";
        int b = -5;
        int c = 7;
        boolean thrown = false;

        try {
            mathService.getAnswer(Integer.parseInt(a), b, c);
        } catch (NumberFormatException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

}

