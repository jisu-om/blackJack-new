package utils;

import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static exception.ErrorMessage.DUPLICATE_PLAYER_NAMES;
import static exception.ErrorMessage.INVALID_PLAYER_NAMES;

public class PlayerNamesValidator {
    public static List<String> safeSplit(String input, String delimiter) {
        validateEmpty(input);
        validateStartsOrEndsWithDelimiter(input, delimiter);

        List<String> names = Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .toList();

        validateDuplicates(names);
        return names;
    }

    private static void validateEmpty(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(INVALID_PLAYER_NAMES.getMessage());
        }
    }

    private static void validateStartsOrEndsWithDelimiter(String input, String delimiter) {
        if (input.startsWith(delimiter) || input.endsWith(delimiter)) {
            throw new IllegalArgumentException(INVALID_PLAYER_NAMES.getMessage());
        }
    }

    public static void validateDuplicates(List<String> values) {
        Set<String> set = new HashSet<>(values);
        if (set.size() != values.size()) {
            throw new IllegalArgumentException(DUPLICATE_PLAYER_NAMES.getMessage());
        }
    }

}
