import java.util.HashMap;
import java.util.Map;

public class Primes {

    public static final Map<Long, Long> getPrimeFactorization(long number) {
        Map<Long, Long> map = new HashMap<>();
        long n = number;
        int c = 0;
        // For each potential factor i
        for (long i = 2; i * i <= n; i++) {
            c = 0;
            // If i is a factor of n, repeatedly divide it out
            while (n % i == 0) {
                n = n / i;
                c++;
            }
            Long p = map.get(i);
            if (p == null)
                p = 0L;
            p += c;
            map.put(i, p);
        }
        if (n > 1) {
            Long p = map.get(n);
            if (p == null)
                p = 0L;
            p += 1;
            map.put(n, p);
        }
        return map;
    }

    public static final boolean isPrime(long number) {
        if (number <= 1)
            return false;
        if (number < 4)
            return true; // 2 and 3 are prime
        if (number % 2 == 0)
            return false; // Short circuit for even numbers
        if (number < 9)
            return true; // Excludes 4, 6, and 8
        if (number % 3 == 0)
            return false; // Short circuit for multiples of 3

        long r = (long) Math.sqrt(number); // n rounded to greatest integer r so that r*r <= n
        int f = 5;
        while (f <= r) {
            if (number % f == 0)
                return false;
            if (number % (f + 2) == 0)
                return false;
            f += 6;
        }
        return true;
    }

    private static boolean[] sieve = null;

    public static final boolean sieveOfEratosthenes(int number) {
        if (number <= 1) {
            return false;
        }
        if (sieve == null || number >= sieve.length) {
            int start = 2;

            if (sieve == null) {
                sieve = new boolean[number + 1];
            } else if (number >= sieve.length) {
                boolean[] newSieve = new boolean[number + 1];
                System.arraycopy(sieve, 0, newSieve, 0, sieve.length);
                sieve = newSieve;
            }

            for (int i = start; i <= Math.sqrt(number); i++) {
                if (!sieve[i]) {
                    for (int j = i * 2; j <= number; j += i) {
                        sieve[j] = true;
                    }
                }
            }
        }
        return !sieve[number];
    }

    public static final boolean millerRabinTest(int number) {
        int[] witnesses = {2, 325, 9375, 28178, 450775, 9780504, 1795265022};

        if (number == 0 || number == 1)
            return false;
        if (number == 2 || number == 3)
            return true;

        int maximumPowerOf2 = 0;
        while (((number - 1) % fastRecursiveExponentiation(2, maximumPowerOf2)) == 0)
            maximumPowerOf2++;
        maximumPowerOf2--;

        int d = (number - 1) / fastRecursiveExponentiation(2, maximumPowerOf2);
        boolean isPrime = true;
        for (int a : witnesses) {
            if (a > number)
                break;
            if (fastRecursiveExponentiationModulo(a, d, number) != 1) {
                boolean isLocalPrime = false;
                for (int r = 0; r < maximumPowerOf2; r++) {
                    if (fastRecursiveExponentiationModulo(a, d * fastRecursiveExponentiation(2, r), number) == (number - 1)) {
                        isLocalPrime = true;
                        break;
                    }
                }
                if (!isLocalPrime) {
                    isPrime = false;
                    break;
                }
            }
        }

        return isPrime;
    }

    private static int fastRecursiveExponentiation(int base, int power) {
        if (power == 0)
            return 1;
        if (power % 2 == 0) {
            int half = fastRecursiveExponentiation(base, power / 2);
            return half * half;
        }
        return base * fastRecursiveExponentiation(base, power - 1);
    }

    private static int fastRecursiveExponentiationModulo(int base, int power, int mod) {
        if (power == 0)
            return 1;
        if (power % 2 == 0) {
            int half = fastRecursiveExponentiationModulo(base, power / 2, mod);
            return (half * half) % mod;
        }
        return (base * fastRecursiveExponentiationModulo(base, power - 1, mod)) % mod;
    }
}
