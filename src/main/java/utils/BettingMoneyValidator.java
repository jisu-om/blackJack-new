package utils;

import static exception.ErrorMessage.NOT_NUMERIC_INPUT;
import static exception.ErrorMessage.NOT_POSITIVE_INPUT;

public class BettingMoneyValidator {
    public static double safeParsePositiveDouble(String input) {
        try {
            double value = Double.parseDouble(input);
            validatePositive(value);
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_INPUT.getMessage());
        }
    }

    private static void validatePositive(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_INPUT.getMessage());
        }
    }
}
