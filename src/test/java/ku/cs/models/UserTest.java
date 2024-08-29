package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;
    @BeforeEach
        void setUp(){

        user = new User("karn", "karn.pwd");
    }
    @Test
    @DisplayName("Password should not store in plain text")
    public void testPasswordIsNotStoreInPlainText() {
        User user = new User("user01", "plain-p@ssw0rd");
        String actual = user.getPassword();
        String unexpected = "plain-p@ssw0rd";
        assertNotEquals(unexpected, actual);
    }

    @Test
    @DisplayName("Password should be verified by plain text")
    public void testPasswordShouldBeVerified() {
        User user = new User("user01", "plain-p@ssw0rd");
        boolean actual = user.validatePassword("plain-p@ssw0rd");
        assertTrue(actual);
    }

    @Test
    public void testIsUsername(){
        boolean actual = user.isUsername("karn");
        assertTrue(actual);
    }
    @Test
    public void testSetPassword(){
        user.setPassword("karn.pwd2");
        assertEquals(true , user.validatePassword("karn.pwd2"));
    }


    @Test
    public void testValidatePassword(){
        assertEquals(true,user.validatePassword("karn.pwd"));
    }
}