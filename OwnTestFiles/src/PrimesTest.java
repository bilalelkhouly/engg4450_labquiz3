import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PrimesTest {

    @Test
    void getPrimeFactorization() {
        Map<Long, Long> factors1 = Primes.getPrimeFactorization(28);
        assertEquals(2, factors1.size());
        assertEquals(2, factors1.get(2L));
        assertEquals(1, factors1.get(7L));

        Map<Long, Long> factors2 = Primes.getPrimeFactorization(1);
        assertTrue(factors2.isEmpty()); // No prime factors for 1

    }

    @Test
    void isPrime() {
        assertTrue(Primes.isPrime(2)); // 2 is prime
        assertTrue(Primes.isPrime(3)); // 3 is prime
        assertFalse(Primes.isPrime(4)); // 4 is not prime
        assertTrue(Primes.isPrime(5)); // 5 is prime
        assertFalse(Primes.isPrime(9)); // 9 is not prime (3 * 3)
        assertTrue(Primes.isPrime(97)); // 97 is prime
        assertFalse(Primes.isPrime(1)); // Logical error: 1 is not prime
        assertFalse(Primes.isPrime(0)); // 0 is not prime
        assertFalse(Primes.isPrime(-7)); // Negative numbers are not prime
    }

    @Test
    void sieveOfEratosthenes() {
        assertTrue(Primes.sieveOfEratosthenes(2)); // 2 is prime
        assertTrue(Primes.sieveOfEratosthenes(3)); // 3 is prime
        assertFalse(Primes.sieveOfEratosthenes(4)); // 4 is not prime
        assertTrue(Primes.sieveOfEratosthenes(5)); // 5 is prime
        assertFalse(Primes.sieveOfEratosthenes(9)); // 9 is not prime
        assertTrue(Primes.sieveOfEratosthenes(97)); // 97 is prime
        assertFalse(Primes.sieveOfEratosthenes(1)); // 1 is not prime
        assertFalse(Primes.sieveOfEratosthenes(0)); // 0 is not prime
    }

    @Test
    void millerRabinTest() {
        assertTrue(Primes.millerRabinTest(2)); // 2 is prime
        assertTrue(Primes.millerRabinTest(3)); // 3 is prime
        assertFalse(Primes.millerRabinTest(4)); // 4 is not prime
        assertTrue(Primes.millerRabinTest(5)); // 5 is prime
        assertFalse(Primes.millerRabinTest(9)); // 9 is not prime
        assertTrue(Primes.millerRabinTest(97)); // 97 is prime
        assertFalse(Primes.millerRabinTest(1)); // 1 is not prime
        assertFalse(Primes.millerRabinTest(0)); // 0 is not prime
    }
}
