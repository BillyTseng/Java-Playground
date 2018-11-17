package leet.Q01to50;

public class Q29_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        if (divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);

        int res = 0;
        while (pDividend >= pDivisor) {
            int numShift = 0;
            while (pDividend >= (pDivisor << numShift)) {
                numShift++;
            }
            numShift--;

            res += 1 << numShift;
            pDividend -= pDivisor << numShift;
        }

        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return res;
        } else {
            return -res;
        }
    }
}
