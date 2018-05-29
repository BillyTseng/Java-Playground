package come.class11.attempt01;

public class HexadecimalRepresentation {
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
        HexadecimalRepresentation solution = new HexadecimalRepresentation();
        System.out.println(solution.hex(0));
        System.out.println(solution.hex(4097));
    }
}
