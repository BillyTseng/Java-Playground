package come.Freq;

import java.util.*;

/**
 * 332. Reconstruct Itinerary - Medium
 */

public class Q7_ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0) {
            return new ArrayList<>();
        }

        int totalLen = tickets.length + 1;

        Map<String, List<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new ArrayList<>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }

        for (List<String> list : map.values()) {
            Collections.sort(list);
        }

        String start = "JFK";
        List<String> res = new ArrayList<>();
        res.add(start);
        if (findItinerary(start, res, map, totalLen)) {
            return res;
        }
        return res;
    }

    private boolean findItinerary(String start, List<String> path, Map<String, List<String>> map, int totalLen) {
        if (path.size() == totalLen) {
            return true;
        }

        if (!map.containsKey(start)) {
            return false;
        }

        List<String> destinations = map.get(start);

        for (int i = 0; i < destinations.size(); i++) {
            String dest = destinations.get(i);
            destinations.remove(i);
            path.add(dest);
            if (findItinerary(dest, path, map, totalLen)) {
                return true;
            }
            path.remove(path.size() - 1);
            destinations.add(i, dest);
        }
        return false;
    }
}
