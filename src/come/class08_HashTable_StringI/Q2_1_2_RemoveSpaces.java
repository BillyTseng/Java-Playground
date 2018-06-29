package come.class08_HashTable_StringI;

public class Q2_1_2_RemoveSpaces {
    public String removeSpaces(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }

        char[] cArray = input.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < cArray.length; fast++) {
            if (cArray[fast] == ' ' && (fast == 0 || cArray[fast - 1] == ' ')) {
                continue;
            }
            cArray[slow++] = cArray[fast];
        }
        if (slow > 0 && cArray[slow - 1] == ' ') {
            slow--;
        }
        return new String(cArray, 0, slow);
    }
}
