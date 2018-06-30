package come.class11_BitOperations;

public class Q5_HexadecimalRepresentation {
    private String hex(int number) {
        if (number == 0) {
            return "0x0";
        }
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int hexDigit = number % 16;
            if (hexDigit < 10) {
                sb.append((char)(hexDigit + '0'));
            } else {
                sb.append((char)(hexDigit - 10 + 'A'));
            }
            number >>>= 4;
        }
        return "0x" + sb.reverse().toString();
    }

    public static void main(String[] args) {
        Q5_HexadecimalRepresentation solution = new Q5_HexadecimalRepresentation();
        System.out.println(solution.hex(0));
        System.out.println(solution.hex(4097));
    }
}
