package come.seattlePlan.array_string;

public class ReverseString {
    public String reverse(String input) {
        char[] chars = input.toCharArray();
        int i = 0, j = chars.length - 1;

        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }
}
