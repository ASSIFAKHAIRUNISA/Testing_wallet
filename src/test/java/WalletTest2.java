import org.example.Wallet;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WalletTest2 {
    private Wallet wallet;

    @BeforeEach
    void setUp() {
        wallet = new Wallet("Assifa Khairu");
    }

    @Test
    @Order(1)
    void testAddCard() {
        wallet.addCard("Visa");
        wallet.addCard("MasterCard");
        assertEquals(2, wallet.getCardCount());
    }

    @Test
    @Order(2)
    void testRemoveCard() {
        wallet.addCard("Visa");
        assertTrue(wallet.removeCard("Visa"));
        assertFalse(wallet.removeCard("MasterCard"));
    }

    @ParameterizedTest
    @CsvSource({"10000", "5000", "2000"})
    @Order(3)
    void testAddCash(int amount) {
        wallet.addCash(amount);
        assertTrue(wallet.getTotalMoney() >= amount);
    }

    @ParameterizedTest
    @CsvSource({"500", "1000", "200"})
    @Order(4)
    void testAddCoin(int coin) {
        wallet.addCoin(coin);
        assertTrue(wallet.getTotalMoney() >= coin);
    }

    @ParameterizedTest
    @MethodSource("TestDataWallet#provideWithdrawData")
    @Order(5)
    void testWithdrawMoney(int[] cash, int[] coins, int amount, boolean expected) {
        for (int c : cash) wallet.addCash(c);
        for (int k : coins) wallet.addCoin(k);
        assertEquals(expected, wallet.withdrawMoney(amount));
    }
}
