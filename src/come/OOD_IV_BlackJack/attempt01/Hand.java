package come.OOD_IV_BlackJack.attempt01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
    protected final List<Card> cards = new ArrayList<>();

    public int score() {
        int score = 0;
        for (Card card : cards) {
            score += card.getFaceValue().ordinal() + 1;
        }
        return score;
    }

    public void addCards(Card[] c) {
        Collections.addAll(cards, c);
    }

    public int size() {
        return cards.size();
    }
}
