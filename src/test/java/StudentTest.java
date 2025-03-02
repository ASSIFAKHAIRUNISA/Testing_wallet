import org.example.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    void tesStudent(){
        Student student1 = new Student("assifa", 7, true);

        Assertions.assertTrue(student1.isDoingMBKM());
    }
}
