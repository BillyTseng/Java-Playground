package come.class02_RecursionI_BinarySearch.attempt01;

public class Q1_2_AToThePowerOfB {
    private double myPow(double x, int n) {
        if (n >= 0) {
            return postivePow(x, (long)n);
        } else {
            return 1 / postivePow(x, -(long)n);
        }
    }

    private double postivePow(double x, long n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        double halfRes = postivePow(x, n/2);
        if (n % 2 == 0) {
            return halfRes * halfRes;
        } else {
            return halfRes * halfRes * x;
        }
    }

    public static void main(String[] args) {
        Q1_2_AToThePowerOfB solution = new Q1_2_AToThePowerOfB();
        System.out.println(solution.myPow(0, 0));
        System.out.println(solution.myPow(0, 100));
        System.out.println(solution.myPow(2, 3));
        System.out.println(solution.myPow(3, 3));
        System.out.println(solution.myPow(2, Integer.MIN_VALUE));
        System.out.println(solution.myPow(-1, Integer.MIN_VALUE));
    }
}
