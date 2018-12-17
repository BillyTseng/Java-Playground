package leet.topics.firms.g;

import java.util.HashSet;
import java.util.Set;

public class Q929_UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }
        Set<String> countSet = new HashSet<>();
        for (String email : emails) {
            String[] names = email.split("@");
            StringBuilder sb = new StringBuilder();
            // process local name
            for (char ch : names[0].toCharArray()) {
                if (ch == '+') {
                    break;
                }
                if (ch != '.') {
                    sb.append(ch);
                }
            }
            // append domain name
            sb.append(names[1]);
            countSet.add(sb.toString());
        }
        return countSet.size();
    }
}
