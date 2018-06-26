package come.class23_midtermII.attempt01;

/* Given an integer n, print/output all possible if blocks for it.
    Say n=2 output should be. */
/** example
 *
 *
 * if {
 * }
 * if {
 * }
 * <newline>
 * if {
 *    if {// here should exist two spaces before each inner block
 *    }
 * }
 */


public class PrintAllPossibleIfBlocks {
    private void printAllPossibleIfBlock(int n) {
        StringBuilder sb = new StringBuilder();
        listAllIfBlocks(sb, n, 0, 0);
    }

    private void listAllIfBlocks(StringBuilder sb, int n, int l, int r) {
        if (r == n && l == n) {
            printAllBlocks(sb.toString());
            return;
        }

        if (l < n) {
            sb.append("{");
            listAllIfBlocks(sb, n, l + 1, r);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r < l) {
            sb.append("}");
            listAllIfBlocks(sb, n, l, r + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private void printAllBlocks(String input) {
        int indent = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '{') {
                printSpaces(indent);
                System.out.println("if {");
                indent += 2;
            } else {
                indent -= 2;
                printSpaces(indent);
                System.out.println("}");
            }
        }
        System.out.println();
    }

    private void printSpaces(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        PrintAllPossibleIfBlocks solution = new PrintAllPossibleIfBlocks();
        solution.printAllPossibleIfBlock(3);
    }
}
