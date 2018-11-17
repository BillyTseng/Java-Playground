package leet.Q01to50;

public class Q12_IntegerToRoman {
    public String intToRoman(int num) {
        int[] value = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            if (num >= value[i]) {
                int count = num / value[i];
                num %= value[i];
                while (count-- > 0) {
                    sb.append(symbol[i]);
                }
            }
        }
        return sb.toString();
    }
}
