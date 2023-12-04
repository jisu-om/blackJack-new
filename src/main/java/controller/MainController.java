package controller;

import domain.user.Player;
import domain.user.Players;
import dto.PlayerNamesDto;
import view.InputView;
import view.OutputView;

import javax.naming.Name;
import java.util.List;
import java.util.function.Supplier;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;

    private MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static MainController create() {
        return new MainController(InputView.getInstance(), OutputView.getInstance());
    }

    public void run() {
        PlayerNamesDto playerNamesDto = createPlayerNamesDto();
        List<Player> uniquePlayers = playerNamesDto.names().stream()
                .map(this::createPlayer)
                .toList();
        Players players = Players.from(uniquePlayers);

    }

    private PlayerNamesDto createPlayerNamesDto() {
        return readUserInput(() -> {
            List<String> playerNames = inputView.readPlayerNames();
            return new PlayerNamesDto(playerNames);
        });
    }

    private Player createPlayer(String name) {
        return readUserInput(() -> {
            double bettingMoney = inputView.readBettingMoney(name);
            return new Player(name, bettingMoney);
        });
    }

    private <T> T readUserInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
