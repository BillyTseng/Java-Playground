package leet;

public class Q50_Pow {
    public double myPow(double x, int n) {
        if (n >= 0) {
            return positivePow(x, n);
        } else {
            return (1 / positivePow(x, -n));
        }
    }

    private double positivePow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        double halfRes = positivePow(x, n / 2);
        if (n % 2 == 0) {
            return halfRes * halfRes;
        } else {
            return halfRes * halfRes * x;
        }
    }
}
