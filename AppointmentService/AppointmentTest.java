import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class AppointmentTest {

    @Test
    public void testAppointmentIdCannotBeNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, new Date(System.currentTimeMillis() + 10000), "Description");
        });
        assertEquals("Invalid appointment ID", exception.getMessage());
    }

    @Test
    public void testAppointmentDateCannotBeNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", null, "Description");
        });
        assertEquals("Invalid appointment date", exception.getMessage());
    }

    @Test
    public void testAppointmentDateCannotBeInThePast() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", new Date(System.currentTimeMillis() - 10000), "Description");
        });
        assertEquals("Invalid appointment date", exception.getMessage());
    }

    @Test
    public void testDescriptionCannotBeNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", new Date(System.currentTimeMillis() + 10000), null);
        });
        assertEquals("Invalid description", exception.getMessage());
    }

    @Test
    public void testDescriptionMaxLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", new Date(System.currentTimeMillis() + 10000), "This description exceeds the fifty character limit and should fail");
        });
        assertEquals("Invalid description", exception.getMessage());
    }
}
