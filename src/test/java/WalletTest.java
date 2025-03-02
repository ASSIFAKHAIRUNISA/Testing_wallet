////TUGAS 1
//import org.example.Wallet;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class WalletTest {
//
//    @Test
//    void testOwnerSetCorrectly() {
//        Wallet wallet = new Wallet("Assifa");
//        assertNotNull(wallet, "Wallet seharusnya tidak null");
//    }
//
//    @Test
//    public void testAddAndRemoveCard() {
//        Wallet wallet = new Wallet("Assifa");
//
//        // Tambahkan kartu dan periksa jumlah kartu bertambah
//        wallet.addCard("Visa");
//        wallet.addCard("MasterCard");
//        assertEquals(2, wallet.getCardCount(), "Jumlah kartu harus 2 setelah ditambahkan");
//
//        // Hapus kartu dan periksa jumlah kartu berkurang
//        assertTrue(wallet.removeCard("Visa"), "Kartu Visa harus berhasil dihapus");
//        assertEquals(1, wallet.getCardCount(), "Jumlah kartu harus 1 setelah penghapusan");
//    }
//
//    @Test
//    public void testAddCashAndCoin() {
//        Wallet wallet = new Wallet("Bob");
//
//        // Tambahkan uang kertas dan koin
//        wallet.addCash(50000);
//        wallet.addCash(100000);
//        wallet.addCoin(500);
//        wallet.addCoin(1000);
//
//        // Pastikan total saldo sesuai
//        assertEquals(151500, wallet.getTotalMoney(), "Total uang harus Rp 151.500 setelah penambahan");
//    }
//
//    @Test
//    public void testWithdrawMoney() {
//        Wallet wallet = new Wallet("Charlie");
//
//        // Tambahkan uang
//        wallet.addCash(60000);
//        wallet.addCash(100000);
//        wallet.addCoin(500);
//        wallet.addCoin(1000);
//
//        // Tarik uang dan pastikan berhasil
//        assertTrue(wallet.withdrawMoney(61000), "Harus bisa menarik Rp 61.000");
//        assertEquals(100500, wallet.getTotalMoney(), "Total uang harus Rp 100.500 setelah penarikan");
//
//        // Tarik uang yang melebihi saldo, harus gagal
//        assertFalse(wallet.withdrawMoney(200000), "Harus gagal menarik lebih dari saldo");
//    }
//}

import org.example.Wallet;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {

    private static Wallet wallet;

    @BeforeAll
    static void setup() {
        System.out.println("Inisialisasi Wallet...");
        wallet = new Wallet("Assifa");
    }

    @BeforeEach
    void setupMethod() {
        System.out.println("Reset kondisi dompet sebelum pengujian");
        wallet = new Wallet("Assifa");
    }

    @Test
    void testOwnerSetCorrectly() {
        assertNotNull(wallet, "Wallet seharusnya tidak null");
    }

    @Test
    void testAddAndRemoveCard() {
        wallet.addCard("Visa");
        wallet.addCard("MasterCard");
        assertEquals(2, wallet.getCardCount(), "Jumlah kartu harus 2 setelah ditambahkan");
    }

    @Test
    void testRemoveCard() {
        wallet.addCard("Visa");
        wallet.addCard("MasterCard");
        wallet.removeCard("Visa");
        assertEquals(1, wallet.getCardCount(), "Jumlah kartu harus 1 setelah penghapusan");
    }

    @Test
    void testAddCashAndCoin() {
        wallet.addCash(50000);
        wallet.addCash(100000);
        wallet.addCoin(500);
        wallet.addCoin(1000);
        assertEquals(151500, wallet.getTotalMoney(), "Total uang harus Rp 151.500 setelah penambahan");
    }

    @Test
    void testWithdrawValidAmount() {
        wallet.addCash(60000);
        wallet.addCash(100000);
        wallet.addCoin(500);
        wallet.addCoin(1000);
        assertTrue(wallet.withdrawMoney(61000), "Harus bisa menarik Rp 61.000");
    }

    @Test
    void testBalanceAfterWithdrawal() {
        wallet.addCash(60000);
        wallet.addCash(100000);
        wallet.addCoin(500);
        wallet.addCoin(1000);
        wallet.withdrawMoney(61000);
        assertEquals(100500, wallet.getTotalMoney(), "Total uang harus Rp 100.500 setelah penarikan");
    }

    @Test
    void testWithdrawExceedingBalance() {
        wallet.addCash(60000);
        wallet.addCash(100000);
        wallet.addCoin(500);
        wallet.addCoin(1000);
        assertFalse(wallet.withdrawMoney(200000), "Harus gagal menarik lebih dari saldo");
    }

    @AfterEach
    void cleanupMethod() {
        System.out.println("Pengujian selesai, membersihkan...");
    }

    @AfterAll
    static void cleanup() {
        wallet = null;
        System.out.println("Semua pengujian selesai");
    }
}
