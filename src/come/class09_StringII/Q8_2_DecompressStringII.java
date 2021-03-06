package come.class09_StringII;

public class Q8_2_DecompressStringII {
    public String decompressII (String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }

        StringBuilder sb = new StringBuilder();
        char[] array = input.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char ch = array[i++];
            int count = array[i] - '0';
            for (int j = 0; j < count; j++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q8_2_DecompressStringII solution = new Q8_2_DecompressStringII();
        System.out.println(solution.decompressII("a1c0b2c4"));
    }
}
