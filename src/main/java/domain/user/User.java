package domain.user;

import domain.card.Card;
import domain.card.Cards;

public class User {
    private Cards cards;

    protected User() {
    }

    public void initializeCards(Cards cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public boolean isBlackjack() {
        return cards.isBlackjack();
    }

    public boolean exceedsBlackjack() {
        return cards.exceedsBlackjack();
    }

    public int getTotalScore() {
        return cards.calculateTotalScore();
    }

    public boolean isEqualScore(User user) {
        return getTotalScore() == user.getTotalScore();
    }

    public boolean isHigherScore(User user) {
        return getTotalScore() > user.getTotalScore();
    }

    public Cards getCards() {
        return cards;
    }
}
