package come.practice.class16;

public class ParseStringToPositiveInteger {
    public int stringToInt(String word) {
        // assume input string is not null.
        // assume all character are valid and positive digits.
        int sum = 0;
        for (char c : word.toCharArray()) {
            sum = sum * 10 + (c - '0');
        }
        return sum;
    }
}
