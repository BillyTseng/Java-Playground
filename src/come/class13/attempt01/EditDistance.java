package come.class13.attempt01;

public class EditDistance {
    private int editDistance(String one, String two) {
        int[][] dArray = new int[one.length() + 1][two.length() + 1];
        for (int i = 0; i <= one.length(); i++) {
            for (int j = 0; j <= two.length(); j++) {
                if (i == 0) {
                    dArray[i][j] = j;
                } else if (j == 0) {
                    dArray[i][j] = i;
                } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    dArray[i][j] =  dArray[i - 1][j - 1];
                } else {
                    dArray[i][j] = Math.min(dArray[i][j - 1], dArray[i - 1][j]);
                    dArray[i][j] = Math.min(dArray[i][j], dArray[i - 1][j - 1]);
                    dArray[i][j] += 1;
                }
            }
        }
        return dArray[one.length()][two.length()];
    }

    public static void main(String[] args) {
        EditDistance solution = new EditDistance();
        System.out.println(solution.editDistance("asdf", "sghj"));
        System.out.println(solution.editDistance("sigh", "asith"));
    }
}
