package come.class11_BitOperations.attempt02;

public class HexadecimalRepresentation {
    private String hex(int num) {
        if (num == 0) {
            return "0x0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int temp = num & 0xf;
            if (temp < 10) {
                sb.append(temp);
            } else {
                sb.append((char)(temp - 10 + 'A'));
            }
            num >>>= 4;
        }

        sb.append("x0");
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        HexadecimalRepresentation solution = new HexadecimalRepresentation();
        System.out.println(solution.hex(255));
        System.out.println(solution.hex(4097));
    }
}
