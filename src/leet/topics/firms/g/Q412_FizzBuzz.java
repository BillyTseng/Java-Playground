package leet.topics.firms.g;

import java.util.ArrayList;
import java.util.List;

public class Q412_FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }

        return res;
    }
}
