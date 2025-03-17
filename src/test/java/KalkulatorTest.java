import org.example.Kalkulator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;

// pertemuan 5
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//

public class KalkulatorTest {

//    @Test
//    void testTambahDefault(){
//        int a = 10;
//        int b = 5;
//
//        Kalkulator calc = new Kalkulator(a,b);
//        Assertions.assertEquals(15, calc.tambah(), "Equals tambah");
//    }
//
//    // untuk tes apakah hasilnya null
//    @Test
//    void testTambaNotNull(){
//        int a = 10;
//        int b = 5;
//
//        Kalkulator calc = new Kalkulator(a,b);
//        Assertions.assertNotNull(calc.tambah());
//    }
//
//    // untuk tes semua result, atau tes atributnya apakah diset dengan benar atau tidak
//    @Test
//    void testTambahComplete(){
//        Kalkulator calc = new Kalkulator(10, 5);
//        Assertions.assertAll(
//                ()-> Assertions.assertEquals(10, calc.a),
//                ()-> Assertions.assertEquals(5, calc.b),
//                ()-> Assertions.assertEquals(15, calc.tambah())
//        );
//    }
//
//    // Life Cycle
//    @BeforeAll
//    static void setup(){
//        System.out.println("beforeall");
//    }
//
//    @BeforeEach
//    void setupMethod(){
//        System.out.println("beforeEach");
//    }
//
//    @AfterAll
//    static void afterAll(){
//        System.out.println("after all");
//    }
//
//    @AfterEach
//    void afterEach(){
//        System.out.println("after each");
//    }

    // pertemuan 5
    @Test
    void testCalculatorAdd(){
        Assertions.assertEquals(11, Kalkulator.add(1,10));
        Assertions.assertEquals(30, Kalkulator.add(10,20));
        Assertions.assertEquals(5, Kalkulator.add(2,3));
    }
    // disederhanakan menggunakan ini
    // jika functionnya gak mau ditulis berkali kali bisa memakai parameterizedtest
    @Order(1)
    @ParameterizedTest // memanggil test method (testAddition) dengan parameter, yang diletakkan sebelum test method
    @CsvSource ({ // dipake apabila butuh kombinasi di parameter ( int a, int b, int expected ) test method, jika butuh 1 parameter aja tidak perlu memakai CsvSource
            "1, 10, 11",
            "10, 20, 30",
            "2, 3, 5"
    })
    void testAddition(int a, int b, int expected){
        Assertions.assertEquals(expected, Kalkulator.add(a,b));
    }

    // jika parameternya 1 aja
    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8,10})
    void testEven (int number){
        Assertions.assertTrue(Kalkulator.isEven(number)); // untuk mengecek apakah si numbernya genap semua nggak?
    }

    // untuk parameternya string
    @ParameterizedTest
    @ValueSource(strings = {"abc", "def", "ghi"})
    void testString (String word){

    }

    // untuk parameternya Array dalam String. arraynya dipanggil 2 kali
    static Stream<List<String>> provideArray(){ // harus static
        return Stream.of(
                Arrays.asList("assifaa", "khairu", "nisa"),
                Arrays.asList("abc", "khu", "nia", "poi")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArray") //
    void testYangPakaiArray(List<String> array){
        Assertions.assertNotNull(array);
    }

    // provide dalam satu file yang sama
    static Stream<Arguments> provideAddData(){
        return Stream.of(
                Arguments.of(1,10,11),
                Arguments.of(2,3,5),
                Arguments.of(10,20,30)
        );
    }

    @ParameterizedTest
    @MethodSource("provideAddData")
    void testAddPakaiMethod(int a, int b, int expected){
        Assertions.assertEquals(expected, Kalkulator.add(a, b));
    }

    // provide biar lebih terstruktur, inisiasinya ditaruh di class TestData
    @ParameterizedTest
    @MethodSource("TestData#provideAddData")
    void testAddPakaiMethodStruktur(int a, int b, int expected){
        Assertions.assertEquals(expected, Kalkulator.add(a, b));
    }
    //
}


