package come.class02.attempt01;

public class AToThePowerOfB {
    public long power(int a, int b) {
        // Write your solution here
        if (b == 0) {
            return 1;
        }
        if (a == 0) {
            return 0;
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

    public static void main(String[] args) {
        AToThePowerOfB solution = new AToThePowerOfB();
        System.out.println(solution.power(0, 0));
        System.out.println(solution.power(0, 100));
        System.out.println(solution.power(2, 3));
        System.out.println(solution.power(3, 3));
    }
}
