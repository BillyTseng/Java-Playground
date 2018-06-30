package come.class11_BitOperations.attempt03;

public class HexadecimalRepresentation {
    public String hex(int num) {
        if (num <= 0) {
            return "0x0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int digit = num & 0xf;
            if (digit < 10) {
                sb.append(digit);
            } else {
                sb.append((char)('A' + (digit - 10)));
            }
            num >>>= 4;
        }
        sb.append("x0");
        return sb.reverse().toString();
    }
}
