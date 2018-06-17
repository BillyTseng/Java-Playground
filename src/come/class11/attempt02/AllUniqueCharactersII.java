package come.class11.attempt02;

public class AllUniqueCharactersII {
    public boolean allUnique(String word) {
        if (word == null || word.length() <= 1) {
            return true;
        }
        int[] bitTable = new int[8];
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i);
            int row = c / 32;
            int col = c % 32;
            if ((bitTable[row] & (1 << col)) == 0) {
                bitTable[row] |= 1 << col;
            } else {
                return false;
            }
        }
        return true;
    }
}
