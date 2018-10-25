package come.planS.array_string;

public class ReverseWordsInASentenceI {
    public String reverseWords(String input) {
        if (input == null) {
            return null;
        }

        char[] chars = input.toCharArray();
        reverse(chars, 0, chars.length - 1);

        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != ' ' && (fast == 0 || chars[fast - 1] == ' ')) {
                slow = fast;
            }

            if (chars[fast] != ' ' && (fast == chars.length - 1 || chars[fast + 1] == ' ')) {
                reverse(chars, slow, fast);
            }
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
