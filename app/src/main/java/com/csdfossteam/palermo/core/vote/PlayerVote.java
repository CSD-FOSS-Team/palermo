package com.csdfossteam.palermo.core.vote;

import com.csdfossteam.palermo.core.Player;
import com.csdfossteam.palermo.core.Players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A vote where the most votes will decide to a player.
 *
 * @author Akritas Akritidis
 */
public class PlayerVote extends Vote<Player.Id> {

    protected final HashMap<Player, Player.Id> votes;

    public final boolean allowSelf;

    public PlayerVote(Players players, boolean allowSelf) {
        super(players);
        this.allowSelf = allowSelf;

        votes = new HashMap<>();
        for (Player i : players) {
            votes.put(i, Player.Id.NONE);
        }
    }

    public void set(Player voter, Player.Id vote) {
        if (!allowSelf && voter.id().equals(vote)) throw new RuntimeException();

        votes.put(voter, vote);
    }

    @Override
    public int missing() {
        int count = 0;
        for (Player.Id i : votes.values()) {
            if (i == Player.Id.NONE) count += 1;
        }
        return count;
    }

    @Override
    public Result result() {
        return new Result(votes);
    }

    /**
     * The result of a player vote.
     */
    public static final class Result extends Vote.Result<Player.Id> {

        public final boolean failed;

        public final Player.Id selected;
        public final int selectedVotes;

        public final List<Map.Entry<Player.Id, Integer>> votes;

        public Result(HashMap<Player, Player.Id> votesMap) {

            // get the count for each player
            HashMap<Player.Id, Integer> count = countVotes(votesMap);

            // move from a map to a list
            votes = new ArrayList<>(count.entrySet());

            // sort the list based on the votes
            Collections.sort(votes, COMPARATOR);

            // get the result
            if (votes.size() > 1 && votes.get(0).getValue().equals(votes.get(1).getValue())) {
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

        private static final Comparator<Map.Entry<Player.Id, Integer>> COMPARATOR = new Comparator<Map.Entry<Player.Id, Integer>>() {
            @Override
            public int compare(Map.Entry<Player.Id, Integer> o1, Map.Entry<Player.Id, Integer> o2) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        };

        private HashMap<Player.Id, Integer> countVotes(HashMap<Player, Player.Id> votesMap) {

            HashMap<Player.Id, Integer> count = new HashMap<>();
            for (Map.Entry<Player, Player.Id> i : votesMap.entrySet()) {
                Player.Id p = i.getValue();
                if (count.containsKey(p)) {
                    count.put(p, count.get(p) + 1);
                } else {
                    count.put(p, 1);
                }
            }
            return count;
        }

        @Override
        public boolean failed() {
            return failed;
        }

        @Override
        public Player.Id result() {
            return selected;
        }
    }

}
