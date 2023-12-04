package view;

import camp.nextstep.edu.missionutils.Console;
import utils.BettingMoneyValidator;
import utils.PlayerNamesValidator;

import java.util.List;

public class InputView {
    private static final InputView instance = new InputView();
    private static final String ASK_PLAYER_NAMES = "게임에 참여할 사람의 이름을 입렵하세요.(쉼표 기준으로 분리)";
    private static final String PLAYER_NAME_DELIMITER = ",";
    private static final String BETTING_MONEY_FORMAT = "%s의 배팅 금액은?";

    private InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }

    public List<String> readPlayerNames() {
        System.out.println(ASK_PLAYER_NAMES);
        String input = Console.readLine();
        return PlayerNamesValidator.safeSplit(input, PLAYER_NAME_DELIMITER);
    }

    public double readBettingMoney(String name) {
        printLine();
        System.out.printf((BETTING_MONEY_FORMAT) + "%n", name);
        String input = Console.readLine();
        return BettingMoneyValidator.safeParsePositiveDouble(input);
    }

    private void printLine() {
        System.out.println();
    }
}
