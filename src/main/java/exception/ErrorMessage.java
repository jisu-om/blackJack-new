package exception;

public enum ErrorMessage {
    ERROR_CAPTION("[ERROR] "),
    NOT_NUMERIC_INPUT("숫자를 입력해 주세요."),
    NOT_POSITIVE_INPUT("양수를 입력해 주세요."),
    INVALID_PLAYER_NAMES("유효하지 않은 이름 형식 입니다."),
    DUPLICATE_PLAYER_NAMES("중복되지 않은 이름을 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_CAPTION.message + message;
    }
}
