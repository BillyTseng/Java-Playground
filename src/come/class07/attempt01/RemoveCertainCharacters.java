package come.class07.attempt01;

import java.util.HashSet;
import java.util.Set;

public class RemoveCertainCharacters {
    public String remove(String input, String t) {
        if (input == null || input.length() == 0 || t == null || t.length() == 0) {
            return input;
        }
        Set<Character> targetSet = buildTargetSet(t);
        char[] inputArray = input.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < inputArray.length; fast++) {
            if (!targetSet.contains(inputArray[fast])) {
                inputArray[slow++] = inputArray[fast];
            }
        }
        return new String(inputArray, 0, slow);
    }

    private Set<Character> buildTargetSet(String t) {
        char[] cArray = t.toCharArray();
        Set<Character> targetSet = new HashSet<>();
        for (char c : cArray) {
            targetSet.add(c);
        }
        return targetSet;
    }
}
