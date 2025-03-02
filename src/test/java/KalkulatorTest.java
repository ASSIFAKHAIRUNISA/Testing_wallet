import org.example.Kalkulator;
import org.junit.jupiter.api.*;

public class KalkulatorTest {

    @Test
    void testTambahDefault(){
        int a = 10;
        int b = 5;

        Kalkulator calc = new Kalkulator(a,b);
        Assertions.assertEquals(15, calc.tambah(), "Equals tambah");
    }

    // untuk tes apakah hasilnya null
    @Test
    void testTambaNotNull(){
        int a = 10;
        int b = 5;

        Kalkulator calc = new Kalkulator(a,b);
        Assertions.assertNotNull(calc.tambah());
    }

    // untuk tes semua result, atau tes atributnya apakah diset dengan benar atau tidak
    @Test
    void testTambahComplete(){
        Kalkulator calc = new Kalkulator(10, 5);
        Assertions.assertAll(
                ()-> Assertions.assertEquals(10, calc.a),
                ()-> Assertions.assertEquals(5, calc.b),
                ()-> Assertions.assertEquals(15, calc.tambah())
        );
    }

    // Life Cycle
    @BeforeAll
    static void setup(){
        System.out.println("beforeall");
    }

    @BeforeEach
    void setupMethod(){
        System.out.println("beforeEach");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("after all");
    }

    @AfterEach
    void afterEach(){
        System.out.println("after each");
    }
}


