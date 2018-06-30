package come.class11_BitOperations;

public class Q3_AllUniqueCharactersII {
    public boolean allUnique(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        int[] occurredTable = new int[8];
        for (int i = 0; i < word.length(); i++) {
            int ascii = word.charAt(i);
            int row = ascii / 32;
            int col = ascii % 32;
            // check there is an occurred character or not.
            if (((occurredTable[row] >>> col) & 1) == 1) {
                return false;
            } else {
                occurredTable[row] |= 1 << col;
            }
        }
        return true;
    }
}
