import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MethodTest {

    @Test
    void testCobaCoba(){
//        System.out.println("test1");
//        Assertions.assertEquals(5,5);

//        equals hanya melihat valuenya
//        String a = new String("test");
//        String b = new String("test");
//        Assertions.assertEquals(a,b, "Equals failed");

//        assertsame, objeknya harus bener bener sama agar pased, seperti di bawah ini
//        String a = new String("test");
//        String b = a;
//
//        Assertions.assertSame(a,b, "Equals failed");

        String string1 = "test";
        Assertions.assertNotNull(string1);
    }

    @Test
    void testCoba2(){
        System.out.println("test2");
    }
}
