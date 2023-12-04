package domain.user;

public class Player extends User {
    private final String name;
    private final double bettingMoney;

    public Player(String name, double bettingMoney) {
        super();
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public boolean isInitialBlackjack() {
        return isBlackjack() && getCards().isInitialSize();
    }

    public String getName() {
        return name;
    }

    public double getBettingMoney() {
        return bettingMoney;
    }
}
