package come.class08_HashTable_StringI;

public class Q2_2_1_RemoveAdjacentRepeatedCharactersI {
    public String deDup(String input) {
        if (input == null || input.length() < 2) {
            return input;
        }
        char[] cArray = input.toCharArray();
        int s = 0, f = 0;
        while (f < cArray.length) {
            if (cArray[s] == cArray[f]) {
                f++;
            } else {
                cArray[++s] = cArray[f++];
            }
        }
        return new String(cArray, 0, s + 1);
    }
}
