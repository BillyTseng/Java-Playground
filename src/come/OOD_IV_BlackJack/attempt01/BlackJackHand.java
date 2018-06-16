package come.OOD_IV_BlackJack.attempt01;

import java.util.ArrayList;
import java.util.List;

public class BlackJackHand extends Hand {
    @Override
    public int score() {
        List<Integer> scores = possibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > 21 && score < minOver) {
                minOver = score;
            } else if (score <= 21 && score > maxUnder) {
                maxUnder = score;
            }
        }
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    private List<Integer> possibleScores() {
        List<Integer> scores = new ArrayList<>();
        for (Card card : cards) {
            updateScores(card, scores);
        }
        return scores;
    }

    private void updateScores(Card card, List<Integer> scores) {
        final int[] toAdd = getScores(card);

        if (scores.isEmpty()) {
            for (int score : toAdd) {
                scores.add(score);
            }
        } else {
            final int length = scores.size();
            for (int i = 0; i < length; i++) {
                int oldScore = scores.get(i);
                scores.set(i, oldScore + toAdd[0]);
                /*
                for (int j = 1; j < toAdd.length; j++) {
                    scores.add(oldScore + toAdd[j]);
                }
                */
                if (toAdd.length == 2) {
                    scores.add(oldScore + toAdd[1]);
                }
            }
        }
    }

    private int[] getScores(Card card) {
        int cardValue = card.getFaceValue().ordinal() + 1;
        if (cardValue > 1) {
            return new int[] {Math.min(cardValue, 10)};
        } else { // Ace
            return new int[] {1, 11};
        }
    }

    public boolean isBusted() {
        return score() > 21;
    }

    public boolean isBlackJack() {
        if (cards.size() != 2) {
            return false;
        }
        Card first = cards.get(0);
        Card second = cards.get(1);
        return (isAce(first) && isFaceCard(second)) || (isAce(second) && isFaceCard(first));
    }

    private boolean isAce (Card c) {
        return c.getFaceValue().ordinal() + 1 == 1;
    }

    private boolean isFaceCard(Card c) {
        int cardValue = c.getFaceValue().ordinal() + 1;
        return cardValue >= 11 && cardValue <= 13;
    }
}
