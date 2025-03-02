import org.example.TransactionSystem;
import org.junit.jupiter.api.*;

public class TransactionTest {

    private static TransactionSystem ts;

    @BeforeAll //menginisiasi saja (setup objek)
    static void setup(){
        TransactionSystem.openConnection();
        ts = new TransactionSystem(500000);
    }

    @BeforeEach //setup method. untuk meminimalisir penggunaan lebih dari 1 method dengan nilai yang berbeda di 1 fungsi. agar lebih mudah untuk mencari tahu mana yang eror
    void setupMethod(){
        ts.resetBalance(500000);
    }

    @Test
    void testDeposit(){
        ts.deposit(100000);

        Assertions.assertEquals(600000, ts.getBalance());
    }

    @Test
    void testWithDraw(){
//        ts.resetBalance(1000000);
        ts.withdraw(100000);

        Assertions.assertEquals(400000, ts.getBalance());
    }

    @AfterEach
    void cleanupMethod(){
        //
    }

    @AfterAll
    static void cleanup(){
        ts = null;
        TransactionSystem.CloseConnection();
    }
}
