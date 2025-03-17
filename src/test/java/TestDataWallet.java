import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class TestDataWallet {
    static Stream<Arguments> provideWithdrawData() {
        return Stream.of(
                Arguments.of(new int[]{10000, 5000, 2000}, new int[]{500, 1000}, 12000, true),
                Arguments.of(new int[]{5000, 2000}, new int[]{500, 1000}, 9000, false)
        );
    }
}
