package come.class11_BitOperations.attempt03;

public class AllUniqueCharactersII {
    public boolean allUnique(String word) {
        if (word == null || word.length() <= 1) {
            return true;
        }

        int[] bitTable = new int[8];
        for (int i = 0; i < word.length(); i++) {
            int ascii = word.charAt(i);
            int row = ascii / 32;
            int col = ascii % 32;
            if (((bitTable[row] >>> col) & 1) == 0) {
                bitTable[row] |= 1 << col;
            } else {
                return false;
            }
        }
        return true;
    }
}
