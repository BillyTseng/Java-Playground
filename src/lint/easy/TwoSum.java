package lint.easy;

import java.util.HashMap;

public class TwoSum {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                return new int[] {map.get(numbers[i]), i};
            }
            map.put(target - numbers[i], i);
        }
        return new int[2];
    }
}
