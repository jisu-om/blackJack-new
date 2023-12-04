package domain.card;


import java.util.Arrays;
import java.util.List;

import static domain.Constants.*;
import static domain.Constants.ACE_SCORE_DIFFERENCE;

public class Cards {
    private final List<Card> cards;

    private Cards(List<Card> cards) {
        this.cards = cards;
    }

    public static Cards of(Card... cards) {
        return new Cards(Arrays.asList(cards));
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public boolean isInitialSize() {
        return cards.size() == INITIAL_CARD_SIZE;
    }

    public boolean isBlackjack() {
        return calculateTotalScore() == BLACK_JACK_NUMBER;
    }

    public boolean exceedsBlackjack() {
        return calculateTotalScore() > BLACK_JACK_NUMBER;
    }

    public int calculateTotalScore() {
        int totalScore = calculateOriginalTotalScore();
        long aceCount = getAceCount();

        for (int i = 0; i < aceCount; i++) {
            if (totalScore > BLACK_JACK_NUMBER) {
                totalScore -= ACE_SCORE_DIFFERENCE;
            }
        }
        return totalScore;
    }

    private int calculateOriginalTotalScore() {
        return cards.stream()
                .mapToInt(Card::getScore)
                .sum();
    }

    private long getAceCount() {
        return cards.stream()
                .filter(Card::isAce)
                .count();
    }

    public List<Card> getCards() {
        return cards;
    }
}
