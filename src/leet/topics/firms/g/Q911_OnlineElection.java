package leet.topics.firms.g;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q911_OnlineElection {
    class TopVotedCandidate {
        List<Vote> status;
        public TopVotedCandidate(int[] persons, int[] times) {
            status = new ArrayList<>();
            Map<Integer, Integer> count = new HashMap<>();
            int leader = -1;
            int leaderVote = 0;

            for (int i = 0; i < persons.length; i++) {
                int p = persons[i], t = times[i];
                int c = count.getOrDefault(p, 0) + 1;
                count.put(p, c);

                if (c >= leaderVote) {
                    if (p != leader) {
                        leader = p;
                        status.add(new Vote(leader, t));
                    }

                    if (c > leaderVote) {
                        leaderVote = c;
                    }
                }
            }
        }

        public int q(int t) {
            int left = 0, right = status.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (status.get(mid).time < t) {
                    left = mid + 1;
                } else if (status.get(mid).time > t) {
                    right = mid - 1;
                } else {
                    return status.get(mid).person;
                }
            }
            return right == -1 ? -1 : status.get(right).person;
        }

        private class Vote {
            int person, time;
            Vote(int p, int t) {
                person = p;
                time = t;
            }
        }
    }
}
