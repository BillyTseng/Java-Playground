package come.practice.class16;

public class Atoi {
    // case 1: null or empty string
    // case 2: leading spaces
    // case 3: leading + or -
    // case 4: trailing spaces or other characters.
    // case 5: integer overflow, -2^31 ~ (2^31 - 1)
    private int myAtoi(String input) {
        // case 1
        if (input == null || input.length() == 0) {
            return 0;
        }

        int i = 0;
        // case 2
        while (i < input.length() && input.charAt(i) == ' ') {
            i++;
        }
        // case 3
        boolean positiveFlag = true;
        if (input.charAt(i) == '-' || input.charAt(i) == '+') {
            positiveFlag = (input.charAt(i) == '+');
            i++;
        }
        // case 4
        long sum = 0;
        while (i < input.length() && input.charAt(i) >= '0' && input.charAt(i) <= '9') {
            sum = sum * 10 + (input.charAt(i) - '0');
            if (sum > (long)Integer.MAX_VALUE + 1) {
                break;
            }
            i++;
        }
        //case 5
        sum = positiveFlag ? sum : -sum;
        if (sum < (long)Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (sum > (long)Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)sum;
    }

    public static void main(String[] args) {
        Atoi solution = new Atoi();
        // case 1
        String str = null;
        System.out.println(solution.myAtoi(str));
        str = "";
        System.out.println(solution.myAtoi(str));
        // case 2
        str = "    -9676";
        System.out.println(solution.myAtoi(str));
        // case 3
        str = "    +998676";
        System.out.println(solution.myAtoi(str));
        // case 4
        str = "    +998676&*^*(  ";
        System.out.println(solution.myAtoi(str));
        // case 5
        str = "2147483649";
        System.out.println(solution.myAtoi(str));
        str = "-2147483650";
        System.out.println(solution.myAtoi(str));
    }
}
