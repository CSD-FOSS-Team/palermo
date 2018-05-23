package com.csdfossteam.palermo.core.vote;

import com.csdfossteam.palermo.core.Player;
import com.csdfossteam.palermo.core.Players;
import com.csdfossteam.palermo.core.Rules;

import java.util.HashMap;

/**
 * A vote where the majority must decide to yes or no.
 *
 * @author Akritas Akritidis
 */
public final class MajorityVote extends Vote<Boolean> {

    private final HashMap<Player, Integer> votes;

    public final Player subject;

    private final boolean allowVoteMultipliers;

    public MajorityVote(Players players, Player subject, Rules rules) {
        super(players);
        this.subject = subject;

        votes = new HashMap<>();

        allowVoteMultipliers = rules.allowVoteMultipliers;
    }

    public void set(Player voter, Boolean vote) {
        int mult = allowVoteMultipliers ? voter.voteMultiplier() : 1;

        votes.put(voter, (vote ? 1 : -1) * mult);
    }

    @Override
    public int missing() {
        return players.size() - votes.size();
    }

    @Override
    public Result result() {
        return new Result(subject, votes);
    }

    /**
     * The result of a majority vote.
     */
    public static final class Result extends Vote.Result<Boolean> {

        public final boolean failed;

        public final Player subject;

        public final int positive;
        public final int negative;
        public final int result;

        public Result(Player subject, HashMap<Player, Integer> votes) {
            this.subject = subject;

            // count the votes
            int positive = 0;
            int negative = 0;
            for (int i : votes.values()) {
                if (i > 0) {
                    positive += i;
                } else {
                    negative += -i;
                }
            }

            this.positive = positive;
            this.negative = negative;
            this.result = positive - negative;
            this.failed = positive == negative;
        }

        @Override
        public boolean failed() {
            return failed;
        }

        @Override
        public Boolean result() {
            return result > 0;
        }
    }

}
