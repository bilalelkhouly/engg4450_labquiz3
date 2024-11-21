public class Multiplication {

    public static final long multiplication(int a, int b) {
        long result = ((long) a) * ((long) b);
        return (a == 0 || b == 0) ? 0 : result;
    }

    public static final long multiplyUsingLoop(int a, int b) {
        int absB = Math.abs(b);
        long result = a;
        for (int i = 1; i < absB; i++) {
            result += a;
        }
        return (b < 0) ? -result : result;
    }

    public static final long multiplyUsingRecursion(int a, int b) {
        int absB = Math.abs(b);
        long result = a;
        if (absB == 1)
            return result;

        result += multiplyUsingRecursion(a, absB - 1);
        return (b < 0) ? -result : result;
    }

    public static final long multiplyUsingShift(int a, int b) {
        int absA = Math.abs(a);
        int absB = Math.abs(b);

        long result = 0L;
        while (absA > 0) {
            if ((absA & 1) > 0)
                result += absB; // Is odd
            absA >>= 1;
            absB <<= 1;
        }

        return (a > 0 && b > 0 || a < 0 && b < 0) ? result : -result;
    }

    public static final long multiplyUsingLogs(int a, int b) {
        long absA = Math.abs(a);
        long absB = Math.abs(b);
        long result = Math.round(Math.pow(10, (Math.log10(absA) + Math.log10(absB))));
        return (a > 0 && b > 0 || a < 0 && b < 0) ? result : -result;
    }

    public static String multiplyUsingFFT(String a, String b) {
        if (a.equals("0") || b.equals("0")) {
            return "0";
        }
        boolean negative = false;
        if ((a.charAt(0) == '-' && b.charAt(0) != '-') || (a.charAt(0) != '-' && b.charAt(0) == '-')) {
            negative = true;
        }
        if (a.charAt(0) == '-') {
            a = a.substring(1);
        }
        if (b.charAt(0) == '-') {
            b = b.substring(1);
        }

        // Placeholder logic for FFT coefficients and multiplication
        // Using basic reverse traversal multiplication for simplicity
        int maxLength = a.length() + b.length();
        int[] result = new int[maxLength];

        for (int i = a.length() - 1; i >= 0; i--) {
            for (int j = b.length() - 1; j >= 0; j--) {
                int product = (a.charAt(i) - '0') * (b.charAt(j) - '0');
                int posLow = i + j + 1;
                int posHigh = i + j;

                result[posLow] += product;
                if (result[posLow] >= 10) {
                    result[posHigh] += result[posLow] / 10;
                    result[posLow] %= 10;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (negative) {
            sb.append('-');
        }
        boolean leadingZero = true;
        for (int num : result) {
            if (leadingZero && num == 0) {
                continue;
            }
            leadingZero = false;
            sb.append(num);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static String multiplyUsingLoopWithStringInput(String a, String b) {
        int carry = 0;
        boolean aIsNegative = a.startsWith("-");
        boolean bIsNegative = b.startsWith("-");
        if (aIsNegative) a = a.substring(1);
        if (bIsNegative) b = b.substring(1);

        int[] res = new int[a.length() + b.length()];
        for (int i = a.length() - 1; i >= 0; i--) {
            for (int j = b.length() - 1; j >= 0; j--) {
                int mul = (a.charAt(i) - '0') * (b.charAt(j) - '0') + res[i + j + 1];
                res[i + j + 1] = mul % 10;
                res[i + j] += mul / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (aIsNegative ^ bIsNegative) sb.append('-');
        for (int num : res) {
            if (!(sb.length() == 0 && num == 0)) sb.append(num);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static int multiplyUsingLoopWithIntegerInput(int a, int b) {
        boolean aIsNegative = a < 0;
        boolean bIsNegative = b < 0;
        a = Math.abs(a);
        b = Math.abs(b);

        int result = 0;
        for (int i = 0; i < b; i++) {
            result += a;
        }
        return aIsNegative ^ bIsNegative ? -result : result;
    }
}
