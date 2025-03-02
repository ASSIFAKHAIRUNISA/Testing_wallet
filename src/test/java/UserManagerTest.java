import org.example.TransactionSystem;
import org.example.UserManager;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {
    private static UserManager um;

    @BeforeAll
    static void setup(){
        um = new UserManager();
    }

    @BeforeEach
    void setupmethod(){
        um.addUser("Assifa");
    }

    @Test
    void testUser(){
        um.removeUser("Assifa");
//        um.userExists("Assifa");
        assertTrue(um.getUser().isEmpty());
    }

    @Test
    void TestAddUser() {
        um.addUser("Budi");
        assertTrue(um.userExists("Budi"));
        assertEquals(2, um.getUserCount());

    }
    @Test
    void testRemoveUser() {
        um.removeUser("Admin");
        assertFalse(um.userExists("Admin"));
        assertEquals(0, um.getUserCount());
    }
    @AfterEach
    void testEnd() {
        System.out.println("Test End, users: " + um.getUserCount());
        um.clearUsers();
    }
    @AfterAll
    static void cleanup() {
        um = null;
    }
}
