import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class AppointmentServiceTest {
    private AppointmentService service;

    @BeforeEach
    public void setUp() {
        service = new AppointmentService();
    }

    @Test
    public void testAddAppointment() {
        Appointment appointment = new Appointment("12345", new Date(System.currentTimeMillis() + 10000), "Test Description");
        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointment("12345"));
    }

    @Test
    public void testAddDuplicateAppointmentId() {
        Appointment appointment1 = new Appointment("12345", new Date(System.currentTimeMillis() + 10000), "Test Description");
        service.addAppointment(appointment1);

        Appointment appointment2 = new Appointment("12345", new Date(System.currentTimeMillis() + 20000), "Another Description");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment2);
        });
        assertEquals("Appointment ID must be unique", exception.getMessage());
    }

    @Test
    public void testDeleteAppointment() {
        Appointment appointment = new Appointment("12345", new Date(System.currentTimeMillis() + 10000), "Test Description");
        service.addAppointment(appointment);
        service.deleteAppointment("12345");
        assertNull(service.getAppointment("12345"));
    }

    @Test
    public void testDeleteNonExistentAppointment() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("99999");
        });
        assertEquals("Appointment ID not found", exception.getMessage());
    }
}
