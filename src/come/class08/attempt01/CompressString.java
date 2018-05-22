package come.class08.attempt01;

public class CompressString {
    private String compress(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }

        char[] array = input.toCharArray();
        int write = 0, blockBegin = 0;
        for (int read = 0; read < array.length; read++) {
            if (read + 1 == array.length || array[read + 1] != array[read]) {
                array[write++] = array[blockBegin];
                if (read > blockBegin) {
                    for (char c : ("" + (read + 1 - blockBegin)).toCharArray()) {
                        array[write++] = c;
                    }
                }
                blockBegin = read + 1;
            }
        }
        return new String(array, 0, write);
    }

    public static void main(String[] args) {
        CompressString solution = new CompressString();
        System.out.println(solution.compress("aii"));
    }
}
