package leet.Q51toQ100;

import java.util.*;

public class Q71_SimplifyPath {
    public String simplifyPath(String path) {
        String[] splits = path.split("/+");
        Deque<String> dq = new ArrayDeque<>();
        for (String split : splits) {
            if (split.equals("..")) {
                if (!dq.isEmpty()) {
                    dq.pollFirst();
                }
            } else if (!split.equals(".") && !split.equals("")) {
                dq.offerFirst(split);
            }
        }
        /* slower method to compose path */
        // StringBuilder sb = new StringBuilder();
        // while (!dq.isEmpty()) {
        //     sb.append('/').append(dq.pollLast());
        // }
        // if (sb.length() == 0) {
        //     sb.append('/');
        // }
        // return sb.toString();

        /* faster method to compose path */
        List<String> list = new ArrayList<>(dq);
        Collections.reverse(list);
        return "/" + String.join("/", list);
    }
}
