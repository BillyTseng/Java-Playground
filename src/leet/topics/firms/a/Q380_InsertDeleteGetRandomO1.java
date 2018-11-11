package leet.topics.firms.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q380_InsertDeleteGetRandomO1 {
    // key: input value, value: index
    Map<Integer, Integer> valToIdx;
    List<Integer> values;
    /** Initialize your data structure here. */
    public Q380_InsertDeleteGetRandomO1() {
        valToIdx = new HashMap<>();
        values = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valToIdx.containsKey(val)) {
            return false;
        }
        values.add(val);
        valToIdx.put(val, values.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valToIdx.containsKey(val)) {
            return false;
        }
        int idx = valToIdx.remove(val);
        if (idx < values.size() - 1) {
            int lastValue = values.get(values.size() - 1);
            values.set(idx, lastValue);
            valToIdx.put(lastValue, idx);
        }
        values.remove(values.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomIdx = (int)(Math.random() * values.size());
        return values.get(randomIdx);
    }
}
