package lint.medium;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {
    /**
     * @param path: the original path
     * @return: the simplified path
     */
    public String simplifyPath(String path) {
        // write your code here
        StringBuilder res = new StringBuilder("/");
        String[] stubs = path.split("/+");
        List<String> paths = new ArrayList<>();

        for (String s : stubs) {
            if (s.equals("..")) {
                if (paths.size() > 0) {
                    paths.remove(paths.size() - 1);
                }
            } else if (!s.equals(".") && !s.equals("")) {
                paths.add(s);
            }
        }

        for (String s : paths) {
            res.append(s).append("/");
        }
        if (res.length() > 1) {
            res = new StringBuilder(res.substring(0, res.length() - 1));
        }
        return res.toString();
    }
}
