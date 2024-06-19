import org.example.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import io.qameta.allure.Step;

import java.util.stream.Stream;


public class AccountTest {

    @ParameterizedTest
    @MethodSource("argumentsStream")
    @DisplayName("testing AccountName to mask")
    public void testAccountNameToMask(String accountName, boolean isProperName) {
        Account account = new Account(accountName);
        compareNameToMask(account.checkNameString(), isProperName);
    }

    @Step("compare string results")
    public void compareNameToMask(boolean actual, boolean expected) {
        Assertions.assertEquals(actual, expected);
    }

    public static Stream<Arguments> argumentsStream() {
        return Stream.of(
                Arguments.of("Иван Петрович", true),
                Arguments.of(" ИванПердович ", false),
                Arguments.of(" ИванПердович", false),
                Arguments.of("Иванидиван ", false),
                Arguments.of("Иванидиван Петрович", true),
                Arguments.of("ив", false),
                Arguments.of("ивa", false),
                Arguments.of("ив n", true),
                Arguments.of("Иванидиван Петровичh", false),
                Arguments.of("Иванидиван Петровb", true)
        );
    }
}
