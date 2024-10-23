import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Street", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Street");
        });
    }

    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "1234567890", "123 Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Johnathan", "Doe", "1234567890", "123 Street");
        });
    }

    @Test
    public void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345", "123 Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", null, "123 Street");
        });
    }

    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", "This address is way too long for the field");
        });
    }
}
