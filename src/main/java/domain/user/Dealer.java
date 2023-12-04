package domain.user;

import domain.Constants;
import domain.card.Card;
import domain.card.Cards;

public class Dealer extends User {

    public Dealer() {
        super();
    }

    public boolean needsDraw() {
        return getTotalScore() <= Constants.DEALER_DRAW_THRESHOLD;
    }
}
