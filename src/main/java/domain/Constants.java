package domain;

import domain.card.Symbol;
import domain.card.Type;

public class Constants {
    public static final int INITIAL_CARD_SIZE = 2;
    public static final int BLACK_JACK_NUMBER = 21;
    public static final int ACE_OPTIONAL_SCORE = 11;
    public static final int ACE_SCORE_DIFFERENCE = Math.abs(Constants.ACE_OPTIONAL_SCORE - Symbol.ACE.getScore());
    public static final int DEALER_DRAW_THRESHOLD = 16;
}
