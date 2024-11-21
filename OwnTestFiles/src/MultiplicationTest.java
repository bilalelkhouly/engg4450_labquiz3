import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {

    @Test
    void multiplication() {
        assertEquals(20, Multiplication.multiplication(4, 5));
        assertEquals(-20, Multiplication.multiplication(-4, 5));
        assertEquals(0, Multiplication.multiplication(0, 5));
    }

    @Test
    void multiplyUsingLoop() {
        assertEquals(20, Multiplication.multiplyUsingLoop(4, 5));
        assertEquals(-20, Multiplication.multiplyUsingLoop(-4, 5));
        assertEquals(0, Multiplication.multiplyUsingLoop(0, 5));
    }

    @Test
    void multiplyUsingRecursion() {
        assertEquals(20, Multiplication.multiplyUsingRecursion(4, 5));
        assertEquals(-20, Multiplication.multiplyUsingRecursion(-4, 5));
        assertEquals(0, Multiplication.multiplyUsingRecursion(0, 5));
    }

    @Test
    void multiplyUsingShift() {
        assertEquals(20, Multiplication.multiplyUsingShift(4, 5));
        assertEquals(-20, Multiplication.multiplyUsingShift(-4, 5));
        assertEquals(0, Multiplication.multiplyUsingShift(0, 5));
    }

    @Test
    void multiplyUsingLogs() {
        assertEquals(20, Multiplication.multiplyUsingLogs(4, 5));
        assertEquals(-20, Multiplication.multiplyUsingLogs(-4, 5));
        assertEquals(0, Multiplication.multiplyUsingLogs(0, 5)); // Likely inaccurate for logs
    }

    @Test
    void multiplyUsingFFT() {
        assertEquals("20", Multiplication.multiplyUsingFFT("4", "5"));
        assertEquals("-20", Multiplication.multiplyUsingFFT("-4", "5"));
        assertEquals("0", Multiplication.multiplyUsingFFT("0", "5"));
        assertEquals("56088", Multiplication.multiplyUsingFFT("123", "456"));
    }

    @Test
    void multiplyUsingLoopWithStringInput() {
        assertEquals("20", Multiplication.multiplyUsingLoopWithStringInput("4", "5"));
        assertEquals("-20", Multiplication.multiplyUsingLoopWithStringInput("-4", "5"));
        assertEquals("0", Multiplication.multiplyUsingLoopWithStringInput("0", "5"));
        assertEquals("56088", Multiplication.multiplyUsingLoopWithStringInput("123", "456"));
    }

    @Test
    void multiplyUsingLoopWithIntegerInput() {
        assertEquals(20, Multiplication.multiplyUsingLoopWithIntegerInput(4, 5));
        assertEquals(-20, Multiplication.multiplyUsingLoopWithIntegerInput(-4, 5));
        assertEquals(0, Multiplication.multiplyUsingLoopWithIntegerInput(0, 5));
    }
}
