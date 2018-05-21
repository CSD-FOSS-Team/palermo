package com.csdfossteam.palermo.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO doc
 *
 * @author Akritas Akritidis
 */
public class VoteResult {

    public final boolean failed;

    public final Player selected;
    public final int selectedVotes;

    public final List<Map.Entry<Player, Integer>> votes;

    public VoteResult(HashMap<Player, Player> votesMap) {

        // get the count for each player
        HashMap<Player, Integer> count = countVotes(votesMap);

        // move from a map to a list
        votes = new ArrayList<>(count.entrySet());

        // sort the list based on the votes
        Collections.sort(votes, COMPARATOR);

        // get the result
        if (votes.get(0).getValue().equals(votes.get(1).getValue())) {
            // tie in votes
            failed = true;
            selected = null;
            selectedVotes = 0;

        } else {
            // selected found
            failed = false;
            selected = votes.get(0).getKey();
            selectedVotes = votes.get(0).getValue();
        }
    }

    private static final Comparator<Map.Entry<Player, Integer>> COMPARATOR = new Comparator<Map.Entry<Player, Integer>>() {
        @Override
        public int compare(Map.Entry<Player, Integer> o1, Map.Entry<Player, Integer> o2) {
            return Integer.compare(o2.getValue(), o1.getValue());
        }
    };

    private HashMap<Player, Integer> countVotes(HashMap<Player, Player> votesMap) {

        HashMap<Player, Integer> count = new HashMap<>();
        for (Map.Entry<Player, Player> i : votesMap.entrySet()) {
            Player p = i.getValue();
            if (count.containsKey(p)) {
                count.put(p, count.get(p) + 1);
            } else {
                count.put(p, 1);
            }
        }
        return count;
    }
}
