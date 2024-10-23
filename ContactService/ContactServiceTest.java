import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");
        assertTrue(service.addContact(contact));
        assertNotNull(service.getContact("12345"));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");
        service.addContact(contact);
        assertTrue(service.deleteContact("12345"));
        assertNull(service.getContact("12345"));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");
        service.addContact(contact);
        assertTrue(service.updateContact("12345", "Jane", "Smith", "0987654321", "456 Avenue"));
        assertEquals("Jane", service.getContact("12345").getFirstName());
    }

    @Test
    public void testNonExistentContactUpdate() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("99999", "Jane", "Smith", "0987654321", "456 Avenue");
        });
    }
}
