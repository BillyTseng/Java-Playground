package come.class02.attempt02;

public class AToThePowerOfB {
    private long power(int a, int b) {
        if (a == 0 || a == 1) {
            return a;
        }
        if (b == 0) {
            return 1;
        }
        long half = power(a, b / 2);
        if (b % 2 == 0) {
            return half * half;
        } else if (b > 0) {
            return half * half * a;
        } else {
            return half * half / a;
        }
    }
}
